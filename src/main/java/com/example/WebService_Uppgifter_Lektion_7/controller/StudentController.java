package com.example.WebService_Uppgifter_Lektion_7.controller;


import com.example.WebService_Uppgifter_Lektion_7.model.Student;
import com.example.WebService_Uppgifter_Lektion_7.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<Student> registerStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentRepository.save(student));
    }

    @GetMapping("/getallstudents")
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentRepository.findAll());
    }

    @DeleteMapping("/deletestudent/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable long id) {
        if (studentRepository.findStudentById(id).isPresent()) {
            studentRepository.deleteById(id);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }
}
