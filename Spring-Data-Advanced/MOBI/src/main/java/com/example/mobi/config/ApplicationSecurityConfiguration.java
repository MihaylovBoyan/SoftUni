package com.example.mobi.config;

import com.example.mobi.model.entity.enums.UserRoleEnum;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public ApplicationSecurityConfiguration(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                // With this line we allow access to all static resources
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                // The next line allows access to the home, login and registration pages for everyone.
                .antMatchers("/", "/users/login", "/users/register").permitAll()
                // We permit the page below only for admin users.
                .antMatchers("/statistics").hasRole(UserRoleEnum.ADMIN.name())
                // Next we forbid all other pages for unauthenticated users.
                .antMatchers("/**").authenticated()
                // Configure login with login HTML form with two input files.
                .and().formLogin()
                // Our login page is located at http:/<serverAddress>:<port>/users/login
                .loginPage("/users/login")
                // This is the name of the <input..> in the login form where the user enters his username/email etc.
                // The value of this input will be presented to ou User details service
                // Those that want to name the input field different, e.g email may chose the value below.
                .usernameParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY)
                // The name of the <input..> HTML field that keeps the password
                .passwordParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY)
                // The place where we should land in case that the login is successful.
                .defaultSuccessUrl("/")
                // The place where I should land if the login is NOT successful.
                .failureForwardUrl("/users/login-error")
                // This is the URL which spring will implement for me and will log the user out.
                .and().logout().logoutUrl("/users/logout")
                // Where to go after the logout.
                .logoutSuccessUrl("/")
                // Remove the session from server.
                .invalidateHttpSession(true)
                // Delete the cookie that references my session.
                .deleteCookies("JSESSIONID");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // This gives spring two important components.
        // 1. Our user details service that translates usernames/emails, phone numbers, etc. to UserDetails
        // 2. Password encoder - the component that can decide if the user password matches
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);




    }
}
