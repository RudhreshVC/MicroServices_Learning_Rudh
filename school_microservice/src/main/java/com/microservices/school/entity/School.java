package com.microservices.school.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class School {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long schoolId;

    @NotNull
    @Column(nullable= false)
    private String schoolName;

    @NotNull
    @Column(nullable= false)
    private String schoolLocation;

    @NotNull
    @Column(nullable= false)
    @Enumerated(EnumType.STRING)
    private SchoolBoard schoolBoard;
}
