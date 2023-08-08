package com.CaluculatorTest.controller;

import com.CaluculatorTest.model.Student;
import com.CaluculatorTest.model.StudentMarks;
import com.CaluculatorTest.repository.StudentMarksRepository;
import com.CaluculatorTest.repository.StudentRepository;
import com.CaluculatorTest.service.CaluculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CaluculatorService caluculatorService;
    @Autowired
    private StudentMarksRepository studentMarksRepository;

    @PutMapping("/student")
    public ResponseEntity<Integer> saveStudent(@RequestBody Student student) {
        Student save = studentRepository.save(student);
        return new ResponseEntity<>(save.getId(), HttpStatus.CREATED);
    }


    @GetMapping("/student")
    public ResponseEntity<Student> getStudent(@RequestParam Integer id) {
        Optional<Student> byId = studentRepository.findById(id);
        if (byId.isPresent()) {
            return new ResponseEntity<>(byId.get(), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

//
//    @GetMapping("/subject")
//    public ResponseEntity<List<Student>> getStudentBySubject(@RequestParam String subject) {
//        List<Student> students = studentRepository.findBySubject(subject);
//        return new ResponseEntity<>(students, HttpStatus.OK);
//    }
    @GetMapping("/totalmarks")
    public int getTotal(@RequestParam Integer id ) {
       Optional<List<StudentMarks>> marks = studentMarksRepository.getMarksOfStudent(id);
       if(marks.isPresent())
            return caluculatorService.getStudentTotalMarks(marks.get());
       else
           return 0;
    }

    @GetMapping("/total")
    public ResponseEntity<Integer> getTotalMarks(@RequestParam Integer id) {
        Optional<Student> byId = studentRepository.findById(id);
        if (byId.isPresent()) {
            List<StudentMarks> marksList = byId.get().getMarksList();
            int total = 0;
            for (StudentMarks marks : marksList) {
                total += marks.getMarks();
            }
            return new ResponseEntity<>(total, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(0, HttpStatus.NO_CONTENT);
    }

}
