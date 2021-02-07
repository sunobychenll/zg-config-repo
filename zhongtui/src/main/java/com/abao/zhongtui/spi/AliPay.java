package com.abao.zhongtui.spi;

public class AliPay implements Pay {
    @Override
    public void pay(String key) {
        System.out.println(key + " ---> AliPay");
    }
}