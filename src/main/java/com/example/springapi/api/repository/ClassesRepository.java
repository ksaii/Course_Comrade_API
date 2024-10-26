package com.example.springapi.api.repository;


import com.example.springapi.api.model.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassesRepository extends JpaRepository<Classes, Integer> {
    // Optional: You can add custom query methods if needed, e.g.:

    // Find all classes
    //List<Classes> findAll();

    // Find classes by class code
    //Classes findByClassCode(String classCode);

    @Query("SELECT c FROM Classes c JOIN c.professors p WHERE p.professorId = :professorId")
    List<Classes> findClassesByProfessorId(@Param("professorId") int professorId);
}
