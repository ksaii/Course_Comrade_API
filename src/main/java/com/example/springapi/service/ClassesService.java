package com.example.springapi.service;

import com.example.springapi.api.repository.ClassesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.springapi.api.model.Classes;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.NoSuchElementException;

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

    // Method to create a new class
    public void createClass(Classes newClass) {
        try {
            classesRepository.save(newClass); // Attempt to save the new class
            // Log success or perform other success actions here if needed
        } catch (Exception e) {
            // Handle or log the exception if the save fails
            throw new RuntimeException("Failed to create class", e);
        }
    }


    public void deleteClass( int professorId, int classId) {
        if(classesRepository.existsById(classId)) {
            classesRepository.deleteById(classId);
        }else {
            throw new RuntimeException("Class with ID " +classId + " not found");
        }
    }

    public Classes getClassById(int classId) {
        return classesRepository.findById(classId)
                .orElseThrow(() -> new NoSuchElementException("Class not found with id: " + classId));
    }



    // Method to update an existing class
    public Classes updateClass(int classId, Classes updatedClass) {
        if (classesRepository.existsById(classId)) {
            updatedClass.setClassId(classId);
            return classesRepository.save(updatedClass);
        }else{
            throw new RuntimeException("Class not found with id: " + classId);
        }
    }


    /*
    // Optional: Custom methods
    public List<Class> findClassesByName(String className) {
        return classesRepository.findByClassName(className);
    }*/
}
