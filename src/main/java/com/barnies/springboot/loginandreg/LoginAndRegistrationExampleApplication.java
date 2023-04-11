package com.barnies.springboot.loginandreg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/*@EnableJpaRepositories(basePackages = {"com.barnies.springboot.loginandreg.repos"})
@ComponentScan("com.barnies.springboot.loginandreg.repos")
@EntityScan("com.barnies.springboot.loginandreg.repos")*/
@EnableJpaRepositories(basePackages = "com.barnies.springboot.loginandreg.repos")
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class, DataSourceAutoConfiguration.class})
public class LoginAndRegistrationExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginAndRegistrationExampleApplication.class, args);
	}

}
