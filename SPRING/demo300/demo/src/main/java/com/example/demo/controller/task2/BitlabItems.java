package com.example.demo.controller.task2;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "t_items")
@Getter
@Setter
public class BitlabItems {

    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
    @Column(name = "id")
    private Long id;

    @Column(name = "item_name")
    private String name;

    @Column(name = "item_description")
    private String description;

    @Column(name = "item_price")
    private Double price;

    @ManyToOne
    private BitlabFaculty faculty;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<BitlabSubject> subjects;

}
