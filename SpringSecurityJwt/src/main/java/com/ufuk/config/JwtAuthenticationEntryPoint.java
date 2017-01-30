package com.ufuk.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created by z003cz2v on 1/27/2017.
 */
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable
{
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        response.sendError(0,"Unauthorized");
    }
}
