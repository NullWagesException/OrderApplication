package com.zf.service.impl;

import com.zf.dao.RecordinfoMapper;
import com.zf.pojo.Recordinfo;
import com.zf.service.IRecordinfoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RecordinfoService implements IRecordinfoService {


    @Autowired
    private RecordinfoMapper recordinfoMapper;


    @Override
    public Recordinfo get(Recordinfo recordinfo) {
        return recordinfoMapper.get(recordinfo);
    }

    @Override
    public List<Recordinfo> getAll() {
        return recordinfoMapper.getAll();
    }

    @Override
    public void insert(Recordinfo recordinfo) {
        recordinfoMapper.insert(recordinfo);
    }

    @Override
    public void delete(Integer id) {
        recordinfoMapper.delete(id);
    }

    @Override
    public void update(Recordinfo recordinfo) {
        recordinfoMapper.update(recordinfo);
    }
}
