package com.zf.service;

import com.zf.pojo.Recordinfo;

import java.util.List;

public interface IRecordinfoService {

    Recordinfo get(Recordinfo recordinfo);

    List<Recordinfo> getAll();

    void insert(Recordinfo recordinfo);

    void delete(Integer id);

    void update(Recordinfo recordinfo);

}
