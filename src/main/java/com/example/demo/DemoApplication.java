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

// OBS: Para configurar o banco de dados PostGres no Heroku é necessário fazer com que o Heroku
// utilize as configurações no arquivo application-heroku.properties
//
// Dessa forma, o arquivo application. properties pode ser utilizado para confirar o banco de dado
// local, enquanto o application-heroku.properties é utilizado para configurações do heroku
//
// Para que o Heroku utilize o application-heroku.properties é preciso configurar
// o arquivo procfile (que é um arquivo de configuração do heroku: procure procfile na internet)
//
// No entanto, não sei configurar esse procfile e não estou com tempo agora para fazer isso.
//
// Por isso, eu coloquei as configurações do heroku no arquivo application.properties.
//
// Por isso, se for executar esta API localmente, é preciso alterar o arquivo application.properties para
// configurar o postgres local
//
// Para ver o arquivo procfile configurado corretamente, veja o projeto: https://github.com/wagnerkaba/literate-journey



@SpringBootApplication

public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}



}
