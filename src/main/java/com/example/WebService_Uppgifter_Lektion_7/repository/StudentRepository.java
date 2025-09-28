package com.example.WebService_Uppgifter_Lektion_7.repository;

import com.example.WebService_Uppgifter_Lektion_7.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findStudentById(Long id);

}
