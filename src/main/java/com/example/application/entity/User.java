package com.example.application.entity;

import com.example.application.ERole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User extends AbstractEntity{
    private String firstName;
    private String lastName;

    private LocalDate dob;

    private String userName;
    private String password;

//    private ERole role;
}