package com.spring.example.dto.product;

import com.spring.example.model.UserEntity;
import lombok.Data;
import java.util.Date;

/**
 * Created by Hak Sokheng
 * Date     : 6/14/2022, 10:10 AM
 * Email    : sokheng.hak@prasac.com.kh
 */
@Data
public class UserResponse {
    private Long id;
    private String username;
    private String email;
    private String phoneNumber;
    private String password;
    private Date lastLoginAt;
    private Boolean status;

    public UserResponse(UserEntity userEntity) {
        this.id = userEntity.getId();
        this.username = userEntity.getUsername();
        this.email = userEntity.getEmail();
        this.phoneNumber = userEntity.getPhoneNumber();
        this.password = userEntity.getPassword();
        this.lastLoginAt = userEntity.getLastLoginAt();
        this.status = userEntity.getStatus();
    }
}
