package com.example.pool.services;

import com.example.pool.security.dao.IRepoUser;
import com.example.pool.security.entities.db.Role;
import com.example.pool.security.entities.db.User;
import lombok.RequiredArgsConstructor;

import org.springframework.core.annotation.Order;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
@Order(100)
@RequiredArgsConstructor
public class HeaderAttributesFilter implements Filter {
    private final IRepoUser repo;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        setAttrs(servletRequest);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private void setAttrs(ServletRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            request.setAttribute("auth", "false");
        } else {
            if (auth.getPrincipal().equals("anonymousUser")) {
                request.setAttribute("auth", "false");
            }
            else {
                request.setAttribute("auth", "true");
                request.setAttribute("userName", auth.getName());
                User user = repo.findByUsername(auth.getName()).get();
                request.setAttribute("canWrite", user.getRole().equals(Role.ADMIN));
            }
        }
    }
}
