package com.microservices.school.controller;

import com.microservices.school.dto.StudentDTO;
import com.microservices.school.entity.School;
import com.microservices.school.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController
@RequestMapping("/school")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @PostMapping
    public ResponseEntity<School> addSchool(@RequestBody School school){
        return new ResponseEntity<>(schoolService.addSchool(school), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<School>> getAllSchools(){
        return new ResponseEntity<>(schoolService.getAllSchools(),HttpStatus.OK);
    }

    @GetMapping("/findStudentsByName/{schoolName}")
    public ResponseEntity<List<StudentDTO>> allStudentsBySchoolName(@PathVariable String schoolName){
        return new ResponseEntity<>(schoolService.allStudentsBySchoolName(schoolName),HttpStatus.OK);
    }
}
