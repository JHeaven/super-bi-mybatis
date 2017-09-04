package com.heaven.dao.impl;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.heaven.dao.CellByMapper;
import com.heaven.dao.CellQcMapper;
import com.heaven.db.MySqlSessionFactory;
import com.heaven.model.CellBy;
import com.heaven.model.CellQc;

public class CellQCDaoImpl implements CellQcMapper {

	

	@Override
	public int insertSelective(CellQc record) {
		// TODO Auto-generated method stub
		SqlSession sqlSession =null;
		int count=0;
		try {
			sqlSession = MySqlSessionFactory.getSqlSession(true);
			CellQcMapper cellQCMapper = sqlSession.getMapper(CellQcMapper.class);
			count = cellQCMapper.insert(record);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(sqlSession != null) {
				sqlSession.close();
				sqlSession = null;
			}
		}
		return count;
	}

	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(CellQc record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CellQc selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(CellQc record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(CellQc record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CellQc> selectAll() {
		List<CellQc> cellMap = null;
		SqlSession sqlSession =null;
		try {
			sqlSession = MySqlSessionFactory.getSqlSession(true);
			CellQcMapper cellQcMapper = sqlSession.getMapper(CellQcMapper.class);
			cellMap = cellQcMapper.selectAll();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(sqlSession != null) {
				sqlSession.close();
				sqlSession = null;
			}
		}
		return cellMap;
	}

}
