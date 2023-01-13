package com.example.demo.service;

import com.example.demo.controller.task2.BitlabFaculty;
import com.example.demo.controller.task2.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    public List<BitlabFaculty>getFaculties(){
      return facultyRepository.findAll();
    }
}
