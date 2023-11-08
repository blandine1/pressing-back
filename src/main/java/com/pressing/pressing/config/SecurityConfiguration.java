package com.pressing.pressing.config;

import com.pressing.pressing.entity.Role;
import com.pressing.pressing.services.UtilisateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
public class SecurityConfiguration {
  /*  private  JwtAuthenticationFilter jwtAuthFilter;

    private  UtilisateurService utilisateurService;
   @Autowired
   public SecurityConfiguration(JwtAuthenticationFilter jwtAuthFilter, UtilisateurService utilisateurService) {
        this.jwtAuthFilter = jwtAuthFilter;
        this.utilisateurService = utilisateurService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/gestionpressing/v1/authentication/**").permitAll()
                        .requestMatchers("/gestionpressing/v1/caissiere/**").hasAnyAuthority(Role.CAISSIERE.name())
                        .anyRequest().authenticated())
                .sessionManagement(manager -> manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider()).addFilterBefore(
                        jwtAuthFilter, UsernamePasswordAuthenticationFilter.class
                );

        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(utilisateurService.userDetailService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
        return config.getAuthenticationManager();
    }*/
}
