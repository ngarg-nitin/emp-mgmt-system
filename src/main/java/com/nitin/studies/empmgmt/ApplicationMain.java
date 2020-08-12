package com.nitin.studies.empmgmt;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.nitin.studies.empmgmt.dao.APITokenRepository;
import com.nitin.studies.empmgmt.data.APIToken;

@SpringBootApplication
public class ApplicationMain {

	@Value("${empmgmt.http.auth.tokenValues}")
	private List<String> tokenValues;

	public static void main(String[] args) {
		SpringApplication.run(ApplicationMain.class, args);
	}

//	@Bean
//	CommandLineRunner populateAPIToken(final APITokenRepository tokenRepo) {
//
//		CommandLineRunner runner = (String[] args) -> {
//			tokenValues.stream().map(APIToken::new).forEach(tokenRepo::save);
//		};
//		return runner;
//	}

}
