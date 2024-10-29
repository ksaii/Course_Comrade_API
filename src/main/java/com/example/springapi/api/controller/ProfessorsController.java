package com.example.springapi.api.controller;


import com.example.springapi.api.dto.ProfessorInfoDTO;
import com.example.springapi.service.ProfessorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.springapi.api.model.Professors;
import java.util.List;
import com.example.springapi.api.model.Classes;


@RestController
@RequestMapping("/api/professors")
public class ProfessorsController {

    private ProfessorsService professorsService;

    @Autowired
    public ProfessorsController (ProfessorsService professorsService) {this.professorsService = professorsService;}

    @GetMapping
    public List<Professors> getAllProfessors() {
        return professorsService.getAllProfessors();
    }

    @GetMapping("/{professorId}")
        public Professors getProfessor(@PathVariable int professorId) {
        return professorsService.getProfessorById(professorId);
    }

    @PostMapping
    public Professors createProfessor(@RequestBody Professors professor) {
        return professorsService.createProfessor(professor);
    }

    @PutMapping("/{professorId}")
    public Professors updateProfessor(@PathVariable int professorId, @RequestBody Professors professor) {
        return professorsService.updateProfessor(professorId,professor);
    }

    @DeleteMapping("/{professorId}")
    public ResponseEntity<String> deleteProfessor(@PathVariable int professorId) {
        professorsService.deleteProfessor(professorId);
        return new ResponseEntity<>("Professor deleted Successfully", HttpStatus.OK);
    }

    @GetMapping("/{classId}/classes")
    public List<ProfessorInfoDTO> getProfessorsByClassId(@PathVariable int classId) {
        return professorsService.getProfessorsByClassId(classId);
    }

    @PostMapping("/{professorId}/classes/{classId}")
    public void assignClassToProfessor(@PathVariable int professorId, @PathVariable int classId) {
        professorsService.assignClassToProfessor(professorId,classId);
    }

    @DeleteMapping("/{professorId}/classes/{classId}")
    public void removeClassFromProfessor(@PathVariable int professorId, @PathVariable int classId) {
        professorsService.removeClassFromProfessor(professorId,classId);
    }
}
