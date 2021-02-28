package com.ravi.boot.PatientApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ravi.boot.PatientApplication.audit.AuditorAwareImpl;
import com.ravi.boot.PatientApplication.menu.MainMenu;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@ComponentScan(basePackages = {"com.ravi.boot"})
@EnableJpaRepositories("com.ravi.boot.PatientApplication.repository")
public class PatientApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(PatientApplication.class);

	@Bean
	public AuditorAware<String> auditorAware() {
		return new AuditorAwareImpl();
	}

	public static void main(String[] args) {
	SpringApplication.run(PatientApplication.class, args);
	

	}
	@Autowired
	MainMenu mainMenu;

	@Override
	public void run(String... args) throws Exception {
		mainMenu.init();
		
	}

}



