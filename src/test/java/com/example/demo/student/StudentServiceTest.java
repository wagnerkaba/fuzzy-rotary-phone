package com.example.demo.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
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
    private StudentService underTest;

    @BeforeEach
    void setUp(){
        underTest = new StudentService(studentRepository);
    }



    @Test
    void canGetStudents() {
        //when
        underTest.getStudents();

        //then
        verify(studentRepository).findAll(); //verifica se o método findAll() foi invocado dentro de getStudents()

        //verify(studentRepository).deleteAll(); // Este teste falha porque deleteAll() não é invocado dentro de getStudents()


    }

    @Test
    void canAddNewStudent() {

        //given
        Student student = new Student(
                "Carlos",
                "carlos@gmail.com",
                LocalDate.of(2000, Month.JANUARY, 5),
                Gender.MALE
        );

        //when
        underTest.addNewStudent(student);

        //then
        ArgumentCaptor<Student> studentArgumentCaptor = ArgumentCaptor.forClass(Student.class);

        // verificar se o método studentRepository.save() foi invocado
        // studentArgumentCaptor.capture() => verifica o argumento do método save()
        verify(studentRepository).save(studentArgumentCaptor.capture());

        Student capturedStudent = studentArgumentCaptor.getValue();

        assertThat(capturedStudent).isEqualTo(student);


    }

    @Test
    void deleteStudent() {
    }

    @Test
    void updateStudent() {
    }
}