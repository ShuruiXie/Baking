package org.example.finaldemo01.exception;

import org.example.finaldemo01.response.JsonResult;
import org.example.finaldemo01.response.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理类  ： 负责所有控制器类的异常处理
 */
/*@ControllerAdvice */ //标记当前类 是捕获所有控制类的异常
@RestControllerAdvice  //复合注解：标记当前类 是捕获所有控制类的异常 + @ResponseBody注解
//@Slf4j  //lombok中提供的注解 ,可以用来打印日志信息
public class GlobalExceptionHandler {
    //该方法捕获的是如果控制器类中出现了IllegalArgumentException 异常时
    //当前方法则会被执行 并返回状态码和异常对象的信息
    @ExceptionHandler(IllegalArgumentException.class)
    public JsonResult doHandlerIllegalArgumentException(IllegalArgumentException e){
        //log.error("发生了IllegalArgumentException异常:{}",e.getMessage());
        System.out.println("发生了IllegalArgumentException异常:{}"+e.getMessage());
        return new JsonResult(StatusCode.OPERATION_FAILED,e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public JsonResult doHandlerRuntimeException(RuntimeException e){
        System.out.println("发生了RuntimeException异常:{}"+e.getMessage());
        return new JsonResult(StatusCode.OPERATION_FAILED,e.getMessage());
    }

  /*  //Throwable 是所有异常的父类！ 一般来讲 开发阶段使用的目的是为了防止服务器终止
    @ExceptionHandler(Throwable.class)
    public JsonResult doHandlerThrowable(Throwable t){
        return new JsonResult(StatusCode.OPERATION_FAILED,"程序运行过程中出现错误Throwable,信息为：" +t.getMessage());
    }*/
}
