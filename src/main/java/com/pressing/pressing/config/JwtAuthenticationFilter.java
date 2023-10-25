package com.pressing.pressing.config;

import com.pressing.pressing.services.JWTService;
import com.pressing.pressing.services.UtilisateurService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
//extends OncePerRequestFilter
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JWTService jwtService;
    private final UtilisateurService utilisateurService;
    @Override
    protected void doFilterInternal( HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
         final String authHeader = request.getHeader("Authorization");
         final String jwt;
         String userEnail;
         if(StringUtils.isEmpty(authHeader) || !org.apache.commons.lang3.StringUtils.startsWith(authHeader,"Bearer ")){
            filterChain.doFilter(request, response);
         }

         if(authHeader == null || !authHeader.contains("Bearer ")){
             filterChain.doFilter(request, response);
             return;
         }
         jwt = authHeader.substring(7);
         userEnail  = jwtService.extractUserName(jwt);

         if(StringUtils.isNotEmpty(userEnail) && SecurityContextHolder.getContext().getAuthentication()==null){
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
    }
}
