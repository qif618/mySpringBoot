package com.lyf.service;

import com.lyf.common.ResponseCode;
import com.lyf.dao.GirlDao;
import com.lyf.exception.MyException;
import com.lyf.model.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    public Girl findGirl(Integer id) throws Exception{
        Girl girl =  dao.findOne(id);
        Integer age = girl.getAge();
        if(age<10){
            throw new MyException(ResponseCode.ERROR);
        }
        return girl;
    }

    @Transactional
    public void transactionSave(Girl girl1,Girl girl2) throws Exception{

        dao.save(girl1);
        dao.save(girl2);
    }

}