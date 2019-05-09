package com.zf.controller;

import com.zf.pojo.Iteminfo;
import com.zf.service.IIteminfoService;
import com.zf.service.impl.IteminfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("item")
public class ItemC {


    @Autowired
    private IIteminfoService iteminfoService;

    /**
     * 添加菜品
     * @param iteminfo 菜品属性
     * @return      map.put(" success ", true/false);
     *             map.put("message","菜品添加成功/失败");
     */
    @RequestMapping("insert")
    @ResponseBody
    public Object create(Iteminfo iteminfo){
        Map<String,Object> map = new HashMap<>();
        try {
            iteminfoService.insert(iteminfo);
            map.put("success",true);
            map.put("message","菜品添加成功");
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
            map.put("message","菜品添加失败");
            return map;
        }
        return map;
    }

    /**
     * 删除菜品
     * @param itemid 菜品ID
     * @return      map.put(" success ", true/false);
     *             map.put("message","菜品删除成功/失败");
     */
    @RequestMapping("delete")
    @ResponseBody
    public Object delete(Integer itemid){
        Map<String,Object> map = new HashMap<>();
        try {
            iteminfoService.delete(itemid);
            map.put("success",true);
            map.put("message","菜品删除成功");
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
            map.put("message","菜品删除失败");
            return map;
        }
        return map;
    }

    /**
     * 更新菜品
     * @param item 菜品需要更新的属性
     * @return          map.put(" success ", true/false);
     *      *             map.put("message","菜品更新成功/失败");
     */
    @RequestMapping("update")
    @ResponseBody
    public Object update(Iteminfo item){
        Map<String,Object> map = new HashMap<>();
        try {
            Iteminfo iteminfo = iteminfoService.get(item);
            if (item.getItemname() != null && !item.getItemname().equals(""))
                iteminfo.setItemname(item.getItemname());
            if (item.getItemcontent() != null && !item.getItemcontent().equals(""))
                iteminfo.setItemcontent(item.getItemcontent());
            if (item.getItemPrice() != null && !item.getItemPrice().equals(""))
                iteminfo.setItemPrice(item.getItemPrice());
            if (item.getItemscore() != null && !item.getItemscore().equals(""))
                iteminfo.setItemscore(item.getItemscore());
            iteminfoService.update(iteminfo);
            map.put("success",true);
            map.put("message","菜品更新成功");
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
            map.put("message","菜品更新失败");
            return map;
        }
        return map;
    }

    /**
     * 根据ID获取指定菜品
     * @param iteminfo 传入itemid
     * @return Iteminfo/false
     */
    @RequestMapping("get")
    @ResponseBody
    public Object get(Iteminfo iteminfo){
        Map<String,Object> map = new HashMap<>();
        try {
            Iteminfo recordinfo1 = iteminfoService.get(iteminfo);
            return recordinfo1;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取所有菜品
     * @return List<Iteminfo> all
     */
    @RequestMapping("getAll")
    @ResponseBody
    public Object getAll(){
        Map<String,Object> map = new HashMap<>();
        try {
            List<Iteminfo> all = iteminfoService.getAll();
            for (Iteminfo iteminfo : all) {
                iteminfo.setItemImgPath("\\dataResourceImages\\foodImg\\" + iteminfo.getItemImgPath());
            }
            return all;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
