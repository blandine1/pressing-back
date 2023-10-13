package com.pressing.pressing.config;


//@Configuration
//@EnableWebSecurity
public class SecurityConfiguration {

   // private final JwtAuthenticationFilter jwtAuthFilter;


//    private final AuthenticationProvider authenticationProvider;
//
//    @Autowired
//    public SecurityConfiguration(JwtAuthenticationFilter jwtAuthFilter, AuthenticationProvider authenticationProvider) {
//        this.jwtAuthFilter = jwtAuthFilter;
//        this.authenticationProvider = authenticationProvider;
//    }

    /**
     *
     * @param http
     *
     * @return
     * @throws Exception
     */
  /*  @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http
                .csrf((AbstractHttpConfigurer::disable))
                    .authorizeHttpRequests(auth -> auth
                            .requestMatchers("/gestionpressing/v1/authentication/**").permitAll()
                            .anyRequest().authenticated()
                    )
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }*/
}