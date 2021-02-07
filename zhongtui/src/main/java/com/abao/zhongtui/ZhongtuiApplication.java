package com.abao.zhongtui;

import com.abao.zhongtui.atomikosConfig.DataSourceI;
import com.abao.zhongtui.atomikosConfig.DataSourceII;
import com.abao.zhongtui.druidConfig.DruidConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication(scanBasePackages = {"com.abao"})
@EnableConfigurationProperties({DataSourceI.class, DataSourceII.class})
public class ZhongtuiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhongtuiApplication.class, args);
    }

}
