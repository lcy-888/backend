package com.its.demo.filter;

import com.its.demo.constant.BaseConstant;
import com.its.demo.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author 杨金刚
 * @date 2020/4/22 16:28
 */

@Component
@WebFilter(urlPatterns = {"/api/v1/*"})
@Order(1)
public class AuthenticationFilter implements Filter {
    @Value("${jwt.auth-header}")
    private String authHeader;

    @Value("${jwt.prefixKey}")
    private String prefixKey;

    @Value("${jwt.expiration}")
    private Long expiration;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        //解决跨域的问题
        resp.setHeader("Access-Control-Allow-Origin","*");
        resp.setHeader("Access-Control-Allow-Credentials","true");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type, Content-Length, Authorization, Accept, Origin, X-CSRF-TOKEN, X-Requested-With, X-App-Id, X-Token");
        resp.setHeader("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");
        resp.setHeader("Access-Control-Max-Age", "7200");

        String url = req.getRequestURL().toString();

        String[] urlPrefix = BaseConstant.FILTER_PREFIX_URLS;
        String[] urlExcluded = BaseConstant.FILTER_EXCLUDED_URLS;

        String method = req.getMethod();

        if (BaseConstant.OPTIONS_METHOD.equalsIgnoreCase(method)) {
            resp.setStatus(HttpServletResponse.SC_OK);
        }
        else {
            if(StringUtil.contains(urlPrefix, url) && !StringUtil.contains(urlExcluded, url)) {
                //如果头部没有令牌，返回401
                String token = req.getHeader(authHeader);
                if(token == null){
                    resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

                    return;
                }

                String key = prefixKey + token;
                String value = redisTemplate.opsForValue().get(key);

                if(!BaseConstant.DEFAULT_JWT_TOKEN_VALUE.equals(value)){
                    resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

                    return;
                }

                //续约
                redisTemplate.opsForValue().set(prefixKey + token, "eureka", expiration * 60, TimeUnit.SECONDS);

                filterChain.doFilter(servletRequest, servletResponse);
            }
            else{
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
