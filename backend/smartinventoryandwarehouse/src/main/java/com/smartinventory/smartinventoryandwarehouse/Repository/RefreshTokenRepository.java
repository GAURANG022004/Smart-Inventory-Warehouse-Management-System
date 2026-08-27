package com.smartinventory.smartinventoryandwarehouse.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartinventory.smartinventoryandwarehouse.Entity.RefreshToken;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long>{
	Optional<RefreshToken> findByTokenHash(String tokenHash);
}
