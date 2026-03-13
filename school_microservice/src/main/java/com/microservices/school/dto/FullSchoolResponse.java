package com.microservices.school.dto;

import com.microservices.school.entity.SchoolBoard;
import lombok.Data;

import java.util.List;

@Data
public class FullSchoolResponse {

    private Long schoolId;

    private String schoolName;

    private String schoolLocation;

    private SchoolBoard schoolBoard;

    private List<StudentDTO> allStudents;
}
