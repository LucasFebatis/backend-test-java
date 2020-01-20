package com.febatis.xerifetest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = { "com.febatis.xerifetest.entity" })
@EnableJpaRepositories(basePackages = { "com.febatis.xerifetest.repository" })
@ComponentScan(basePackages = {"com.febatis.xerifetest.controller"})
public class XerifetestApplication {

	public static void main(String[] args) {
		SpringApplication.run(XerifetestApplication.class, args);
	}

}
