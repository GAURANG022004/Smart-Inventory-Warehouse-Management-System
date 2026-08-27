package com.smartinventory.smartinventoryandwarehouse.serviceImpl;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import com.smartinventory.smartinventoryandwarehouse.Config.JWTProperties;
import com.smartinventory.smartinventoryandwarehouse.Entity.User;
import com.smartinventory.smartinventoryandwarehouse.Service.JWTService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;


@Service
public class JWTServiceImpl implements JWTService{
	
	private final JWTProperties jwtProperties;
	private final SecretKey secretKey;
	
	public JWTServiceImpl(JWTProperties jwtProperties) {
		this.jwtProperties = jwtProperties;
		this.secretKey =  Keys.hmacShaKeyFor(jwtProperties.getSecret()
															.getBytes(StandardCharsets.UTF_8));
	}

	@Override
	public String generateToken(User user) {
		Date issueAt = new Date();
		Date expiration = new Date(issueAt.getTime() + jwtProperties.getExpiration());
		
		return Jwts.builder()
				.subject(String.valueOf(user.getId()))
				.claim("email", user.getEmail())
				.claim("role", user.getRole().name())
				.issuedAt(issueAt)
				.expiration(expiration)
				.signWith(secretKey)
				.compact();	
	}

	@Override
	public long extractUserId(String token) {
		
		String subject = extractAllClaims(token).getSubject();
		return Long.valueOf(subject);	
	}

	@Override
	public String extractEmail(String token) {
		
		return extractAllClaims(token).get("email",String.class);
	
	}
	

	@Override
	public String extractRole(String token) {
		
		return extractAllClaims(token).get("role", String.class);
	}

	@Override
	public boolean isTokenExpired(String token) {
		
		Date expiration = extractAllClaims(token).getExpiration();
		return expiration.before(new Date());
	}

	@Override
	public boolean validateToken(String token, User user) {
		
		Long userId = extractUserId(token);
		
		return userId.equals(user.getId()) && !isTokenExpired(token);
				
	}
	
	
	private Claims extractAllClaims(String token) {
		
		return Jwts.parser()
				.verifyWith(secretKey)
				.build()
				.parseSignedClaims(token)
				.getPayload();
	}
	
	
	
	

	

}
