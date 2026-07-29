package br.com.studyHub.security;

import br.com.studyHub.provider.JwtProvider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
@RequiredArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {

    private final JwtProvider jwtProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader("Authorization");
        SecurityContextHolder.getContext().setAuthentication(null);
        System.out.println(header);

        if (header != null) {
            var subject = jwtProvider.validate(header);

            System.out.println(subject);

            if (subject.isEmpty()) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
            request.setAttribute("userId", subject);

            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(subject, null, Collections.emptyList());
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        filterChain.doFilter(request, response);
    }
}
