package com.example.doanthuctap.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    CustomUserDetailService customUserDetailService;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**",
                "/static/**",
                "/templates/**",
                "/images/**",
                "/productImages/**",
                "/css/**",
                "/scss/**",
                "/vendor/**",
                "/js/**");
    }//bo qua authen cac package nay

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
//                .antMatchers("/").permitAll()
                .antMatchers("/**/*.js", "/**/*.css", "/**/*.jpg", "/**/*.png" , "/login" , "/register" , "/forgot-password").permitAll()
                .antMatchers("/admin/**").hasAnyAuthority("ADMIN","USER")
                .antMatchers("/client/**").hasAuthority("USER")
                .anyRequest()
                .authenticated()

                //check login
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/client/index")
                .failureUrl("/login?error=true")
                .loginProcessingUrl("/j_spring_security_check")

                    //when you logout
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");

        http.headers().frameOptions().disable();

    }


}
