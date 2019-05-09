package com.zf.controller;

import com.zf.pojo.Userinfo;
import com.zf.service.IUserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户登陆注册
 */
@Controller
public class LoginC {

    @Autowired
    private IUserinfoService userService;

    /**
     * 用户登陆
     * @param user 登陆信息
     * @param session
     * @return      map.put(" success ", true/false);
     *             map.put("message","登陆成功/失败");
     */
    @RequestMapping("toLogin")
    @ResponseBody
    public Object login(Userinfo user, HttpSession session){
        Userinfo user1 = userService.get(user);
        Map<String,Object> map = new HashMap<>();
        //如果用户名和密码正确
        if (user1 != null){
            session.setAttribute("loginUser",user1);
            map.put("success",true);
            map.put("message","登陆成功");
        }else{
            map.put("success",false);
            map.put("message","登陆失败，用户名或密码错误");
        }
        return map;
    }

    /**
     * 用户注册
     * @param user 注册信息
     * @return map.put(" success ", true / false);
     *        map.put("message","注册成功/失败");
     */
    @RequestMapping("toRegister")
    @ResponseBody
    public Object register(Userinfo user){
        String username = user.getUsername();
        Userinfo register = new Userinfo();
        Map<String,Object> map = new HashMap<>();
        register.setUsername(username);
        Userinfo user1 = userService.check(register);
        System.out.println(user1);
        if (user1 != null){
            map.put("success",false);
            map.put("message","注册失败，用户名已存在");
        }else{
            userService.insert(user);
            map.put("success",true);
            map.put("message","注册成功");
        }
        return map;
    }

    @RequestMapping("toLoginOut")
    @ResponseBody
    public void toLoginOut(HttpSession session){
        session.setAttribute("loginUser",null);
    }


}
