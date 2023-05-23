package com.project.config.security;

import com.project.services.implementations.UserDetailsServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    @Qualifier("userDetailsServiceImplementation")
    private UserDetailsServiceImplementation pjUserDetailsService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(pjUserDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        return authenticationProvider;
    }

    @Override
    public void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(pjUserDetailsService).passwordEncoder(passwordEncoder);
    }

    public static final String[] ADMIN_URL_MATCHER = {
            "/user/**",
            "/car/**",
            "/book/**"
    };

    public static final String[] USER_ANY_MATCHER = {
            "/user/loggedIn",
            "/user/profile",
            "/user/save",
            "/user/changeProfile",
            "/user/logout",
            "/user/homepage",
            "/book/addBook",
            "/book/deleteLocal",
            "/book/saveOrUpdateBook",
            "/book/selectCar",
    };

//admin | User

    @Override
    public void configure(final HttpSecurity httpSecurity) throws Exception {
        //vede quale metodo per ottenere dettaglio degli utenti e quale codificatore stiamo utilizzando
        httpSecurity
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers(USER_ANY_MATCHER).access("hasAnyRole('CUSTOMER','ADMIN')")
                .antMatchers(ADMIN_URL_MATCHER).hasRole("ADMIN")
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .failureUrl("/login?error")
                .usernameParameter("email")                //nomi dei parametri
                .passwordParameter("password")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/login?forbidden")
                .and()
                .logout()
                .logoutUrl("/login?logout");
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new SuccessHandler();
    }
}
