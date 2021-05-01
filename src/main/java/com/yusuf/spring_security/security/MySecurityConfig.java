package com.yusuf.spring_security.security;

import com.yusuf.spring_security.domain.enums.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

import javax.sql.DataSource;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;

    @Autowired
    public MySecurityConfig( DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource);

//        UserBuilder userBuilder = User.withDefaultPasswordEncoder();
//
//        auth.inMemoryAuthentication()
//                .withUser(userBuilder.username("yusuf").password("yusuf").roles(Roles.EMPLOYEE.name()))
//                .withUser(userBuilder.username("elena").password("elena").roles(Roles.HR.name()))
//                .withUser(userBuilder.username("ivan").password("ivan").roles(Roles.HR.name(), Roles.MANAGER.name()));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/")
                    .hasAnyRole(Roles.EMPLOYEE.name(), Roles.HR.name(), Roles.MANAGER.name())

                .antMatchers("/hr_info")
                    .hasRole(Roles.HR.name())

                .antMatchers("/manager_info/**")
                    .hasRole(Roles.MANAGER.name())
                .and().formLogin().permitAll();
    }
}
