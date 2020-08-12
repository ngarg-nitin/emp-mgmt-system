package com.nitin.studies.empmgmt.security;

public class APISecurityConfig {
//@Configuration
//@EnableWebSecurity
//public class APISecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Value("${empmgmt.http.auth.tokenName}")
//	private String principalRequestHeader;
//
//	@Autowired
//	private APITokenRepository tokenRepository;
//
//	@Override
//	protected void configure(HttpSecurity httpSecurity) throws Exception {
//		APIKeyAuthFilter filter = new APIKeyAuthFilter(principalRequestHeader);
//		filter.setAuthenticationManager(new AuthenticationManager() {
//
//			@Override
//			public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//				String principal = (String) authentication.getPrincipal();
//				tokenRepository.findById(principal).orElseThrow(
//						() -> new BadCredentialsException("The API key was not found or not the expected value."));
//				authentication.setAuthenticated(true);
//				return authentication;
//			}
//		});
//		httpSecurity.antMatcher("/api/v1/**").csrf().disable().sessionManagement()
//				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().addFilter(filter)
//				.addFilterBefore(new ExceptionTranslationFilter(new Http403ForbiddenEntryPoint()), filter.getClass())
//				.authorizeRequests().anyRequest().authenticated();
//	}

}
