package com.zf.dao;

import com.zf.pojo.Iteminfo;

import java.util.List;

import com.zf.pojo.Iteminfo;
import org.apache.ibatis.annotations.Param;

public interface IteminfoMapper {


    Iteminfo get(Iteminfo iteminfo);

    List<Iteminfo> getAll();

    void insert(Iteminfo iteminfo);

    void delete(Integer id);

    void update(Iteminfo iteminfo);

}