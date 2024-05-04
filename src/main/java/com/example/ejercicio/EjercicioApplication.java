package com.example.ejercicio;

import com.example.ejercicio.entidades.DetalleEnvio;
import com.example.ejercicio.repositorios.DetalleEnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;
@ComponentScan("com.example.ejercicio.dto.cliente")
@SpringBootApplication
public class EjercicioApplication {


	public static void main(String[] args) {
		SpringApplication.run(EjercicioApplication.class, args);
	}
}
