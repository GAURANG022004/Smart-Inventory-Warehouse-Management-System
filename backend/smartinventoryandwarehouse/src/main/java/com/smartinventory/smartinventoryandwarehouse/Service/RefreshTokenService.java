package com.smartinventory.smartinventoryandwarehouse.Service;

import com.smartinventory.smartinventoryandwarehouse.DTO.RefreshTokenResult;
import com.smartinventory.smartinventoryandwarehouse.Entity.User;

public interface RefreshTokenService {
	
	RefreshTokenResult createRefreshToken(User user);

    User validateAndGetUser(String rawToken);

    RefreshTokenResult rotateRefreshToken(String rawToken);

    void revokeRefreshToken(String rawToken);
	
	

}
