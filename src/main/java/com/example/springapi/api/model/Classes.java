package com.example.springapi.api.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "classes")
public class Classes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int classId;

    @Column(name = "class_name", nullable = false, length = 100)
    private String className;

    @Column(name = "class_code", nullable = false, unique = true, length = 20)
    private String classCode;

    @Column(nullable = false, columnDefinition = "int default 0")
    private int totalStudents;

    @Column(nullable = false)
    private int maxStudents;

    private String description;

    @ManyToMany(mappedBy = "classes")


    private List<Professors> professors;

    public Classes() {

    }
    // Parameterized constructor
    public Classes(int classId, String className, String classCode, int totalStudents,
                   int maxStudents, String description) {
        this.classId = classId;
        this.className = className;
        this.classCode = classCode;
        this.totalStudents = totalStudents;
        this.maxStudents = maxStudents;
        this.description = description;
    }


    // Getters and setters
    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public int getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(int totalStudents) {
        this.totalStudents = totalStudents;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public void setMaxStudents(int maxStudents) {
        this.maxStudents = maxStudents;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
