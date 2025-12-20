package com.example.demo.entity;
import org.springframework.context.annotation.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(
    name="users",
    uniqueConstraints={
        @UniqueConstraint(columnNames="email")
    }
)
public class User{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable=false)
    private String name;

    @Email
    @NotBlank
    @Column(nullable=false, unique=true)
    private String email;

    @NotBlank
    @Column(nullable=false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private Role role;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    public User() {
    }
    public User(Long id, String name, String email, String password, Role role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    
    
}



// public class User{
//     private Long id;
//     private String name;
//     private String email;
//     private String password;
//     private String role;
//     public Long getId() {
//         return id;
//     }
//     public void setId(Long id) {
//         this.id = id;
//     }
//     public String getName() {
//         return name;
//     }
//     public void setName(String name) {
//         this.name = name;
//     }
//     public String getEmail() {
//         return email;
//     }
//     public void setEmail(String email) {
//         this.email = email;
//     }
//     public String getPassword() {
//         return password;
//     }
//     public void setPassword(String password) {
//         this.password = password;
//     }
//     public String getRole() {
//         return role;
//     }
//     public void setRole(String role) {
//         this.role = role;
//     }
//     public User() {
//     }
//     public User(Long id, String name, String email, String password, String role) {
//         this.id = id;
//         this.name = name;
//         this.email = email;
//         this.password = password;
//         this.role = role;
//     }

    
// }