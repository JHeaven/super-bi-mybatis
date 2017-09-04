package com.heaven.dao.impl;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.heaven.dao.CellByMapper;
import com.heaven.db.MySqlSessionFactory;
import com.heaven.model.CellBy;

public class CellBYDaoImpl implements CellByMapper {

	@Override
	public int insertSelective(CellBy record) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = null;
		int count = 0;
		try {
			sqlSession = MySqlSessionFactory.getSqlSession(true);
			CellByMapper cellByMapper = sqlSession.getMapper(CellByMapper.class);
			count = cellByMapper.insert(record);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
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
	public int insert(CellBy record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CellBy selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(CellBy record) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = null;
		int count = 0;
		try {
			sqlSession = MySqlSessionFactory.getSqlSession(true);
			CellByMapper cellByMapper = sqlSession.getMapper(CellByMapper.class);
			count = cellByMapper.updateByPrimaryKeySelective(record);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
				sqlSession = null;
			}
		}
		return count;
	}

	@Override
	public int updateByPrimaryKey(CellBy record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CellBy> selectAll() {
		List<CellBy> cellMap = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = MySqlSessionFactory.getSqlSession(true);
			CellByMapper cellByMapper = sqlSession.getMapper(CellByMapper.class);
			cellMap = cellByMapper.selectAll();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
				sqlSession = null;
			}
		}
		return cellMap;
	}

}
