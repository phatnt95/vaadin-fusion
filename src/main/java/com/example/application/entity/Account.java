package com.example.application.entity;

import com.vaadin.fusion.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Account extends AbstractEntity{
    private String firstName;
    @Nonnull
    private String lastName;
    private String company;
    @Email
    @Nonnull
    private String email;
    @Nonnull
    private String mobile;
    private String website;
    private String industry;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    @Nonnull
    private User owner;
}
