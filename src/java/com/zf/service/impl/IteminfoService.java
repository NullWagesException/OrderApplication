package com.zf.service.impl;

import com.zf.dao.IteminfoMapper;
import com.zf.pojo.Iteminfo;
import com.zf.service.IIteminfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class IteminfoService implements IIteminfoService {

    @Autowired
    private IteminfoMapper iteminfoMapper;

    @Override
    public Iteminfo get(Iteminfo iteminfo) {
        return iteminfoMapper.get(iteminfo);
    }

    @Override
    public List<Iteminfo> getAll() {
        return iteminfoMapper.getAll();
    }

    @Override
    public void insert(Iteminfo iteminfo) {
        iteminfoMapper.insert(iteminfo);
    }

    @Override
    public void delete(Integer id) {
        iteminfoMapper.delete(id);
    }

    @Override
    public void update(Iteminfo iteminfo) {
        iteminfoMapper.update(iteminfo);
    }
}
