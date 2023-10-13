package com.pressing.pressing.config;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

//@Component
//@RequiredArgsConstructor
//@AllArgsConstructor
//cette classe extennd OncePerRequestFilter
public class JwtAuthenticationFilter {
    //1
  /*  private JwtService jwtService;
    private UserDetailsService userDetailsService;
    @Override
    protected void doFilterInternal(
           @NotNull HttpServletRequest request,
           @NotNull HttpServletResponse response,
           @NotNull FilterChain filterChain
    ) throws ServletException, IOException {
         final String authHeader = request.getHeader("authentication");
         final String jwt;
         String userEnail;
         if(authHeader == null || !authHeader.contains("Bearer ")){
             filterChain.doFilter(request, response);
             return;
         }
         jwt = authHeader.substring(7);
         userEnail  = jwtService.extractUserName(jwt);
         if(userEnail != null && SecurityContextHolder.getContext().getAuthentication() == null){
             UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEnail);
             if(jwtService.isTokenValid(jwt, userDetails)){
                 UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                         userDetails, null
                         ,userDetails.getAuthorities()
                 );
                  authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                  SecurityContextHolder.getContext().setAuthentication(authenticationToken);
             }
         }

         filterChain.doFilter(request, response);
    }*/
}
