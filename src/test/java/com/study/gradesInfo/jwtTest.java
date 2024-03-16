package com.study.gradesInfo;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class jwtTest {

    @Test
    public void testGen(){
        Map<String, Object> claims=new HashMap<>();
        claims.put("id",1);
        claims.put("username","uuid");
        String jwt=JWT.create()
                .withClaim("user",claims)
                .withExpiresAt(new Date(System.currentTimeMillis()+1000*60*3))
                .sign(Algorithm.HMAC256("study"));
        System.out.println(jwt);
    }

    @Test
    public void testParse(){
        String get="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7ImlkIjoxLCJ1c2VybmFtZSI6InV1aWQifSwiZXhwIjoxNzA5OTA3NDMzfQ.vQNLhYRi7fksHc4wkfM_ePyhMlfQ_X0z5N08ojKEv1Y";
        JWTVerifier jwtVerifier=JWT.require(Algorithm.HMAC256("study")).build();
        DecodedJWT decodedJWT=jwtVerifier.verify(get);
        Map<String, Claim>claimMap=decodedJWT.getClaims();
        System.out.println(claimMap.get("user"));




    }

}
