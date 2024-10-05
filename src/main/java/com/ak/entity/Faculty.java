package com.ak.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Faculty")
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "administrator_id")
    private AdministratorProfile administratorProfile;

    // Getters and Setters
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

    public AdministratorProfile getAdministratorProfile() {
        return administratorProfile;
    }

    public void setAdministratorProfile(AdministratorProfile administratorProfile) {
        this.administratorProfile = administratorProfile;
    }
}
