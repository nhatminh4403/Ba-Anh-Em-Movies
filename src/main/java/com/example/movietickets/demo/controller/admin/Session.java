package com.example.movietickets.demo.controller.admin;

import jakarta.servlet.http.HttpSession;

public class Session {
    public boolean isLoggedIn(HttpSession session) {
        return session.getAttribute("admin") != null;
    }

    public boolean Login(HttpSession session, String username, String password) {
        if (username.equals("admin") && password.equals("3anhem")) {
            session.setAttribute("admin", "true");
            return true;
        }
        return false;
    }

    public void Logout(HttpSession session) {
        session.removeAttribute("admin");
    }
}
