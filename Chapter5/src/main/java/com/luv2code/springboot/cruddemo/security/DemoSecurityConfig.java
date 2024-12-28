package com.luv2code.springboot.cruddemo.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {
// add sup for jdbc authentication
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

//        // Tùy chỉnh truy vấn nếu cần
//        userDetailsManager.setUsersByUsernameQuery(
//                "SELECT username, password, enable FROM users WHERE username = ?");
//        userDetailsManager.setAuthoritiesByUsernameQuery(
//                "SELECT username, authority FROM authorities WHERE username = ?");

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "SELECT user_id, pw, active FROM members WHERE user_id=?"
        );

        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "SELECT user_id, role FROM roles WHERE user_id=?"
        );
        return jdbcUserDetailsManager;
    }


    @Bean
    public SecurityFilterChain filerChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
        );

//        use basic authentication
        http.httpBasic(Customizer.withDefaults());


//        disable csrf
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}




//@Bean
//public InMemoryUserDetailsManager userDetailsManager() {
//    UserDetails john = User.builder()
//            .username("john")
//            .password("{noop}test123")
//            .roles("EMPLOYEE")
//            .build();
//
//    UserDetails mary = User.builder()
//            .username("mary")
//            .password("{noop}test123")
//            .roles("EMPLOYEE", "MANAGER")
//            .build();
//
//    UserDetails susan = User.builder()
//            .username("susan")
//            .password("{noop}test123")
//            .roles("EMPLOYEE", "ADMIN", "MANAGER")
//            .build();
//
//    return new InMemoryUserDetailsManager(john, mary, susan);
//}