package com.CaluculatorTest.repository;

import com.CaluculatorTest.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface StudentRepository extends JpaRepository<Student, Integer> {
//
//        @Query(name = "SELECT * FROM STUDENT WHERE SUBJECT = :subject", nativeQuery = true)
//        public List<Student> findBySubject(String subject);

//        @Query(name = "SELECT * FROM STUDENT WHERE NAME = :name", nativeQuery = true)
        public List<Student> findByName(String name);


    }
