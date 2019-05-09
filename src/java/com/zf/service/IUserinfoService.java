package com.zf.service;

import com.zf.pojo.Userinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserinfoService {

    Userinfo get(Userinfo user);

    Userinfo getID(Userinfo user);

    List<Userinfo> getAll();

    Userinfo check(Userinfo user);

    void insert(Userinfo user);

    void delete(Integer id);

    void update(Userinfo user);

}
