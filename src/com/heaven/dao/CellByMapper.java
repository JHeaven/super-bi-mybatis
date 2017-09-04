package com.heaven.dao;

import java.util.List;

import com.heaven.model.CellBy;

public interface CellByMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CellBy record);

    int insertSelective(CellBy record);

    CellBy selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CellBy record);

    int updateByPrimaryKey(CellBy record);
    
    List<CellBy> selectAll();

}