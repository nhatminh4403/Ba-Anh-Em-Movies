package com.example.movietickets.demo.ultillity;

import com.example.movietickets.demo.Enum.Role;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;


public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        authentication.getAuthorities().forEach(grantedAuthority -> {
            System.out.println("Role: " + grantedAuthority.getAuthority());
        });
        String redirectURL = request.getContextPath();
        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(Role.ADMIN.name()));
        if (isAdmin) {
            // Chuyển hướng đến URL mặc định cho các người dùng khác
            redirectURL = "/admin";
        } else {
            redirectURL = "/";
        }
        response.sendRedirect(redirectURL);
    }
}
