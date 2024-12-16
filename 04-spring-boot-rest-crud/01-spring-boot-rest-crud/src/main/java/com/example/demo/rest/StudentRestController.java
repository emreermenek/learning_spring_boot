package com.example.demo.rest;

import com.example.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> studentList;

    // define a PostConstruct to load student data at once and only once

    @PostConstruct
    public void init() {
        studentList = new ArrayList<>();
        studentList.add(new Student("Emre", "Ermenek"));
        studentList.add(new Student("Cavit", "Kaya"));
        studentList.add(new Student("Kayra Mert", "Akdag"));

    }

    // define endpoints for "/students" - return a list of students

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentList;
    }

    // define endpoints for "/students/{studentId} - return a student at given index

    @GetMapping("/students/{studentId}") //by default variable names should match
    public Student getStudent(@PathVariable int studentId) {

        // check if id is valid
        if((studentId >= studentList.size()) || (studentId < 0)){
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return studentList.get(studentId);
    }

    // Add an exception handler using @ExceptionHandler

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception){
         // create a student error response
        StudentErrorResponse errorResponse = new StudentErrorResponse();
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());
        // return student error
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // add exception handler for catching any exception (catch all)

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exception){
        // create a student error response
        StudentErrorResponse errorResponse = new StudentErrorResponse();
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());
        // return student error
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }


}
