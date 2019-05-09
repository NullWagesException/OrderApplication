package com.zf.service;

import com.zf.pojo.Iteminfo;

import java.util.List;

public interface IIteminfoService {

    Iteminfo get(Iteminfo iteminfo);

    List<Iteminfo> getAll();

    void insert(Iteminfo iteminfo);

    void delete(Integer id);

    void update(Iteminfo iteminfo);

}
