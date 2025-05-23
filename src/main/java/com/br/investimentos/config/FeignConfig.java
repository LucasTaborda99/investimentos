package com.br.investimentos.config;

import feign.RequestInterceptor;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public RequestInterceptor requestInterceptor(Dotenv dotenv) {
        return requestTemplate -> {
            String token = dotenv.get("BRAPI_TOKEN");
            requestTemplate.header("Authorization", "Bearer " + token);
        };
    }
}
