/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kln.se.duncans.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author senanayake
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                   .withUser("dhana").password("123456").roles("USER");
    }
    

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
		.antMatchers("/admin/**").access("hasRole('ROLE_USER')")
		.and()
		    .formLogin().loginPage("/login").failureUrl("/login?error").loginProcessingUrl("/j_spring_security_check").defaultSuccessUrl("/admin")
		    .usernameParameter("j_username").passwordParameter("j_password")
		.and()
		    .logout().logoutSuccessUrl("/login?logout").logoutUrl("/j_spring_security_logout")
		.and()
		    .csrf();
        
        http.csrf().ignoringAntMatchers("/api/**");
    }
}
