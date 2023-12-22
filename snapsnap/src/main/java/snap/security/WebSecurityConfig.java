package snap.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/**").permitAll()
                        .anyRequest().authenticated()
                ).formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
              );
        return http.build();
    }
    public class SecurityConfiguration {
        @Bean
        public InMemoryUserDetailsManager userDetailsService() {
            UserDetails admin = User.withDefaultPasswordEncoder()
                    .username("admin")
                    .password("adminPassword")
                    .roles("ADMIN")
                    .build();
            return new InMemoryUserDetailsManager(admin);
        }
    }


}
