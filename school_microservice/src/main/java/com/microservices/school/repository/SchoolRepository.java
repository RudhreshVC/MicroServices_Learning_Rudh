package com.microservices.school.repository;

import com.microservices.school.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<School,Long> {

    School findSchoolBySchoolName(String schoolName);
}
