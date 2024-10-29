package com.example.springapi.api.dto;

public class ProfessorInfoDTO {
    private int professorId;
    private String firstName;
    private String lastName;
    private String email;
    private double rating;

    public ProfessorInfoDTO(int professorId,String firstName, String lastName, String email,  double rating) {
        this.professorId = professorId;
        this.firstName = firstName;
        this.rating = rating;
        this.email = email;
        this.lastName = lastName;
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
}
