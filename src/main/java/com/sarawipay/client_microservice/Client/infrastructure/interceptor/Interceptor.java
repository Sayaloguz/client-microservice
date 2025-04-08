
package com.sarawipay.client_microservice.Client.infrastructure.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.crypto.SecretKey;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.util.Base64;

import lombok.*;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;


@Getter
@Setter
@RequiredArgsConstructor
@Component
public class Interceptor implements HandlerInterceptor {
/*
    // private static final String SECRET_KEY = Base64.getEncoder().encodeToString(Keys.secretKeyFor(SignatureAlgorithm.HS256).getEncoded());
    private static final String SECRET_KEY = "aFk7Tfz2dIceNqUyKQL++BUyKwaw4WEqBMX9Rj3djks=";


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Missing or invalid Authorization header");
            return false;
        }
        String jwt = authorizationHeader.substring(7);

        //String jwt = request.getParameter("jwt");
        if (jwt == null || jwt.isEmpty()) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Missing JWT");
            return false;
        }

        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(jwt)
                    .getBody();


            String name = claims.get("name", String.class);
            Integer age = claims.get("age", Integer.class);

            if (name == null || name.isEmpty()) {
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "Name is required");
                return false;
            }
            if (age == null || age < 18) {
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "Age is required or you're not 18");
                return false;
            }


            request.setAttribute("userName", name);
            return true;

        } catch (SignatureException e) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid JWT");
            return false;
        }
    }
    */

}