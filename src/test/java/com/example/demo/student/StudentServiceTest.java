package com.example.demo.student;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class StudentServiceTest {

//    What exactly is a mock object?
//    A mock object is the object that has properties of the real object while skipping the complications of creating a real object now.
//    Simply put, it’s an object made specifically to make our testing easier while providing all the features of a real object.
//    Creating a mocked object is an important part of the Unit testing process. Why specifically we need mock objects? There are multiple reasons:
//    * It’s hard to implement a real object
//    * Objects are not created yet
//    * Real objects will take a noticeable time to execute
//    * Real object is too slow
//    Consider creating a Mock object as a way of having an emulated object that has the properties of a real project without the unnecessary complications of having through creating an actual implementation of that object.

    @Mock
    private StudentRepository studentRepository;
    private  AutoCloseable autoCloseable;
    private StudentService underTest;

    @BeforeEach
    void setUp(){
        autoCloseable = MockitoAnnotations.openMocks(this); // initializes fields annotated with Mockito annotations
        underTest = new StudentService(studentRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();

    }

    @Test
    void canGetStudents() {
        //when
        underTest.getStudents();

        //then
        verify(studentRepository).findAll();


    }

    @Test
    void addNewStudent() {
    }

    @Test
    void deleteStudent() {
    }

    @Test
    void updateStudent() {
    }
}