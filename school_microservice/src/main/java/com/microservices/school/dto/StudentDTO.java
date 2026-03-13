package com.microservices.school.dto;

import lombok.Data;

@Data
public class StudentDTO {

    private Long student_id;

    private String firstName;

    private String lastName;

    private Integer age;

    private String email;

    private Double cgpa;
}
