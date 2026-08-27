package com.smartinventory.smartinventoryandwarehouse.DTO;


import com.smartinventory.smartinventoryandwarehouse.Entity.RefreshToken;

public record RefreshTokenResult(
        RefreshToken entity,
        String rawToken
) {
}