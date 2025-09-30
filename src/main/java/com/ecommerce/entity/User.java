package com.ecommerce.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    
    @NotBlank(message = "Username is Mandatory")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50")
    @Column(unique = true, nullable = false)
    private String username;
    
    @NotBlank(message = "Email is Manadatory")
    @Email(message = "Email should be vaild")
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank(message = "Password is Manadatory")
    @Size(min = 6,message = "Password mininum 6 char")
    @Column(nullable = false)
    private String password;

    @NotBlank(message = "First name is mandatory")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "phone_number")
    private String PhoneNumber;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public enum Role{
        USERS,
        ADMIN
    }

}