package com.zf.service.impl;

import com.zf.dao.UserinfoMapper;
import com.zf.pojo.Userinfo;
import com.zf.service.IUserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class UserinfoService implements IUserinfoService {

    @Autowired
    private UserinfoMapper userinfoMapper;


    @Override
    public List<Userinfo> getAll() {
        return userinfoMapper.getAll();
    }

    @Override
    public Userinfo getID(Userinfo user) {
        return userinfoMapper.getID(user);
    }

    @Override
    public Userinfo check(Userinfo user) {
        return userinfoMapper.check(user);
    }

    @Override
    public Userinfo get(Userinfo user) {
        return userinfoMapper.get(user);
    }

    @Override
    public void insert(Userinfo user) {
        userinfoMapper.insert(user);
    }

    @Override
    public void delete(Integer id) {
        userinfoMapper.delete(id);
    }

    @Override
    public void update(Userinfo user) {
        userinfoMapper.update(user);
    }
}
