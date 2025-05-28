package com.br.investimentos;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@OpenAPIDefinition(info = @Info(title = "Investimentos API", version = "v1"))
@SpringBootApplication
@EnableFeignClients
public class InvestimentosApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvestimentosApplication.class, args);
	}

}
