package com.pressing.pressing.config;

import com.pressing.pressing.services.JWTService;
import com.pressing.pressing.services.UtilisateurService;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

//@Component
//@RequiredArgsConstructor
//extends OncePerRequestFilter
public class JwtAuthenticationFilter {
/*
    private final JWTService jwtService;

    private final UtilisateurService utilisateurService;

    @Override
    protected void doFilterInternal( HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
         final String authHeader = request.getHeader("Authorization");
         final String jwt;
         String userEnail;
         if(StringUtils.isEmpty(authHeader) || !org.apache.commons.lang3.StringUtils.startsWith(authHeader,"Bearer ")){
            filterChain.doFilter(request, response);
            return;
         }

         jwt = authHeader.substring(7);
         userEnail  = jwtService.extractUserName(jwt);

         if(StringUtils.isEmpty(userEnail) && SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails userDetails = utilisateurService.userDetailService().loadUserByUsername(userEnail);

            if(jwtService.isTokenValid(jwt, userDetails)){
                SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
                UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                       userDetails, null ,userDetails.getAuthorities()
                 );
                token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.setContext(securityContext);
            }
         }
         filterChain.doFilter(request, response);
    }*/
}
