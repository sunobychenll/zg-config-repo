package com.abao.zhongtui.spi;

public class AliPay implements Pay {
    @Override
    public void pay() {
        System.out.println("AliPay");
    }
}