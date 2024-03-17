package com.school.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.Calendar;
import java.util.Date;


@Entity
@Data
@Table(name="USERS")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String secondName;
    private String lastName;
    private String email;
    private String password;
    private String schoolName;
    private Date createdAt;
    private Date activatedAt;
    private UserStatus userStatus;

    @PrePersist
    public void initiateUser() {
        userStatus = UserStatus.REVOKE;
        createdAt = Calendar.getInstance().getTime();
    }

    @PreUpdate
    public void updateUser() {
        if (this.activatedAt != null)
            userStatus = UserStatus.ACTIVE;
    }
}

enum UserStatus {ACTIVE, REVOKE}
