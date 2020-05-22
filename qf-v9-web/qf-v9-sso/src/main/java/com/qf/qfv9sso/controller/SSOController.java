package com.qf.qfv9sso.controller;


import Util.ResultBean;
import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.api.user.IUserService;
import com.qf.v9.entity.DO.TUserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/sso")
public class SSOController {


    @Reference
    private IUserService userService;


    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 登陆页面
     */
    @RequestMapping("/login")
    public String showLogin() {
        return "index";
    }

    /**
     * 验证登陆
     */
    @RequestMapping("/checkLogin")
    public String checkLogin(TUserDO user, HttpServletResponse httpServletResponse) {
        //查数据库
        TUserDO tUserDO = userService.checkLogin(user);

        if (tUserDO == null) {
            return "index";
        }

        //生成唯一的UUID
        String uuid = UUID.randomUUID().toString();
        //构造一个cookie
        Cookie cookie = new Cookie("user_token", uuid);
        cookie.setPath("/");

        //设置父域名，这样所有的子域名系统也可以看到，解决了cookie的跨域问题
        //cookie.setDomain("");
        //只允许后端来获取到cookie的信息，不能在前端通过后端来获取到cookie的信息
        cookie.setHttpOnly(true);

        //将cookie返回给前端
        httpServletResponse.addCookie(cookie);

        //在redis中保存凭证信息
        StringBuilder redisKey = new StringBuilder("user:token:").append(uuid);

        //将key值序列化
        redisTemplate.setKeySerializer(new StringRedisSerializer());

        redisTemplate.opsForValue().set(redisKey.toString(), user);

        //设置有效时间
        redisTemplate.expire(redisKey.toString(), 30, TimeUnit.MINUTES);

        return "https://www.baidu.com/";
    }

//    /**
//     * 检查是否是登陆状态
//     */
//    @RequestMapping("/checkIsLogin")
//    @ResponseBody
//    public ResultBean isLogin(HttpServletRequest request) {
//
//        Cookie[] cookies = request.getCookies();
//
//        if (cookies == null) {
//            return ResultBean.error("当前用户没有登陆");
//        }
//
//        for (Cookie cookie : cookies) {
//
//            if ("user_token".equals(cookie.getName())) {
//                String uuid = cookie.getValue();
//
//                String redisKey = "user:token:" + uuid;
//
//                redisTemplate.setKeySerializer(new StringRedisSerializer());
//                TUserDO user = (TUserDO) redisTemplate.opsForValue().get(redisKey);
//
//                if (user != null) {
//                    //刷新凭证的有效期
//                    redisTemplate.expire(redisKey, 30, TimeUnit.MINUTES);
//                    return ResultBean.success(user.getUsername());
//                }
//            }
//        }
//
//        return ResultBean.error("身份信息已过期或不存在，请重新登陆！");
//    }


    /**
     * cookie 新的写法
     *
     * @param uuid
     * @return
     */

    @RequestMapping("/checkIsLogin")
    @ResponseBody
    public ResultBean isLoginNew(@CookieValue(name = "user_token", required = false) String uuid) {

        if (uuid == null) {
            return ResultBean.error("当前用户没有登陆");
        }

        String redisKey = "user:token:" + uuid;

        redisTemplate.setKeySerializer(new StringRedisSerializer());
        TUserDO user = (TUserDO) redisTemplate.opsForValue().get(redisKey);

        if (user != null) {
            //刷新凭证的有效期
            redisTemplate.expire(redisKey, 30, TimeUnit.MINUTES);
            return ResultBean.success(user.getUsername());
        }


        return ResultBean.error("身份信息已过期或不存在，请重新登陆！");
    }


    /**
     * 注销
     */
    @RequestMapping("/logout")
    @ResponseBody
    public ResultBean logout(@CookieValue(name = "user_token", required = false) String uuid, HttpServletResponse httpServletResponse) {

        if (uuid == null) {
            return ResultBean.error("注销失败！");
        }

        //1.删除cookie(就是把cookie重写回浏览器)
        Cookie cookie = new Cookie("user_token", uuid);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        //使cookie失效的关键一步
        cookie.setMaxAge(0);
        httpServletResponse.addCookie(cookie);

        //2.删除redis凭证
        StringBuilder redisKey = new StringBuilder("user:token").append(uuid);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.delete(redisKey.toString());

        return ResultBean.success("注销成功！");
    }

}
