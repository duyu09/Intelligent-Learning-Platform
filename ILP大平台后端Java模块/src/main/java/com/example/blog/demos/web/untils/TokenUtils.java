package com.example.blog.demos.web.untils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.security.Key;
import java.util.Date;


@Component
public class TokenUtils {

    // 设置秘钥
    private static final Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static final Logger logger = LoggerFactory.getLogger(TokenUtils.class);
    // 设置过期时间为10分钟
    private static final long expiration = 24 * 60 * 60 * 1000;

    /**
     * 根据userId生成token
     * @param userId 用户ID
     * @return token
     */
    public static String generateToken(Long userId) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expiration);
        logger.debug("shengcheng：{}",secretKey);
        return Jwts.builder()
                .setSubject(String.valueOf(userId))
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(secretKey)
                .compact();
    }

    /**
     * 验证token是否有效
     * @param token 待验证的token
     * @return 是否有效
     */
    public static boolean verifyToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
           logger.debug("success:{}",secretKey);
            return true;
        } catch (Exception e) {
            logger.debug("false:{}",secretKey);
            return false;
        }
    }public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    /**
     * 获取token中的userId
     * @param token token
     * @return userId
     */
    public static String getUserIdFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
}
