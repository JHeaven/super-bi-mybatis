package com.heaven.test;

import org.junit.Test;

import com.heaven.dao.impl.CellBYDaoImpl;
import com.heaven.dao.impl.CellDaoImpl;
import com.heaven.dao.impl.CellQCDaoImpl;
import com.heaven.model.Cell;
import com.heaven.model.CellQc;

public class CellDaoTest {

	
	@Test
	public void insert() {
		//׼������  
        Cell cell = new Cell();  
        cell.setId(1L);
        cell.setCondition("condition");
        cell.setDisplayexp("displayexp");
        cell.setExpzz("expzz");
        cell.setFilterzz("filterzz");
        cell.setFixcaption("fixcaption");
        cell.setText("text");
        cell.setUrl("url");
        cell.setDetailname("detailName");
        cell.setRowsnum(88L);
        cell.setColsnum(99L);
		
        CellDaoImpl cellDao = new CellDaoImpl();
        int temp  = cellDao.insertSelective(cell);
		System.out.println("do:"+temp);
	}
	
	
	@Test
	public void insertQC() {
		//׼������  
        CellQc cell = new CellQc();  
        cell.setId(1L);
        cell.setCondition("condition");
        cell.setDisplayexp("displayexp");
        cell.setExpzz("expzz");
        cell.setFilterzz("filterzz");
        cell.setFixcaption("fixcaption");
        cell.setText("text");
        cell.setUrl("url");
        cell.setDetailname("detailName");
        cell.setRowsnum(88L);
        cell.setColsnum(99L);
		
        CellQCDaoImpl cellDao = new CellQCDaoImpl();
        int temp  = cellDao.insertSelective(cell);
		System.out.println("do:"+temp);
	}
	
	
	@Test
	public void selectby() {
		//׼������  
        CellBYDaoImpl cellDao = new CellBYDaoImpl();
		System.out.println("do:"+cellDao.selectAll().size());
	}
	
	@Test
	public void selectqc() {
		//׼������  
		CellQCDaoImpl cellDao = new CellQCDaoImpl();
		System.out.println("do:"+cellDao.selectAll().size());
	}
	
	@Test
	public void select() {
		//׼������  
		CellDaoImpl cellDao = new CellDaoImpl();
		System.out.println("do:"+cellDao.selectAll().size());
	}
	
	
	
	
	@Test
	public void selectById() {
		//׼������  
		CellDaoImpl cellDao = new CellDaoImpl();
		System.out.println("do:"+cellDao.selectByPrimaryKey(81127L));
	}
	
	
	
	
	
}
