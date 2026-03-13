package com.microservices.school.service;

import com.microservices.school.dto.StudentDTO;
import com.microservices.school.entity.School;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SchoolService {

    public School addSchool(School school);

    public List<School> getAllSchools();

    List<StudentDTO> allStudentsBySchoolName(String schoolName);
}
