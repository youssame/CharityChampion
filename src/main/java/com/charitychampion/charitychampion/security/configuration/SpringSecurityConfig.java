/*package com.charitychampion.charitychampion.security.configuration;

import org.hibernate.query.sqm.mutation.internal.cte.CteInsertStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        return new InMemoryUserDetailsManager(
                User.withUsername("user1").password(passwordEncoder().encode("1234")).authorities("USER").build(),
                User.withUsername("admin").password(passwordEncoder().encode("1234")).authorities("USER","ADMIN").build()
        );
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/admin").hasAnyRole("ADMIN")
                        .requestMatchers("/user").hasAnyRole("USER")
                )
                .authorizeHttpRequests((authz) -> authz
                        .anyRequest().authenticated()
                )

                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

}
*/