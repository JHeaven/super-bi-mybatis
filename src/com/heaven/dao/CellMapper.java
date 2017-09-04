package com.heaven.dao;

import java.util.List;

import com.heaven.model.Cell;

public interface CellMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Cell record);

    int insertSelective(Cell record);

    Cell selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Cell record);

    int updateByPrimaryKey(Cell record);
    
    List<Cell> selectAll();
}