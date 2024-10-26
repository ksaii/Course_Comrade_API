package com.example.springapi.api.repository;


import com.example.springapi.api.dto.ProfessorInfoDTO;
import com.example.springapi.api.model.Classes;
import com.example.springapi.api.model.Professors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorsRepository extends JpaRepository<Professors, Integer> {


    @Query("SELECT new com.example.springapi.api.dto.ProfessorInfoDTO(c.professorId ,c.firstName, c.lastName, c.email, c.rating) " +
            "FROM Professors c, ClassProfessors pc " +
            "WHERE pc.classId = :classId AND pc.professorId = c.professorId")
    List<ProfessorInfoDTO> getProfessorsByClassId(@Param("classId") int classId);

}
