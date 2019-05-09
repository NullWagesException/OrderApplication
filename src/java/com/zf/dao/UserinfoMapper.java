package com.zf.dao;

import com.zf.pojo.Userinfo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserinfoMapper {

    Userinfo get(Userinfo user);

    Userinfo getID(Userinfo user);

    List<Userinfo> getAll();

    Userinfo check(Userinfo user);

    void insert(Userinfo user);

    void delete(Integer id);

    void update(Userinfo user);

}