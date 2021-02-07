package com.abao.zhongtui.service.impl;

import com.abao.zhongtui.dao.GoodMapper;
import com.abao.zhongtui.dao2.BuyRecordMapper;
import com.abao.zhongtui.service.BuyRecordService;
import com.abao.zhongtui.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BuyRecordServicempl implements BuyRecordService {


    @Autowired
    BuyRecordMapper buyRecordMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void insertBuyRecord(Integer goodId) {
        int buyStatus = buyRecordMapper.insertBuyRecord(goodId);
        if(buyStatus == 0){
            throw new RuntimeException("添加购买记录失败!");
        }

        if(goodId < 3){
            int a =5/0;
        }

    }
}
