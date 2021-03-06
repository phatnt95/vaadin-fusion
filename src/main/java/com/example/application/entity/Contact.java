package com.example.application.entity;

import com.vaadin.fusion.Nonnull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    private String company;
    @Email
    @Nonnull
    private String email;
    @Nonnull
    private String mobile;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    @Nonnull
    private User owner;
    private String leadSource;

}
