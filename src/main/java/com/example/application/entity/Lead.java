package com.example.application.entity;

import com.vaadin.fusion.Nonnull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "leads")
public class Lead extends AbstractEntity{
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
    private User owner;
}
