package com.example.recruitment.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "candidates")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    private String skills;

    // getters, setters, constructors
    public Candidate() {}
    public Candidate(String name, String email, String skills) {
        this.name = name;
        this.email = email;
        this.skills = skills;
    }
    // ... generate getters and setters
}