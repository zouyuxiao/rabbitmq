package com.visualization.controller;

import com.alibaba.fastjson.JSONObject;
import com.visualization.annotation.UserLoginToken;
import com.visualization.bean.User;
import com.visualization.service.TokenService;
import com.visualization.service.UserService;
import com.visualization.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Description token认证
 * @Author zouyuxiao
 * @Date 2020-10-15 09:17
 */
@RestController
@RequestMapping("/token")
public class TokenController extends BaseApiController{

    @Autowired
    private UserService userService;

    @Autowired
    TokenService tokenService;

    // 登录
    @RequestMapping(value = "/login" ,method = RequestMethod.GET)
    public Object login(String username, String password, HttpServletResponse response) {
        JSONObject jsonObject = new JSONObject();
        User user = userService.login(username, password);
        if (user != null) {
            String token = tokenService.getToken(user);
            Cookie cookie = new Cookie("token", token);
            cookie.setPath("/");
            response.addCookie(cookie);
            jsonObject.put("token", token);
            return jsonObject;
        }
        return onBadResp("登录失败");
    }


    /***
     * 这个请求需要验证token才能访问
     * @return String 返回类型
     */
    @UserLoginToken
    @RequestMapping(value = "/getMessage" ,method = RequestMethod.GET)
    public Map<String, Object> getMessage() {

        // 取出token中带的用户id 进行操作
        System.out.println(TokenUtil.getTokenUserId());

        return onSuccessRep("您已通过验证");
    }

}
