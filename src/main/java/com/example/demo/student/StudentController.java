package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // allow a class to be recognized as a Spring-managed component and to allow handling of HTTP requests using REST API.
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    //@Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

}
