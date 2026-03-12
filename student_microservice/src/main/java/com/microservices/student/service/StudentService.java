package com.microservices.student.service;

import com.microservices.student.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    public Student addStudent(Student student);

    public List<Student> getAllStudents();

    public Student getStudentById(Long id);

    public Student updateCgpaById(Long id, Double cgpa);
}
