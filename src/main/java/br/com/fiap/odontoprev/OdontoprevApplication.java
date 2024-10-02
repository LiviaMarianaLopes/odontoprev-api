package br.com.fiap.odontoprev;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info =
@Info(title = "API Odontoprev", version = "0.0.1"))
public class OdontoprevApplication {

	public static void main(String[] args) {
		SpringApplication.run(OdontoprevApplication.class, args);
	}

}
