package com.study.gradesInfo.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtil {
    public static final String KEY = "1124";
    public static final int time = 1000 * 60 * 30 * 12;

    public static String genToken(Map<String, Object> claims) {
        return JWT.create()
                .withClaim("claims", claims)
                .withExpiresAt(new Date(System.currentTimeMillis() + time))
                .sign(Algorithm.HMAC256(KEY));
    }

    public static Map<String, Object> parseToken(String s) {
        return JWT.require(Algorithm.HMAC256(KEY))
                .build()
                .verify(s)
                .getClaim("claims")
                .asMap();
    }
}
