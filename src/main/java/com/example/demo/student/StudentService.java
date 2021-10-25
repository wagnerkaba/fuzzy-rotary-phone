package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudents(){
        return studentRepository.findAll();

    }

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if (studentByEmail.isPresent()){
            throw new IllegalStateException("Email taken");
        }
        studentRepository.save(student);


    }

    public void deleteStudent(Long id) {
        boolean exists = studentRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("student with id " + id + " does not exists");
        }
        studentRepository.deleteById(id);

    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Optional<Student> student = studentRepository.findById(studentId);
        if(student.isEmpty()){
            throw new IllegalStateException("student with id " + studentId + " does not exists");
        }
        if(name!=null && name.length()>0){
            student.get().setName(name);
        }
        if(email!=null && email.length()>0){

            Optional<Student> studentByEmail = studentRepository.findStudentByEmail(email);
            if (studentByEmail.isPresent()){
                throw new IllegalStateException("Email taken");
            }

            student.get().setEmail(email);

        }


    }
}
