package com.example.application.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
public class AbstractEntity {
    @Id
    @GeneratedValue
    private UUID id;

    public String toJsonString() {
        return "{}";
    }
}
