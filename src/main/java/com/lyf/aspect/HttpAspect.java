package com.lyf.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.DoubleSummaryStatistics;

/**
 * Created by Administrator on 2017/7/25.
 */
@Aspect
@Component
public class HttpAspect {

    private Logger log = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.lyf.action.GirlAction.*(..))")
    public  void log(){
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public  void afterReturning(Object object){
        log.info("返回这么一个东西："+object);
    }


    @Before("log()")
    public  void doBefore(JoinPoint joinPoint){
        // 请求参数
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        // 请求对象
        javax.servlet.http.HttpServletRequest request = attributes.getRequest();
        // url
        StringBuffer requestURL = request.getRequestURL();
        log.info("URL："+requestURL);
        // method
        log.info("方法："+request.getMethod());        ;
        // ip
        log.info("IP："+request.getRemoteAddr());
        // doBefore(JoinPoint joinPoint)
                 // 类名
                 // 类方法名
        log.info("类方法："+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        // 参数
        log.info("参数："+  joinPoint.getArgs());
     }

}
