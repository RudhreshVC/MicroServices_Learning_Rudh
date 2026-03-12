package com.microservices.student.service.impl;

import com.microservices.student.entity.Student;
import com.microservices.student.repository.StudentRepository;
import com.microservices.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }


    @Override
    public Student updateCgpaById(Long id, Double cgpa) {
        Student stud =studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student Id is not found"));
        stud.setCgpa(cgpa);
        return studentRepository.save(stud);
    }
}
