package com.abao.zhongtui.Controller;
 
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @RequestMapping("/index")
    public String sayHello(){
       // http://localhost:8088/index
        return "index";
    }
}