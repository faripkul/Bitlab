package com.example.demo.controller.task2;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface SubjectRepository extends JpaRepository<BitlabSubject, Long> {
}
