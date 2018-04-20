package com.lyf.action;

import com.lyf.common.ResponseCode;
import com.lyf.exception.MyException;
import com.lyf.model.Girl;
import com.lyf.common.ServerResponse;
import com.lyf.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Administrator on 2017/3/3.
 */
@RestController
public class GirlAction {

    @Autowired
    private GirlService girlService;

    @RequestMapping("/index")
    public ModelAndView index(){
        System.out.println("访问下back");
        ModelAndView mv = new ModelAndView("back");
        mv.addObject("KEY","我的测试！");
        return  mv;
    }
    //获取girl列表
    @RequestMapping("/list")
    public List<Girl> findAllGirl(){
        return girlService.findAllGirl();
    }
    //保存单条数据
    @RequestMapping("/saveGirl")
    public ServerResponse saveGirl(@Valid Girl girl, BindingResult br){
        if(br.hasErrors()){
            return null;
           // return ServerResponse.createByErrorMessage(br.getFieldError().getDefaultMessage());
        }
        girlService.saveGirl(girl);
        return ServerResponse.createBySuccess(girl);
    }

    @RequestMapping("/get/{id}")
    public Girl getGirl(@PathVariable Integer id) throws Exception{

        return girlService.findGirl(id);
    }

    /**
     * 事务测试
     * @throws Exception
     */
    @RequestMapping("/transactionSave")
    public void transactionSave(){

        Girl girl1 = new Girl();
        girl1.setName("CCCCCC");
        girl1.setAge(26);

        Girl girl2 = new Girl();
        girl2.setName("dddddddd");
        girl2.setAge(14);

        try {
            girlService.transactionSave(girl1,girl2);
        } catch (Exception e) {
            throw new MyException(ResponseCode.AGE_ERROR);
        }
    }
}
