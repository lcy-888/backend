package com.its.demo.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * JWT 工具类
 *
 * @author 杨金刚
 * @date 2019/1/31 15:01
 */
@Component
public class JWTUtil {

    private static final String secret = "ydj3%_b@#BN97()$!QA@WS";

    /**
     * 生成令牌
     *
     * @param username 用户名
     * @param role     角色ID串（逗号分隔）
     * @return 返回令牌
     * @Param period 令牌生存期（毫秒）
     */
    public static String issueJWT(String username, String role, long period) {
        long currentTimeMillis = System.currentTimeMillis();
        Algorithm alg = Algorithm.HMAC256(secret);

        String token = JWT.create()
                .withJWTId(UUID.randomUUID().toString())
                .withSubject(username)
                .withClaim("role", role)
                .withIssuedAt(new Date(currentTimeMillis))
                .withExpiresAt(new Date(currentTimeMillis + period))
                .sign(alg);

        return token;
    }

    /**
     * 校验token是否正确
     *
     * @param token    令牌
     * @param username 用户名
     * @return 是否正确
     */
    public static boolean verify(String token, String username) {
        try {
            Algorithm alg = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(alg)
                    .withSubject(username)
                    .build();

            DecodedJWT jwt = verifier.verify(token);

            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    public static String getUsernameFromToken(String token) {
        DecodedJWT jwt = JWT.decode(token);
        String username = jwt.getSubject();

        return username;
    }
}
