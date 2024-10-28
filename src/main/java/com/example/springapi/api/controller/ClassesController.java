package com.example.springapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.springapi.service.ClassesService;
import com.example.springapi.api.model.Classes;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/api/classes")
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

    @GetMapping
    public List<Classes> getAllClasses() {
        return classesService.getAllClasses();
    }

    @GetMapping("/{classId}")
    public ResponseEntity<Classes> getClassById(@PathVariable int classId) {
        try{
            Classes classObj = classesService.getClassById(classId);
            return ResponseEntity.ok(classObj);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    }

    //TODO FINISH THESE
    @GetMapping("/{professorId}/classes")
    public ResponseEntity<List<Classes>> getClassesByProfessorId(@PathVariable int professorId) {
        List<Classes> classes = classesService.getClassesByProfessorId(professorId);
        return ResponseEntity.ok(classes);
    }

    @PostMapping
    public ResponseEntity<String> createClass(@RequestBody Classes classes) {
        classesService.createClass(classes);
        return new ResponseEntity<>("Class Created Successfully!", HttpStatus.OK);
    }


    @DeleteMapping("/{professorId}/classes/{classId}")
    public void deleteClass(@PathVariable int professorId, @PathVariable int classId) {
        classesService.deleteClass(professorId, classId);
    }

    @PutMapping("/{classId}")
    public ResponseEntity<Classes> updateClass(@PathVariable int classId, @RequestBody Classes classes) {
        try {
            Classes updatedObj = classesService.updateClass(classId, classes);
            return ResponseEntity.ok(updatedObj);
        }catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }




}
