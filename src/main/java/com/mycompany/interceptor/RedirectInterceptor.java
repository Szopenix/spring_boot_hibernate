package com.mycompany.interceptor;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String rm = null;
        if (handler instanceof HandlerMethod) {
            rm = ((HandlerMethod) handler).getMethod().getName();
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        boolean loggedIn = false;
        if (auth != null) {
            loggedIn = !auth.getName().equals("anonymousUser");
        }
        if (rm != null && rm.equals("errorHtml") && loggedIn) {
            response.sendRedirect("/home");
            return true;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
