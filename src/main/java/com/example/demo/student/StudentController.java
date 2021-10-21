package com.example.demo.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController // allow a class to be recognized as a Spring-managed component and to allow handling of HTTP requests using REST API.
@RequestMapping(path = "api/v1/student")
public class StudentController {

    @GetMapping
    public List<Student> getStudents(){
        return List.of(
                new Student(
                        1L,
                        "Miriam",
                        "miriam@gmail.com",
                        LocalDate.of(2000, Month.JANUARY, 5),
                        21
                )

        );
    }
}
