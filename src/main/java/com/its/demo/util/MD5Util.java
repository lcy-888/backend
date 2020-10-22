package com.its.demo.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

/**
 * MD5 工具类
 *
 * @author 杨金刚
 * @date 2019/1/31 15:10
 */
@Component
public class MD5Util {
    //散列算法类型为MD5
    private static final String ALGORITH_NAME = "md5";


    /**
     * 生成MD5串（加盐）
     *
     * @param str  待加密字符串
     * @param salt 盐
     * @return MD5串
     */
    public static String getMD5WithSalt(String str, String salt) {
        String base = str + "/" + salt;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());

        return md5;
    }

    /**
     * 生成MD5串
     *
     * @param str 待加密字符串
     * @return MD5串
     */
    public static String getMD5(String str) {
        String base = str;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());

        return md5;
    }

    /**
     * 生成MD5串
     *
     * @param str            待加密字符串
     * @param salt           加盐
     * @param hashIterations hash次数
     * @param encoder        编码方式（hex,base64,null)
     * @return MD5串
     */
    public static String getMD5Hash(String str, String salt, int hashIterations, String encoder) {

        if ("hex".equals(encoder)) {
            return new SimpleHash(ALGORITH_NAME, str, ByteSource.Util.bytes(salt), hashIterations)
                    .toHex();
        }

        if ("base64".equals(encoder)) {
            return new SimpleHash(ALGORITH_NAME, str, ByteSource.Util.bytes(salt), hashIterations)
                    .toBase64();
        }

        return new SimpleHash(ALGORITH_NAME, str, ByteSource.Util.bytes(salt), hashIterations)
                .toString();

    }

}
