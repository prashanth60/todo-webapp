package com.todoapp.security;

import javax.sql.DataSource;

import com.todoapp.app.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userDetailsService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    DataSource datasource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(datasource)
                .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String loginPage = "/login";
        String logoutPage = "/logout";

        http.authorizeRequests()
                .anyRequest()
                .fullyAuthenticated()
                .and()
                .formLogin()
                .loginPage(loginPage)
                .failureUrl("/login?error")
                .permitAll()
                .and()
                .logout()
                .logoutUrl(logoutPage)
                .logoutSuccessUrl("/login?logout")
                .permitAll()
                .and()
                .csrf();
        // http
        // .authorizeRequests()
        // .antMatchers("/").permitAll()
        // .antMatchers(loginPage).permitAll()
        // .antMatchers(HttpMethod.GET, "/registration").permitAll()
        // .antMatchers("/admin/**").hasAuthority("USER") // admin
        // // .anyRequest().authenticated()
        // .and()
        // .csrf().disable()
        // .formLogin()
        // .loginPage(loginPage)
        // .loginPage("/")
        // .failureUrl("/login?error=true")
        // .defaultSuccessUrl("/admin/home")
        // .usernameParameter("user_name")
        // .passwordParameter("password")
        // .and()
        // .logout()
        // .logoutRequestMatcher(new AntPathRequestMatcher(logoutPage))
        // .logoutSuccessUrl(loginPage).and().exceptionHandling();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }
}
