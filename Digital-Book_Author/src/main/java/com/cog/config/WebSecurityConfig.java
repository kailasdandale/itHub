package com.cog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.cog.filter.JwtRequestFilter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig  {
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	@Autowired
	private UserDetailsService jwtUserDetailsService;
	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
		@Bean
		public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		    return authenticationConfiguration.getAuthenticationManager();
		}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
		
 auth.userDetailsService(jwtUserDetailsService);
//		auth.userDetailsService(jwtUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}

	// updated-> new
		@Bean
	    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
// We don't need CSRF for this example
		httpSecurity.cors().and()
		.csrf().disable()
// dont authenticate this particular request
				.authorizeRequests()
				
			//	.antMatchers("/authenticate", "/api/books/v1/author/sinup").permitAll()
				
				.antMatchers("/authenticate", "/api/books/v1/author/**").permitAll()
				.antMatchers("/api/books/v1/author/sinup/**").access("hasAnyRole('author','AUTHOR')")
				.antMatchers("/api/books/v1/author/**").access("hasRole('AUTHOR')")
				
				
			//	.antMatchers("/admin/**").access("hasRole('ADMIN')")
				
				
// all other requests need to be authenticated
				.anyRequest().authenticated().and()
// make sure we use stateless session; session won't be
// used to store user's state.
				.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
// Add a filter to validate the tokens with every request
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		
		return httpSecurity.build();
	}
}
