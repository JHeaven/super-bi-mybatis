package com.heaven.dao.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.heaven.dao.GyBbcxPzFbHzqMapper;
import com.heaven.db.MySqlSessionFactory;
import com.heaven.model.GyBbcxPzFbHzq;

public class GYHDaoImpl implements GyBbcxPzFbHzqMapper {

	@Override
	public int deleteByPrimaryKey(BigDecimal id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(GyBbcxPzFbHzq record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(GyBbcxPzFbHzq record) {
		SqlSession sqlSession = null;
		int count = 0;
		try {
			sqlSession = MySqlSessionFactory.getSqlSession(true);
			GyBbcxPzFbHzqMapper gyBbcxPzFbHzqMapper = sqlSession.getMapper(GyBbcxPzFbHzqMapper.class);
			count = gyBbcxPzFbHzqMapper.insertSelective(record);
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
	public GyBbcxPzFbHzq selectByPrimaryKey(BigDecimal id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(GyBbcxPzFbHzq record) {
		SqlSession sqlSession = null;
		int count = 0;
		try {
			sqlSession = MySqlSessionFactory.getSqlSession(true);
			GyBbcxPzFbHzqMapper gyBbcxPzFbHzqMapper = sqlSession.getMapper(GyBbcxPzFbHzqMapper.class);
			count = gyBbcxPzFbHzqMapper.updateByPrimaryKeySelective(record);
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
	public int updateByPrimaryKey(GyBbcxPzFbHzq record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<GyBbcxPzFbHzq> selectAll() {
		// TODO Auto-generated method stub
		List<GyBbcxPzFbHzq> allGy = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = MySqlSessionFactory.getSqlSession(true);
			GyBbcxPzFbHzqMapper gyBbcxPzFbHzqMapper = sqlSession.getMapper(GyBbcxPzFbHzqMapper.class);
			allGy = gyBbcxPzFbHzqMapper.selectAll();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
				sqlSession = null;
			}
		}
		return allGy;
	}

}
