package com.abao.zhongtui.Controller;
 
 
import com.abao.zhongtui.bean.Goods;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HelloController {
    @RequestMapping("/index")
    public String sayHello(){
       // http://localhost:8090/index
        return "index";
    }


}