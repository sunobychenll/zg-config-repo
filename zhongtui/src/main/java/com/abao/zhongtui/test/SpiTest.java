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

    }

    public static void main(String[] args) {

//        People plus = new Gril();
//        plus.People();
//        People division = new Boy();
//        division.People();

        //服务加载器，加载实现类
      //  System.out.println("classPath:"+System.getProperty("java.class.path"));
//        System.setSecurityManager(new SecurityManager());
//        ServiceLoader<People> serviceLoader = ServiceLoader.load(People.class);
//        Iterator<People> iterator = serviceLoader.iterator();
//
//        while (iterator.hasNext()){
//            People itor = iterator.next();
//            itor.People();
//            System.out.println("1111111");
//        }


        ServiceLoader<Pay> spiDemoServiceLoader = ServiceLoader.load(Pay.class);

        Iterator<Pay> payIterator = spiDemoServiceLoader.iterator();
        while (payIterator.hasNext()){
            Pay pay = payIterator.next();
            pay.pay();
        }
    }


}
