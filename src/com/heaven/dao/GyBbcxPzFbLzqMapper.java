package com.heaven.dao;

import com.heaven.model.GyBbcxPzFbLzq;
import java.math.BigDecimal;
import java.util.List;

public interface GyBbcxPzFbLzqMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(GyBbcxPzFbLzq record);

    int insertSelective(GyBbcxPzFbLzq record);

    GyBbcxPzFbLzq selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(GyBbcxPzFbLzq record);

    int updateByPrimaryKey(GyBbcxPzFbLzq record);
    
    List<GyBbcxPzFbLzq> selectAll();

    
}