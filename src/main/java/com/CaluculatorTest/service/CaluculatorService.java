package com.CaluculatorTest.service;

import com.CaluculatorTest.model.Student;
import com.CaluculatorTest.model.StudentMarks;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaluculatorService {

    public String Addition(int[] numbers){
        int sum = 0;
        if(numbers.length >3){
            throw new IllegalArgumentException("The 'numbers' size array is out of bounds");
        }
        for (int number: numbers){
            sum = sum + number;
        }
        return "The Sum of elements in the array is" +" "+ sum;
    }
    public String twoDigitAdd(int num1,int num2){
        int sum =0;
        sum = num1 + num2;
        return  "The sum of given two numbers is "+sum;
    }
    public int getTotalMarks(List<Integer> marks) {
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }
        return totalMarks;
    }
    public int getStudentTotalMarks(List<StudentMarks> studentsMarks) {
        int totalMarks = 0;
        for (StudentMarks sm : studentsMarks) {
            totalMarks += sm.getMarks();
        }
        return totalMarks;
    }
}
