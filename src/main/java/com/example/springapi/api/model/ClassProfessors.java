package com.example.springapi.api.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;

@Entity
@Table(name = "class_professors")
public class ClassProfessors {


    @Id
    @Column(name = "professor_id", nullable = false, length = 100)
    private int professorId;

    @Id
    @Column(name = "class_id", nullable = false, length = 100)
    private int classId;


    public ClassProfessors() {

    }
    public ClassProfessors(int classId, int professorId) {
        this.classId = classId;
        this.professorId = professorId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

}
