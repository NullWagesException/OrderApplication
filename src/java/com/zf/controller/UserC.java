package com.zf.controller;

import com.zf.pojo.Userinfo;
import com.zf.service.IUserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户增删改查
 */
@Controller
@RequestMapping("user")
public class UserC {

    @Autowired
    private IUserinfoService userService;

    /**
     * 获取所有用户
     * @return
     */
    @RequestMapping("getAll")
    @ResponseBody
    public Object getAll(){
        List<Userinfo> userList = userService.getAll();
        return userList;
    }

    /**
     * 删除某个用户
     * @param id
     * @return
     */
    @RequestMapping("delete")
    @ResponseBody
    public Object delete(Integer id){
        Map<String,Object> map = new HashMap<>();
        try {
            userService.delete(id);
            map.put("success",true);
            map.put("message","删除成功");
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
            map.put("message","删除失败");
            return map;
        }
        return map;
    }

    /**
     * 插入一名用户
     * @param userinfo
     * @return
     */
    @RequestMapping("insert")
    @ResponseBody
    public Object insert(Userinfo userinfo){
        Map<String,Object> map = new HashMap<>();
        try {
            userService.insert(userinfo);
            map.put("success",true);
            map.put("message","添加成功");
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
            map.put("message","添加失败");
            return map;
        }
        return map;
    }

    /**
     * 更新一名用户
     * @param userinfo
     * @return
     */
    @RequestMapping("update")
    @ResponseBody
    public Object getAll(Userinfo userinfo){
        Map<String,Object> map = new HashMap<>();
        try {
            Userinfo user = userService.getID(userinfo);
            if (userinfo.getAddress() != null && !userinfo.getAddress().equals(""))
                user.setAddress(userinfo.getAddress());
            if (userinfo.getPassword() != null && !userinfo.getPassword().equals(""))
                user.setPassword(userinfo.getPassword());
            if (userinfo.getPhone() != null && !userinfo.getPhone().equals(""))
                user.setPhone(userinfo.getPhone());
            if (userinfo.getUsername() != null && !userinfo.getUsername().equals(""))
                user.setUsername(userinfo.getUsername());
            userService.update(user);
            map.put("success",true);
            map.put("message","修改成功");
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
            map.put("message","修改失败");
            return map;
        }

        return map;
    }


}
