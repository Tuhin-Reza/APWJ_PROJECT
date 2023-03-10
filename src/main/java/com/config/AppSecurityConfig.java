package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AppSecurityConfig {
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
            .csrf().disable()
            .cors().disable()
            .authorizeRequests()
            .antMatchers("/authorities/**")
            .access("hasRole('ROLE_ADMIN')")
            .antMatchers("/admin/**")
            .access("hasRole('ROLE_ADMIN')")
            .antMatchers("/customers/**")
            .access("hasRole('ROLE_USER')")
            .and()
            .formLogin()
            .loginPage("/users/login")
            .loginProcessingUrl("/authentic")
            .defaultSuccessUrl("/users/decision")
            .failureUrl("/users/loginError")
            .and()
            .logout()
            .logoutUrl("/users/logout")
            .logoutUrl("/customers/logout")
            .addLogoutHandler(new SecurityContextLogoutHandler())
            .deleteCookies()
            .logoutSuccessUrl("/users/login")
            .and()
            .exceptionHandling();
     // .permitAll();
            return http.build();
}


}
