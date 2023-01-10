package com.example.demo.controller.task2;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_subjects")
@Getter
@Setter
public class BitlabSubject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "credit")
    private int credit;

    @Column(name = "code")
    private String code;

}
