package com.abao.zhongtui.service.impl;

import com.abao.zhongtui.dao.GoodMapper;
import com.abao.zhongtui.dao2.BuyRecordMapper;
import com.abao.zhongtui.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GoodServicempl implements GoodService {

    @Autowired
    GoodMapper goodMapper;

    @Autowired
    BuyRecordMapper buyRecordMapper;

    @Transactional(propagation=Propagation.NESTED)
    @Override
    public void buyGoods(Integer goodId) {
        int status = goodMapper.updateGoodsNum(goodId);
        if(status == 0){
           throw  new RuntimeException("更新商品库存失败!");
        }
        if(goodId > 5){
            int a =5/0;
        }


    }
}
