package com.example.demo.beans;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Somebean {
 private String name;
 private int amount;




 public String getData(){
     return this.name + " " + this.amount;
 }

}
