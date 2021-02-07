package com.abao.zhongtui.service;


import com.abao.zhongtui.bean.ConsultConfigArea;

import java.util.List;
import java.util.Map;

public interface AreaService {
    public List<ConsultConfigArea> qryAreaFromBase(Map param);
    
    public List<ConsultConfigArea> qryArea(Map param);
    
    public int saveArea(ConsultConfigArea area);
    
    public int saveAreaToBase(ConsultConfigArea area);

}
