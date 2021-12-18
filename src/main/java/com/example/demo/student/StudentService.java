package com.example.demo.student;

import com.example.demo.student.exception.BadRequestException;
import com.example.demo.student.exception.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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
        Boolean existsEmail = studentRepository
                .checkIfEmailExists(student.getEmail());
        if (existsEmail) {
            throw new BadRequestException(
                    "Email " + student.getEmail() + " taken");
        }
        studentRepository.save(student);


    }

    public void deleteStudent(Long id) {
        verifyStudentId(id);
        studentRepository.deleteById(id);

    }



    @Transactional
    public void updateStudent(Student student) {

        verifyStudentId(student.getId());
        studentRepository.save(student);



    }
    private void verifyStudentId(Long id) {
        boolean exists = studentRepository.existsById(id);
        if(!exists){
            throw new StudentNotFoundException("student with id " + id + " does not exists");
        }
    }


}
