package com.cristal.projetoCristal.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class BasicSecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeRequests()
		// URI's liberadas mesmo que o usuário não esteja logado
		.antMatchers(HttpMethod.POST, "/usuarios").permitAll()
		.antMatchers(HttpMethod.POST, "/usuarios/login").permitAll()
		.antMatchers(HttpMethod.POST, "/contatos").permitAll()
		.antMatchers(HttpMethod.GET, "/produto").permitAll()
		.antMatchers(HttpMethod.GET, "/produto/{id}").permitAll()
		.antMatchers(HttpMethod.GET, "/produto/categoria/{categoria}").permitAll()
		.antMatchers(HttpMethod.GET, "/produto/nome/{nome}").permitAll()
		.antMatchers(HttpMethod.GET, "/produto/cor/{cor}").permitAll()
		.antMatchers(HttpMethod.GET, "/produto/tamanho/{tamanho}").permitAll()
		.anyRequest().authenticated()
		.and().httpBasic()
		.and().cors()
		.and().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().csrf().disable();
	}
}
