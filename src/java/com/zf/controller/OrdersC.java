package com.zf.controller;

import com.zf.pojo.Recordinfo;
import com.zf.service.impl.RecordinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 订单
 */
@Controller
@RequestMapping("orders")
public class OrdersC {

    @Autowired
    private RecordinfoService recordinfoService;

    /**
     *订单添加
     * @param recordinfo 订单属性
     * @return
     */
    @RequestMapping("create")
    @ResponseBody
    public Object create(Recordinfo recordinfo){
        Map<String,Object> map = new HashMap<>();
        try {
            recordinfoService.insert(recordinfo);
            map.put("success",true);
            map.put("message","订单添加成功");
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
            map.put("message","订单添加失败");
            return map;
        }
        return map;
    }

    @RequestMapping("get")
    @ResponseBody
    public Object get(Recordinfo recordinfo){
        Map<String,Object> map = new HashMap<>();
        try {
            Recordinfo recordinfo1 = recordinfoService.get(recordinfo);
            return recordinfo1;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping("getAll")
    @ResponseBody
    public Object getAll(){
        Map<String,Object> map = new HashMap<>();
        try {
            List<Recordinfo> all = recordinfoService.getAll();
            return all;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }



}
