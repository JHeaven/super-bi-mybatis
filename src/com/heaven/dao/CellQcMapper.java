package com.heaven.dao;

import java.util.List;

import com.heaven.model.CellQc;

public interface CellQcMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CellQc record);

    int insertSelective(CellQc record);

    CellQc selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CellQc record);

    int updateByPrimaryKey(CellQc record);
    
    List<CellQc> selectAll();

}