package com.smartinventory.smartinventoryandwarehouse.serviceImpl;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;

import org.springframework.stereotype.Service;

import com.smartinventory.smartinventoryandwarehouse.Config.JWTProperties;
import com.smartinventory.smartinventoryandwarehouse.DTO.RefreshTokenResult;
import com.smartinventory.smartinventoryandwarehouse.Entity.RefreshToken;
import com.smartinventory.smartinventoryandwarehouse.Entity.User;
import com.smartinventory.smartinventoryandwarehouse.Repository.RefreshTokenRepository;
import com.smartinventory.smartinventoryandwarehouse.Service.RefreshTokenService;

@Service
public class RefreshTokenServiceImpl
        implements RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;
    private final JWTProperties jwtProperties;

    private final SecureRandom secureRandom =
            new SecureRandom();

    public RefreshTokenServiceImpl(
            RefreshTokenRepository refreshTokenRepository,
            JWTProperties jwtProperties) {

        this.refreshTokenRepository = refreshTokenRepository;
        this.jwtProperties = jwtProperties;
    
        
    }

    @Override
    public RefreshTokenResult createRefreshToken(User user) {

        // Generate secure random bytes
        byte[] randomBytes = new byte[32];

        secureRandom.nextBytes(randomBytes);

        // Convert bytes to URL-safe String
        String rawToken =
                Base64.getUrlEncoder()
                        .withoutPadding()
                        .encodeToString(randomBytes);

        // Hash raw token
        String tokenHash = hashToken(rawToken);

        // Create database entity
        RefreshToken refreshToken =
                new RefreshToken();

        refreshToken.setUser(user);
        refreshToken.setTokenHash(tokenHash);
        refreshToken.setCreatedAt(Instant.now());

        refreshToken.setExpiresAt(
                Instant.now()
                        .plus(
                            jwtProperties.getRefreshExpiration(),
                            ChronoUnit.MILLIS
                        )
        );

        refreshTokenRepository.save(refreshToken);

        return new RefreshTokenResult(
                refreshToken,
                rawToken
        );
    }

    private String hashToken(String token) {

        try {

            MessageDigest digest =
                    MessageDigest.getInstance("SHA-256");

            byte[] hash =
                    digest.digest(
                        token.getBytes(StandardCharsets.UTF_8)
                    );

            return bytesToHex(hash);

        } catch (NoSuchAlgorithmException e) {

            throw new IllegalStateException(
                    "SHA-256 algorithm not available",
                    e
            );
        }
    }

    private String bytesToHex(byte[] bytes) {

        StringBuilder result =
                new StringBuilder();

        for (byte b : bytes) {

            result.append(
                    String.format("%02x", b)
            );
        }

        return result.toString();
    }

	@Override
	public String getRawToken(RefreshToken refreshToken) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User validateAndGetUser(String rawToken) {

	    String hash = hashToken(rawToken);

	    RefreshToken token =
	            refreshTokenRepository
	                    .findByTokenHash(hash)
	                    .orElseThrow(() ->
	                        new IllegalArgumentException(
	                            "Invalid refresh token"
	                        )
	                    );

	    if (token.getRevokedAt() != null) {
	        throw new IllegalArgumentException(
	                "Refresh token has been revoked"
	        );
	    }

	    if (token.getExpiresAt().isBefore(Instant.now())) {
	        throw new IllegalArgumentException(
	                "Refresh token has expired"
	        );
	    }

	    return token.getUser();
	}

	@Override
	public RefreshTokenResult rotateRefreshToken(
	        String rawToken) {

	    String hash = hashToken(rawToken);

	    RefreshToken oldToken =
	            refreshTokenRepository
	                    .findByTokenHash(hash)
	                    .orElseThrow(() ->
	                        new IllegalArgumentException(
	                            "Invalid refresh token"
	                        )
	                    );

	    if (oldToken.getRevokedAt() != null) {

	        throw new IllegalArgumentException(
	                "Refresh token has already been revoked"
	        );
	    }

	    if (oldToken.getExpiresAt()
	            .isBefore(Instant.now())) {

	        throw new IllegalArgumentException(
	                "Refresh token has expired"
	        );
	    }

	    User user = oldToken.getUser();

	    // Revoke old token
	    oldToken.setRevokedAt(Instant.now());

	    refreshTokenRepository.save(oldToken);

	    // Create new token
	    return createRefreshToken(user);
	}

	@Override
	public void revokeRefreshToken(String rawToken) {

	    String hash = hashToken(rawToken);

	    refreshTokenRepository
	            .findByTokenHash(hash)
	            .ifPresent(token -> {

	                if (token.getRevokedAt() == null) {

	                    token.setRevokedAt(
	                            Instant.now()
	                    );

	                    refreshTokenRepository.save(token);
	                }
	            });
	
	    
	    
	}
}