package com.um6p.reservation.config;




import com.um6p.reservation.jwt.JwtTokenVerifier;
import com.um6p.reservation.jwt.JwtUsernameAndPasswordAuthenticationFilter;
import com.um6p.reservation.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.crypto.SecretKey;

import static com.um6p.reservation.Roles.ApplicationUserPermission.ADDUSER;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationService authenticationService;
    private final SecretKey secretKey;
    private final JwtConfig jwtConfig;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder,

                                     AuthenticationService userService,
                                     SecretKey secretKey,
                                    JwtConfig jwtConfig
    ) {
        this.passwordEncoder = passwordEncoder;
        this.authenticationService = userService;
        this.secretKey = secretKey;
        this.jwtConfig = jwtConfig;
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and().authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS ,"/**")
                .permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/api/auth/admin")
                .permitAll()
                .and()
                .addFilter(
                        new JwtUsernameAndPasswordAuthenticationFilter(
                                authenticationManager()
                            , jwtConfig
                            , secretKey,
                            passwordEncoder,
                            authenticationService)
                )
                .addFilterAfter(new JwtTokenVerifier(secretKey, jwtConfig),JwtUsernameAndPasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/api/auth/user").hasAuthority("user:add")
                .antMatchers(HttpMethod.GET,"/api/user/getall").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/api/user/delete/**").hasRole("ADMIN")
                .antMatchers("/api/admin/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PUT,"/api/user/update").hasRole("USER")
                .antMatchers(HttpMethod.PUT,"/api/user/updatepassword").hasRole("USER")
                .anyRequest()
                .authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());

    }


    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(authenticationService);
        return provider;
    }

}