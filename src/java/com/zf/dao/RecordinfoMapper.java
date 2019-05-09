package com.zf.dao;

import com.zf.pojo.Recordinfo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RecordinfoMapper {

    Recordinfo get(Recordinfo recordinfo);

    List<Recordinfo> getAll();

    void insert(Recordinfo recordinfo);

    void delete(Integer id);

    void update(Recordinfo recordinfo);

}