package com.learn.jwt.jwtserver.login;

import java.time.Duration;
import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JwtTokenService {

    private static final String HMAC_SHA256KEY = "ThisbetterbeAGoodKey";
    // private static final long EXP_TIME = Duration.ofHours(1).toMillis();
    private static final long EXP_TIME = Duration.ofSeconds(1).toMillis();

    public String generateJWTToken(String userID){
        return JWT.create()
            .withSubject(userID)
            .withIssuedAt(new Date())
            .withExpiresAt(new Date(System.currentTimeMillis() + EXP_TIME))
            .sign(Algorithm.HMAC256(HMAC_SHA256KEY));
    }

    public boolean validateJwtToken(String tkn){

        try {
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(HMAC_SHA256KEY)).build();
    
            DecodedJWT decJwt = jwtVerifier.verify(tkn);
    
            return decJwt.getExpiresAt().after(new Date());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public static void main(String[] args) {
        JwtTokenService serv = new JwtTokenService();
        System.out.println(
            // serv.generateJWTToken("SHIF")
            serv.validateJwtToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJTSElGIiwiaWF0IjoxNzIzOTc1NTkyLCJleHAiOjE3MjM5NzU1OTN9.e4SqobghT4XaCiczfVc1EY6uKU-jlhb_cjzd0PDWIF0")
        );
    }

}
