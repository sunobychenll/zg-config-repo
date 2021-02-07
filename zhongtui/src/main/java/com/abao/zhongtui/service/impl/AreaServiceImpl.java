package com.abao.zhongtui.service.impl;

import com.abao.zhongtui.bean.ConsultConfigArea;
import com.abao.zhongtui.dao.CommonMapper;
import com.abao.zhongtui.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    CommonMapper mapper;

//    @Autowired
//    JdbcTemplate jdbcTemplate;

    //@Autowired
  //  RedisTemplate redisTemplate;

    public List<ConsultConfigArea> qryAreaFromBase(Map param) {
        // TODO Auto-generated method stub
        return mapper.qryArea(param);
    }

//    @TargetDataSource(name = "ds2")
    public List<ConsultConfigArea> qryArea(Map param) {
        List<ConsultConfigArea> consultConfigAreas = mapper.qryArea(param);
        return consultConfigAreas;
    }

//    @Transactional
//    @TargetDataSource(name = "ds1")
    public int saveArea(ConsultConfigArea area) {
        int count = mapper.saveArea(area);
        return count;
    }

//    @Transactional
    public int saveAreaToBase(ConsultConfigArea area) {
        // TODO Auto-generated method stub
        return mapper.saveArea(area);
    }
}
