package com.abao.zhongtui.dao;


import com.abao.zhongtui.bean.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface GoodMapper {
    

    
    int updateGoodsNum(Integer goodId);

    @Select("select * from goods")
    List<Goods> selectAll();
}
