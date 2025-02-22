package com.joange.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.joange.service.CustomUserDetailsService;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    // Inyecta el success handler personalizado
    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .userDetailsService(customUserDetailsService)
            .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                // Permitir sin login el registro y recursos estáticos
                .antMatchers("/usuario/register", "/usuario/saveUser", "/css/**", "/js/**").permitAll()
                // Solo ADMIN puede acceder a /admin/**
                .antMatchers("/admin/**").hasRole("ADMIN")
                // El resto requiere autenticación
                .anyRequest().authenticated()
            .and()
            .formLogin()
                .loginPage("/login") // Muestra login.html
                .permitAll()
                // Se usa el successHandler para redirigir según rol
                .successHandler(customAuthenticationSuccessHandler)
            .and()
            .logout()
                .permitAll();
    }
}
