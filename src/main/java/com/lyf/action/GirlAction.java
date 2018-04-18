package com.lyf.action;

import com.lyf.aspect.HttpAspect;
import com.lyf.model.Girl;
import com.lyf.service.GirlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
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
    public Girl saveGirl(@Valid Girl girl, BindingResult br){
        if(br.hasErrors()){
            System.out.print(br.getFieldError().getDefaultMessage());
            return  null;
        }
        girlService.saveGirl(girl);
        return girl;
    }
}
