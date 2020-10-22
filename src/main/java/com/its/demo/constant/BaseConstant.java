package com.its.demo.constant;

/**
 * 基础常量
 *
 * @author 杨金刚
 * @date 2020/4/22 9:10
 */
public class BaseConstant {

    /**
     *
     */
    public final static Integer USER_DISABLED = 0;

    /**
     * 登录用户缓存前缀
     */
    public final static String LOGINED_USER_CACHE_KEY_PREFIX = "logined-user:";

    /**
     * 系统缺省超级用户名称
     */
    public final static String DEFAULT_SUPER_USER = "sysadmin";

    /**
     * 系统缺省最高权限角色名称
     */
    public final static String DEFAULT_SUPER_ROLE = "super";

    /**
     * 需要过滤器过滤的URL前缀
     */
    public final static String[] FILTER_PREFIX_URLS = {
            "/api/v1"
    };
    /**
     * 不需要过滤器判断认证和权限的URL
     */
    public final static String[] FILTER_EXCLUDED_URLS = {
            "/api/v1/login",
    };

    /**
     * Options Verb
     */
    public final static String OPTIONS_METHOD = "OPTIONS";

    /**
     * 缺省JWT-TOKEN存储值，KEY为TOKEN
     */
    public final static String DEFAULT_JWT_TOKEN_VALUE = "eureka";



}
