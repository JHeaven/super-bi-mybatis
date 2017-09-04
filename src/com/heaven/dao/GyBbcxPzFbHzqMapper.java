package com.heaven.dao;

import com.heaven.model.GyBbcxPzFbHzq;
import java.math.BigDecimal;
import java.util.List;

public interface GyBbcxPzFbHzqMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(GyBbcxPzFbHzq record);

    int insertSelective(GyBbcxPzFbHzq record);

    GyBbcxPzFbHzq selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(GyBbcxPzFbHzq record);

    int updateByPrimaryKey(GyBbcxPzFbHzq record);
    
    List<GyBbcxPzFbHzq> selectAll();
    
} 