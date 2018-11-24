package com.springboot.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author Jay Gagnani
 * @since 2018-11-24
 */

@SpringBootApplication
@ComponentScan(basePackages = { "com.springboot.rest" })
@EnableMongoRepositories("com.springboot.model.mongodb.repositories")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}