package com.nitin.studies.empmgmt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;

import com.nitin.studies.empmgmt.dao.APITokenRepository;

@Configuration
@EnableWebSecurity
public class APISecurityConfig extends WebSecurityConfigurerAdapter {

	@Value("${empmgmt.http.auth.tokenName}")
	private String principalRequestHeader;

	@Autowired
	private APITokenRepository tokenRepository;

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		APIKeyAuthFilter filter = new APIKeyAuthFilter(principalRequestHeader);
		filter.setAuthenticationManager(new AuthenticationManager() {

			@Override
			public Authentication authenticate(Authentication authentication) throws AuthenticationException {
				String principal = (String) authentication.getPrincipal();
				tokenRepository.findById(principal).orElseThrow(
						() -> new BadCredentialsException("The API key was not found or not the expected value."));
				authentication.setAuthenticated(true);
				return authentication;
			}
		});
		httpSecurity.antMatcher("/api/v1/**").csrf().disable().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().addFilter(filter)
				.addFilterBefore(new ExceptionTranslationFilter(new Http403ForbiddenEntryPoint()), filter.getClass())
				.authorizeRequests().anyRequest().authenticated();
	}

}
