package com.example.bank_coding.config;

import com.example.bank_coding.domain.user.UserRole;
import com.example.bank_coding.dto.ResponseDto;
import com.example.bank_coding.util.CustomResponseUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfig {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        logger.debug("debug: BCryptPasswordEncoder!!!");
        return new BCryptPasswordEncoder();
    }

    // JWT 서버를 위해 session 사용하지 않는다.
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        logger.debug("debug: SecurityFilterChain!!!");
        http.headers(headers -> headers.frameOptions(frameOption -> frameOption.sameOrigin()));
        http.csrf(csrf -> csrf.disable());
        http.cors(cors -> cors.configurationSource(configurationSource()));
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.formLogin(formLogin -> formLogin.disable());
        http.httpBasic(httpBasic -> httpBasic.disable());
        // exception 가로채기
        http.exceptionHandling(exceptionHandling -> exceptionHandling.authenticationEntryPoint((request, response, authException) -> {
            try {
                CustomResponseUtil.unAuthentication(response, "로그인을 진행해 주세요.");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }));
        http.authorizeHttpRequests(authorizeHttpRequests ->
                authorizeHttpRequests
                        .requestMatchers("/api/s/**").authenticated()
                        .requestMatchers("api/admin/**").hasRole(UserRole.ADMIN.toString())
                        .anyRequest().permitAll()
        );
        return http.build();

    }

    public CorsConfigurationSource configurationSource() {
        logger.debug("debug: configurationSource cors 설정이 SecurityFilterChain 에 등록됨");
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        configuration.addAllowedOriginPattern("*");
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }

}
