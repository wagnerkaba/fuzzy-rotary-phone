package com.example.demo.student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;


class StudentRepositoryTest {

    @Autowired
    private StudentRepository underTest;


    @Test
    void ItShouldCheckIfStudentEmailExists() {
        //given
        Student student = new Student(
                "Carlos",
                "carlos@gmail.com",
                LocalDate.of(2000, Month.JANUARY, 5),
                Gender.MALE
                );
        underTest.save(student);

        //when

        //then
    }
}