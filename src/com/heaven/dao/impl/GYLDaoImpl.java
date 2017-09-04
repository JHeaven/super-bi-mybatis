package com.heaven.dao.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.heaven.dao.GyBbcxPzFbLzqMapper;
import com.heaven.db.MySqlSessionFactory;
import com.heaven.model.GyBbcxPzFbLzq;

public class GYLDaoImpl implements GyBbcxPzFbLzqMapper {

	@Override
	public int deleteByPrimaryKey(BigDecimal id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(GyBbcxPzFbLzq record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(GyBbcxPzFbLzq record) {

		SqlSession sqlSession = null;
		int count = 0;
		try {
			sqlSession = MySqlSessionFactory.getSqlSession(true);
			GyBbcxPzFbLzqMapper gyBbcxPzFbLzqMapper = sqlSession.getMapper(GyBbcxPzFbLzqMapper.class);
			count = gyBbcxPzFbLzqMapper.insertSelective(record);
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
	public GyBbcxPzFbLzq selectByPrimaryKey(BigDecimal id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(GyBbcxPzFbLzq record) {

		SqlSession sqlSession = null;
		int count = 0;
		try {
			sqlSession = MySqlSessionFactory.getSqlSession(true);
			GyBbcxPzFbLzqMapper gyBbcxPzFbLzqMapper = sqlSession.getMapper(GyBbcxPzFbLzqMapper.class);
			count = gyBbcxPzFbLzqMapper.updateByPrimaryKeySelective(record);
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
	public int updateByPrimaryKey(GyBbcxPzFbLzq record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<GyBbcxPzFbLzq> selectAll() {
		// TODO Auto-generated method stub
		List<GyBbcxPzFbLzq> allGy = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = MySqlSessionFactory.getSqlSession(true);
			GyBbcxPzFbLzqMapper gyBbcxPzFbLzqMapper = sqlSession.getMapper(GyBbcxPzFbLzqMapper.class);
			allGy = gyBbcxPzFbLzqMapper.selectAll();
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
