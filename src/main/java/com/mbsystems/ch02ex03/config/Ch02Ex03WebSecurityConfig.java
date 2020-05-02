package com.mbsystems.ch02ex03.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class Ch02Ex03WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure( AuthenticationManagerBuilder auth ) throws Exception {
        var userDetailService = new InMemoryUserDetailsManager();

        var user = User.withUsername("basil")
                .password( "$2a$07$iTWT2EewxJjfTyJhpU54r.pWkiQQNWrGpKr8OyaYCzZBBwoIt/Iwy" )
                .authorities( "READ" )
                .build();

        userDetailService.createUser(user);

        auth.userDetailsService( userDetailService )
                .passwordEncoder( new BCryptPasswordEncoder( 10 ) );
    }

    @Override
    protected void configure( HttpSecurity http ) throws Exception {
        http.authorizeRequests()
            .anyRequest()
            .authenticated()
            .and()
            .httpBasic();
    }
}
