package com.example.springapi.api.model;

import com.example.springapi.api.model.*;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "professors")
public class Professors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int professorId;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column (name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column (name = "email", nullable = false, length = 100)
    private String email;

    @Column (name = "rating", nullable = false)
    private double rating;


    @ManyToMany
    @JoinTable(
            name = "class_professors",
            joinColumns = @JoinColumn(name = "professor_id"),
            inverseJoinColumns = @JoinColumn(name = "class_id")
    )
    private List<Classes> classes;


    public Professors() {

    }

    public Professors(int professorId, String firstName,
                      String lastName, String email, double rating) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.rating = rating;
        this.professorId = professorId;
    }

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<Classes> getClasses() {
        return classes;
    }

}
