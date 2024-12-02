package com.example.movietickets.demo.ultillity;

import com.example.movietickets.demo.Enum.Role;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomLoginSuccessHandler extends SimpleUrlAuthenticationFailureHandler implements AuthenticationSuccessHandler {
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
//            throws IOException, ServletException {
//        authentication.getAuthorities().forEach(grantedAuthority -> {
//            System.out.println("Role: " + grantedAuthority.getAuthority());
//        });
//        String redirectURL = request.getContextPath();
//        boolean isAdmin = authentication.getAuthorities().stream()
//                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(Role.ADMIN.name()));
//        if (isAdmin) {
//            // Chuyển hướng đến URL mặc định cho các người dùng khác
//            redirectURL = "/admin";
//        } else {
//            redirectURL = "/";
//        }
//        response.sendRedirect(redirectURL);
//    }
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        SavedRequest savedRequest = new HttpSessionRequestCache().getRequest(request, response);
        if (savedRequest != null) {
            // Kiểm tra xem URL được lưu có phải là URL login không
            String savedUrl = savedRequest.getRedirectUrl();
            if (!savedUrl.contains("/login")) {
                // Nếu không phải URL login, chuyển về trang đã lưu
                getRedirectStrategy().sendRedirect(request, response, savedUrl);
                return;
            }
        }
        // Nếu không có URL được lưu hoặc URL là trang login,
        // thực hiện chuyển hướng mặc định theo role
        String redirectURL = request.getContextPath();
        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(Role.ADMIN.name()));

        if (isAdmin) {
            redirectURL = "/admin";
        } else {
            // Thử lấy URL từ Referer header
            String referer = request.getHeader("Referer");
            if (referer != null && !referer.contains("/login")) {
                redirectURL = referer;
            } else {
                redirectURL = "/";
            }
        }

        response.sendRedirect(redirectURL);
    }
}
