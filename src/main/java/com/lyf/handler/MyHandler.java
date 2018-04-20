package com.lyf.handler;

import com.lyf.common.ServerResponse;
import com.lyf.exception.MyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class MyHandler {
    private static final String EEROR = "error";
    private final static Logger logger= LoggerFactory.getLogger(MyHandler.class);
    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    public ModelAndView handle(Exception e) {
        ModelAndView mv = new ModelAndView();
        if(e instanceof MyException) {
            MyException girlException = (MyException) e;

            mv.addObject("response",ServerResponse.createByErrorCodeMessage(girlException.getCode(), girlException.getMessage()));

        }else {
            logger.error("意料之外:",e);
            mv.addObject("response",ServerResponse.createByErrorCodeMessage(-1, e.getMessage()));
            mv.setViewName(EEROR);
        }
        return mv;
    }
}