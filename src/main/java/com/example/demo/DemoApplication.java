package com.example.demo;

import com.example.demo.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;


// Implementação do código: Spring Boot Tutorial
// https://www.youtube.com/watch?v=9SGDpanrc8U

// Implementação do código: Spring Boot Testing Tutorial
// https://www.youtube.com/watch?v=Geq60OVyBPg


// =======================================
// ATENÇÃO: antes de rodar o programa, verifique se o postgres está configurado localmente ou no heroku
// Para fazer isso, verifique o arquivo application.properties
// =======================================

@SpringBootApplication

public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}



}
