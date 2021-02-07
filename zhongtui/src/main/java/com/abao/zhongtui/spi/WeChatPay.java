package com.abao.zhongtui.spi;

public class WeChatPay implements Pay {
    @Override
    public void pay() {
        System.out.println("WeChatPay");
    }
}