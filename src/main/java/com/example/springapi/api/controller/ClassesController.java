package com.example.springapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.springapi.service.ClassesService;
import com.example.springapi.api.model.Classes;
import java.util.Optional;
import java.util.List;

@RestController
public class ClassesController {

    private ClassesService classesService;

    @Autowired
    public ClassesController(ClassesService classesService) {this.classesService = classesService;}

    /*@GetMapping("/classes")
    public Classes getClass(@RequestParam Integer id){
        Optional classes = classesService.getClasses(id);
        if(classes.isPresent()) {
            return (Classes) classes.get();
        }
        return null;
    }*/

    @GetMapping("/getAllClasses")
    public List<Classes> getAllClasses() {
        return classesService.getAllClasses();
    }

    //TODO FINISH THESE
    /*@GetMapping("/{professorId}/classes")
    public ResponseEntity<List<Classes>> getClassesByProfessorId(@PathVariable int professorId) {
        List<Classes> classes = classesService.getClassesByProfessorId(professorId);
        return ResponseEntity.ok(classes);
    }

    @PostMapping("/{professorId}/classes/{classId}")
    public void assignClassToProfessor(@PathVariable Long professorId, @PathVariable Long classId) {
        // Logic to assign a class to a professor
    }

    @DeleteMapping("/{professorId}/classes/{classId}")
    public void removeClassFromProfessor(@PathVariable Long professorId, @PathVariable Long classId) {
        // Logic to remove the association between a professor and a class
    }

    @PostMapping("/{professorId}/classes/{classId}")
    public void assignClassToProfessor(@PathVariable Long professorId, @PathVariable Long classId) {
        // Logic to assign a class to a professor
    }

    @DeleteMapping("/{professorId}/classes/{classId}")
    public void removeClassFromProfessor(@PathVariable Long professorId, @PathVariable Long classId) {
        // Logic to remove the association between a professor and a class
    }*/



}
