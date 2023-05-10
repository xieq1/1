package com.graduationproject.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

public class JwtUtils {
    private static final String SECRET_KEY = "O/TwtW+yCvQ97dNSRmz371QCuAwbbTd6vojPkZ0gTxY="; //私钥, 用于加密和解密JWT

    public static String generateJwtToken() {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + 10 * 60 * 1000); //设定过期时间为10分钟

        String jwt = Jwts.builder()
                .setSubject("user_id") //JWT的主题，可以存放用户ID等信息
                .setIssuedAt(now) //JWT的发行时间
                .setExpiration(expiration) //JWT的过期时间
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY) //使用HS512算法和私钥对JWT进行签名
                .compact();

        return jwt;
    }

    public static Claims parseJwtToken(String jwt) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY) //使用私钥解密JWT
                .parseClaimsJws(jwt)
                .getBody();
        return claims;
    }
}
