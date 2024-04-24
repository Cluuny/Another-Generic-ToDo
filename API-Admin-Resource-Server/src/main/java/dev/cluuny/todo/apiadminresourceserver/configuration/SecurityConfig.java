package dev.cluuny.todo.apiadminresourceserver.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@EnableRedisHttpSession
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.httpBasic(Customizer.withDefaults());
//        http.formLogin(Customizer.withDefaults());
//        http.csrf(AbstractHttpConfigurer::disable);
        http.logout(logout -> logout.logoutUrl("/logout")
                .invalidateHttpSession(true)
                .deleteCookies("SESSION")
                .logoutSuccessUrl("/"));
        http.authorizeHttpRequests(httpRequest ->
                httpRequest
                        .requestMatchers(HttpMethod.POST, "/user").permitAll()
                        .requestMatchers("/error", "/").permitAll()
                        .anyRequest().authenticated()
        );
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .maximumSessions(1)
                .expiredUrl("/")
        );
        return http.build();
    }
}

