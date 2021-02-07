package com.abao.zhongtui.Controller;

import com.abao.zhongtui.bean.ConsultConfigArea;
import com.abao.zhongtui.service.AreaService;
import com.abao.zhongtui.service.BuyRecordService;
import com.abao.zhongtui.service.GoodService;
import com.abao.zhongtui.spi.Pay;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@Api(tags = "springboot学习工程相关接口")
public class JackController {
    
    private static final Logger logger = LoggerFactory.getLogger(JackController.class);
    
    @Autowired
    AreaService areaService;
    @Autowired
    GoodService goodService;
    @Autowired
    BuyRecordService buyRecordService;


    @Value("${application.field:default value jack}")
    private String zhuguangField = "";

    @ApiOperation("jsp测试接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", defaultValue = "jack"),
            @ApiImplicitParam(name = "address", value = "用户地址", defaultValue = "长沙")
    })
    @RequestMapping("/index2")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index.ftl");
        mv.addObject("time", new Date());
        mv.addObject("message", zhuguangField);
        return mv;
    }

    @ApiOperation("freemarker测试接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "map", value = "返回值")
    })
    @RequestMapping("/freemarker")
    public String freemarker(Map<String, Object> map) {
        
        map.put("name", "zhuguang jack");
        map.put("gender", 0);
        
        List<Map<String, Object>> friends = new ArrayList<Map<String, Object>>();
        Map<String, Object> friend = new HashMap<String, Object>();
        friend.put("name", "roy");
        friend.put("age", 32);
        friends.add(friend);
        friend = new HashMap<String, Object>();
        friend.put("name", "walker");
        friend.put("age", 34);
        friends.add(friend);
        map.put("friends", friends);
        return "freemarker";
    }

    @ApiOperation("查询地区接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "param", value = "地区编码")
    })
    @RequestMapping("/queryArea")
    public @ResponseBody String queryArea(String param) {
        //http://localhost:8088/queryArea
        Map<String,String> map = new HashMap<>();
        map.put("state",param);
        List<ConsultConfigArea> areas = areaService.qryArea(map);
        for (ConsultConfigArea area : areas) {
            logger.info(area.getAreaCode() + "   " + area.getAreaName() + "   "
                    + area.getState());
        }

        return "OK";
    }

    @Transactional
    @RequestMapping("/buyGoods")
    public @ResponseBody String buyGoods(@RequestParam Integer goodId) {
        //http://localhost:8088/buyGoods?goodId=6
        goodService.buyGoods(goodId);
        buyRecordService.insertBuyRecord(goodId);
        return "good OK";
    }

    @RequestMapping("/testDevTool")
    public @ResponseBody String testDevTool() {
        return "OK";
    }

    @RequestMapping("/testDevTool1")
    public @ResponseBody String testDevTool1() {
        return "OK";
    }
}
