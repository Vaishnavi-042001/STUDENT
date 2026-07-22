package com.example.recruitment.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    private String description;

    // getters, setters, constructors
    public Job() {}
    public Job(String title, String description) {
        this.title = title;
        this.description = description;
    }
    // ... generate getters and setters
}