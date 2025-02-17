package ad.Trivial.config.securiti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SpringSecurity{

    @Autowired
    @Lazy  // Hace que la inyección sea perezosa y evite la dependencia circular
    private UserDetailsServiceImpl userDetailsService;


    @Autowired
    @Lazy  // Inyección perezosa de JwtRequestFilter para evitar el ciclo
    private JwtRequestFilter jwtRequestFilter;  // Inyección automática


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // Deshabilitar CSRF
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Sin sesiones
                .authorizeHttpRequests(auth -> auth
                        // Rutas públicas
                        .requestMatchers("/auth/login", "/auth/register").permitAll()
                        // Rutas para el ADMIN
                        .requestMatchers(HttpMethod.POST, "/crud/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/crud/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/crud/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/crud/**").hasRole("ADMIN")
                        // Rutas para los usuarios normales
                       .requestMatchers(HttpMethod.GET, "/api/**").hasAnyRole("USUARIO", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/**").hasAnyRole("USUARIO", "ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/**").hasAnyRole("USUARIO", "ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/**").hasAnyRole("USUARIO", "ADMIN")
                        // Cualquier otra petición requiere autenticación
                        .anyRequest().authenticated()
                )
                .addFilterAfter(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class); // Filtro JWT

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
}
