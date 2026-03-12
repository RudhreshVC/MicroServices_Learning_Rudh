package com.microservices.student.controller;

import com.microservices.student.dto.CgpaDTO;
import com.microservices.student.entity.Student;
import com.microservices.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ListResourceBundle;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student stud){
        return new ResponseEntity<>(studentService.addStudent(stud),HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){
        return new ResponseEntity<>(studentService.getAllStudents(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentByID(@PathVariable Long id){
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }

    @PutMapping ("/updatecgpa/{id}")
    public ResponseEntity<Student> updateCgpaById(@PathVariable Long id, @RequestBody CgpaDTO cgpa){
        return new ResponseEntity<>(studentService.updateCgpaById(id,cgpa.getCgpa()),HttpStatus.OK);
    }

    @GetMapping("bySchoolId/{schoolId}")
    public ResponseEntity<List<Student>> findStudentsBySchoolId(@PathVariable Integer schoolId){
        return new ResponseEntity<>(studentService.findStudentsBySchoolId(schoolId),HttpStatus.OK);
    }



}
