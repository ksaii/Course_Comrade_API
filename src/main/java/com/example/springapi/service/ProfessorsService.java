package com.example.springapi.service;


import com.example.springapi.api.dto.ProfessorInfoDTO;
import com.example.springapi.api.model.Classes;
import com.example.springapi.api.model.Professors;
import com.example.springapi.api.repository.ClassesRepository;
import com.example.springapi.api.repository.ProfessorsRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;





@Service
public class ProfessorsService {

    @Autowired
    private final ProfessorsRepository professorsRepository;

    @Autowired
    private ClassesRepository classesRepository;


    @Autowired
    public ProfessorsService(ProfessorsRepository professorsRepository) {
        this.professorsRepository = professorsRepository;
    }

    public List<Professors> getAllProfessors() {
        return professorsRepository.findAll();
    }

    public Professors getProfessorById(int id) {
        return professorsRepository.findById(id).get();
    }

    public Professors createProfessor(Professors professor) {
        return professorsRepository.save(professor);
    }

    public Professors updateProfessor(int id, Professors professor) {
        Optional<Professors> optionalProfessor = professorsRepository.findById(id);
        if(optionalProfessor.isPresent()){
            Professors updatedProfessor = optionalProfessor.get();
            updatedProfessor.setFirstName(professor.getFirstName());
            updatedProfessor.setLastName(professor.getLastName());
            updatedProfessor.setEmail(professor.getEmail());
            updatedProfessor.setRating(professor.getRating());
            return professorsRepository.save(updatedProfessor);
        }else {
            throw new RuntimeException("Professor not found");
        }

    }

    public void deleteProfessor(int id) {
        if (professorsRepository.existsById(id)) {
            professorsRepository.deleteById(id);
        } else {
            throw new RuntimeException("Professor with ID " + id + " not found");
        }
    }

    public List<ProfessorInfoDTO> getProfessorsByClassId(int classId){
        return professorsRepository.getProfessorsByClassId(classId);
    }

    @Transactional
    public void assignClassToProfessor(int professorId, int classId) {
        Optional<Professors> professorOpt = professorsRepository.findById(professorId);
        Optional<Classes> classOpt = classesRepository.findById(classId);

        if (professorOpt.isPresent() && classOpt.isPresent()) {
            Professors professor = professorOpt.get();
            Classes classEntity = classOpt.get();

            professor.getClasses().add(classEntity);
            professorsRepository.save(professor);
        } else {
            throw new EntityNotFoundException("Professor or Class not found");
        }
    }

    @Transactional
    public void removeClassFromProfessor(int professorId, int classId) {
        Optional<Professors> professorOpt = professorsRepository.findById(professorId);
        Optional<Classes> classOpt = classesRepository.findById(classId);
        if (professorOpt.isPresent() && classOpt.isPresent()) {
            Professors professor = professorOpt.get();
            Classes classEntity = classOpt.get();

            professor.getClasses().remove(classEntity);
            professorsRepository.save(professor);
        }else {
            throw new EntityNotFoundException("Professor or Class not found");
        }

    }
}
