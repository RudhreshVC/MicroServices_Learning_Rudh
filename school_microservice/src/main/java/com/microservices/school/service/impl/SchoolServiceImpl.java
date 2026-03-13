package com.microservices.school.service.impl;

import com.microservices.school.dto.StudentDTO;
import com.microservices.school.entity.School;
import com.microservices.school.repository.SchoolRepository;
import com.microservices.school.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private WebClient webClient;

    @Override
    public School addSchool(School school) {
        return schoolRepository.save(school);
    }

    @Override
    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    @Override
    public List<StudentDTO> allStudentsBySchoolName(String schoolName){
        School school = schoolRepository.findSchoolBySchoolName(schoolName);
        return webClient.get().uri("/bySchoolId/"+String.valueOf(school.getSchoolId())).retrieve().bodyToFlux(StudentDTO.class).collectList().block();
    }
}
