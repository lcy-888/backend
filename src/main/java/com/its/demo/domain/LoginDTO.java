package com.its.demo.domain;

import lombok.Data;
import java.io.Serializable;

/**
 * 登录时传递的数据
 *
 * @author 杨金刚
 * @date 2020/8/9 16:12
 */
@Data
public class LoginDTO implements Serializable {
    private String username;
    private String password;
}
