package dev.cluuny.todo.apiauthorizationserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class ApiAuthorizationServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiAuthorizationServerApplication.class, args);
    }
}
