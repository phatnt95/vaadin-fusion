package com.example.application.entity;

import com.vaadin.fusion.Nonnull;
import lombok.*;

import javax.persistence.Entity;
import javax.validation.constraints.Email;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contact extends AbstractEntity {

    private String firstName;
    @Nonnull
    private String lastName;
    private String phone;
    @Nonnull
    @Email
    private String email;

//    @Override
//    public String toJsonString() {
//        return "{" +
//                "}";
//    }
}
