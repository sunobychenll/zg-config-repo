package com.abao.zhongtui;

import com.abao.zhongtui.atomikosConfig.DataSourceI;
import com.abao.zhongtui.atomikosConfig.DataSourceII;
import com.abao.zhongtui.druidConfig.DruidConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;

import javax.servlet.annotation.WebServlet;


@SpringBootApplication(scanBasePackages = {"com.abao"})
@EnableConfigurationProperties({DataSourceI.class, DataSourceII.class})
@ServletComponentScan(basePackages = {"com.abao.zhongtui"})
public class ZhongtuiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhongtuiApplication.class, args);
    }

}
