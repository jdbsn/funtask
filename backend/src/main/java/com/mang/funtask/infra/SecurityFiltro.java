package com.mang.funtask.infra;

import com.mang.funtask.servicos.ResponsavelServico;
import com.mang.funtask.servicos.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@AllArgsConstructor
@Component
public class SecurityFiltro extends OncePerRequestFilter {

  private final TokenService tokenService;
  private final ResponsavelServico responsavelServico;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {
    String token = this.recuperarToken(request);

    if(token != null) {
      String email = tokenService.validarToken(token);

      if(!email.isEmpty()) {
        UserDetails user = responsavelServico.encontrarPorEmail(email).get();

        var auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);
      }
    }

    filterChain.doFilter(request, response);
  }

  private String recuperarToken(HttpServletRequest request) {
    var authHeader = request.getHeader("Authorization");

    if(authHeader == null) return null;

    return authHeader.replace("Bearer ", "");
  }

}
