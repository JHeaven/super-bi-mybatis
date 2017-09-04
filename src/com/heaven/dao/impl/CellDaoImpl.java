package com.heaven.dao.impl;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.heaven.dao.CellMapper;
import com.heaven.db.MySqlSessionFactory;
import com.heaven.model.Cell;

public class CellDaoImpl implements CellMapper {

	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Cell record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Cell record) {
		// TODO Auto-generated method stub
		SqlSession sqlSession =null;
		int count=0;
		try {
			sqlSession = MySqlSessionFactory.getSqlSession(true);
			CellMapper cellMapper = sqlSession.getMapper(CellMapper.class);
			count = cellMapper.insert(record);
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
	public Cell selectByPrimaryKey(Long id) {
		Cell cellMap = null;
		SqlSession sqlSession =null;
		try {
			sqlSession = MySqlSessionFactory.getSqlSession(true);
			CellMapper cellMapper = sqlSession.getMapper(CellMapper.class);
			cellMap = cellMapper.selectByPrimaryKey(id);
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

	@Override
	public int updateByPrimaryKeySelective(Cell record) {
		// TODO Auto-generated method stub
				SqlSession sqlSession =null;
				int count=0;
				try {
					sqlSession = MySqlSessionFactory.getSqlSession(true);
					CellMapper cellMapper = sqlSession.getMapper(CellMapper.class);
					count = cellMapper.updateByPrimaryKeySelective(record);
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
	public int updateByPrimaryKey(Cell record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Cell> selectAll() {
		List<Cell> cellMap = null;
		SqlSession sqlSession =null;
		try {
			sqlSession = MySqlSessionFactory.getSqlSession(true);
			CellMapper cellMapper = sqlSession.getMapper(CellMapper.class);
			cellMap = cellMapper.selectAll();
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
