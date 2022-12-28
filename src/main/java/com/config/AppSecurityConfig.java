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

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AppSecurityConfig {
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//        UserDetails userDetails = User.builder()
//                .username("Tom")
//                .password("1234")
//                .authorities("ROLE_USER", "ROLE_ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(userDetails);
//    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/user/**")
//                .access("hasRole('ROLE_ADMIN')")
//                .antMatchers("/creat/**")
//                .access("hasRole('ROLE_USER')")
//                .and()
//                .formLogin(Customizer.withDefaults());
//        return http.build();
//    }

//    @Bean
//    protected void configure(HttpSecurity http) throws Exception{
//        http.authorizeRequests()
//                .antMatchers("/login")
//                .permitAll()
//                .antMatchers("/login/**").hasAnyAuthority("user")
//                .and()
//                .formLogin(form->form
//                        .defaultSuccessUrl("/account/home")
//                        .loginPage("/login/signIn")
//                        .failureUrl("/login?error=true"));
//    }

@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
            .csrf().disable()
            .cors().disable()
            .authorizeRequests()
            .antMatchers("/authoritiesss/**")
            .access("hasRole('ROLE_ADMIN')")
            .antMatchers("/usersss/**")
            .access("hasRole('ROLE_USER')")
            .and()
            .rememberMe()
            .and()
            .formLogin()
            .loginPage("/userss/creates")
            .loginProcessingUrl("/authentic")
            .and()
            .logout()
            .permitAll();
    return http.build();
}
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                // ...
//                .formLogin()
//                .loginPage("/login")
//                .loginProcessingUrl("/perform_login")
//                .defaultSuccessUrl("/homepage.html", true)
//                .failureUrl("/login.html?error=true")
//                .and()
//                .logout()
//                .logoutUrl("/perform_logout")
//                .deleteCookies("JSESSIONID");
//                 return http.build();
//    }


}
