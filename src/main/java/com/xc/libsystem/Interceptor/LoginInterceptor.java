package com.xc.libsystem.Interceptor;

import com.xc.libsystem.Util.LoginResult;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("autoLogin".equals(cookie.getName())) {
                    String account = (cookie.getValue().split("#login#"))[0];
                    String password = (cookie.getValue().split("#login#"))[1];

                    request.getRequestDispatcher("/user?account="+ account+"&password="+password).forward(request, response);
                    return false;
                }
            }
        }

        request.getRequestDispatcher("/noAuthorization").forward(request, response);
        return false;
    }
}
