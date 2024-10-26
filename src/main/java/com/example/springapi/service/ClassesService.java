package com.example.springapi.service;

import com.example.springapi.api.repository.ClassesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.springapi.api.model.Classes;

import java.util.ArrayList;

@Service
public class ClassesService {

    private final ClassesRepository classesRepository;

    @Autowired
    public ClassesService(ClassesRepository classesRepository) {
        this.classesRepository = classesRepository;
    }

    // Method to retrieve all classes
    public List<Classes> getAllClasses() {
        return classesRepository.findAll();
    }

    public List<Classes> getClassesByProfessorId(int professorId) {
        return classesRepository.findClassesByProfessorId(professorId);
    }

    // Method to retrieve a class by ID
    /*public Optional<Class> getClassById(Long classId) {
        return classesRepository.findById(classId);
    }

    // Method to create a new class
    public Class createClass(Class newClass) {
        return classesRepository.save(newClass);
    }

    // Method to update an existing class
    public Class updateClass(Long classId, Class updatedClass) {
        if (!classesRepository.existsById(classId)) {
            return null; // or throw an exception
        }
        updatedClass.setClassId(classId);
        return classesRepository.save(updatedClass);
    }

    // Method to delete a class
    public void deleteClass(Long classId) {
        classesRepository.deleteById(classId);
    }

    // Optional: Custom methods
    public List<Class> findClassesByName(String className) {
        return classesRepository.findByClassName(className);
    }*/
}
