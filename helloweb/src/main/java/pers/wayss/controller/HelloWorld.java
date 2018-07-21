package pers.wayss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 可以把这个类当成业务类
 */
@Controller
@RequestMapping("/")
public class HelloWorld {

    @RequestMapping("hello")
    public String hello(){
        //返回到hello.jsp页面
        return "hello";
    }

    @RequestMapping("returnString")
    @ResponseBody
    public String returnJson(){

        //业务逻辑

        //返回字符串returnString
        return "returnString";
    }

}
