package com.CaluculatorTest.repository;

import com.CaluculatorTest.model.StudentMarks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentMarksRepository extends JpaRepository<StudentMarks, Integer>{

    @Query(value = "SELECT * FROM STUDENT_MARKS WHERE STUDENT_ID = :id", nativeQuery = true)
    Optional<List<StudentMarks>> getMarksOfStudent(Integer id);
}
