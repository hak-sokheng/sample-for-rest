package com.spring.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "auth_user")
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 1494078177750966904L;

    @Id
    @Column(name = "auth_user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", length = 100, nullable = false, unique = true)
    private String username;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "phone_number", length = 30, unique = true)
    private String phoneNumber;

    @Column(name = "password")
    private String password;

    @Column(name = "last_login_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLoginAt;

    @Column(name = "status")
    private Boolean status;

}
