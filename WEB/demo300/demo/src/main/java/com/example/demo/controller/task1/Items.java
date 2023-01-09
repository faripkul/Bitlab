package com.example.demo.controller.task1;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Items {

    private Long id;
    private String name;
    private String description;
    private double price;
}
