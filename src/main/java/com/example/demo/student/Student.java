package com.example.demo.student;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.Period;


@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName= "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @Email
    @Column(nullable = false, unique = true)
    private String email;
    private LocalDate dob;
    @Transient
    private Integer age;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;



    public Student(String name, String email, LocalDate dob, Gender gender) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.gender  = gender;
    }

    public Integer getAge(){
        return Period.between(this.dob, LocalDate.now()).getYears();

    }


}
