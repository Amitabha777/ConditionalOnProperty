package com.project.codesnippet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching														//To Enable Caching
public class CodesnippetApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodesnippetApplication.class, args);
	}

}
