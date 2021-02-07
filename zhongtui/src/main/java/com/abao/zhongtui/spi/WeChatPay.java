package com.abao.zhongtui.spi;

public class WeChatPay implements Pay {
    @Override
    public void pay(String key) {
        System.out.println(key + " --->WeChatPay");
    }
}