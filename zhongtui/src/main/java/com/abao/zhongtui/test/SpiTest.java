package com.abao.zhongtui.test;


import com.abao.zhongtui.spi.Pay;
import org.junit.Test;

import java.util.Iterator;
import java.util.ServiceLoader;

public class SpiTest {

    /**
     * java spi机制验证
     */
    @Test
    public void javaSPI() {
        //找不到的话  在pom文件   <resource> <include>**/**</include>
        ServiceLoader<Pay> spiDemoServiceLoader = ServiceLoader.load(Pay.class);

        Iterator<Pay> payIterator = spiDemoServiceLoader.iterator();
        while (payIterator.hasNext()){
            Pay pay = payIterator.next();
            pay.pay();
        }
    }

    public static void main(String[] args) {


        //找不到的话  在pom文件   <resource> <include>**/**</include>
        ServiceLoader<Pay> spiDemoServiceLoader = ServiceLoader.load(Pay.class);

        Iterator<Pay> payIterator = spiDemoServiceLoader.iterator();
        while (payIterator.hasNext()){
            Pay pay = payIterator.next();
            pay.pay();
        }
    }


}
