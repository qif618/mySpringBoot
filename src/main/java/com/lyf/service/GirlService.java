package com.lyf.service;

import com.lyf.dao.GirlDao;
import com.lyf.model.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by Administrator on 2017/3/31.
 */
@Service
public class GirlService {
    @Autowired
    private GirlDao dao;

    public void saveGirl(Girl girl){
        dao.save(girl);
    }

    public List<Girl> findAllGirl(){
        return dao.findAll();
    }
}
