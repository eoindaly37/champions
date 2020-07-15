package controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({"controller", "model", "dto", "converter"})
@EntityScan({"controller", "model", "dto", "converter"})
@EnableJpaRepositories({"controller", "model", "dto", "converter"})
@SpringBootApplication
public class SpringBootMysqldbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMysqldbApplication.class, args);
	}
}