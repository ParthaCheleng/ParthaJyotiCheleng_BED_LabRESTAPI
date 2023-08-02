package com.gl.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfigurationWithJDBC extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// JDBC authentication, method chaining
		auth.jdbcAuthentication().dataSource(dataSource).withDefaultSchema()
				.withUser(User.withUsername("student").password(getPasswordEncoder().encode("student"))
						.roles("Student"))
				.withUser(
						User.withUsername("admin").password(getPasswordEncoder().encode("admin")).roles("Admin"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests().antMatchers("/studentManagement/list", "/studentManagement/showFormForUpdate").hasRole("Student")
		.antMatchers("/studentManagement/list", "/studentManagement/showFormForUpdate", "/studentManagement/showFormForAdd", "/studentManagement/delete", "/studentManagement/save").hasAnyRole("Admin")
		.antMatchers("/").permitAll()
		.and()
		.formLogin();
	}


	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/h2-console/**");

	}
}
