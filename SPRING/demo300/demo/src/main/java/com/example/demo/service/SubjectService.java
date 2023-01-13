package com.example.demo.service;

import com.example.demo.controller.task2.BitlabSubject;
import com.example.demo.controller.task2.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    @Autowired

    private SubjectRepository subjectRepository;
    public List<BitlabSubject> getSubjects(){
     return subjectRepository.findAll();
    }
}
