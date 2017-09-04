package com.heaven.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.heaven.dao.impl.CellDaoImpl;
import com.heaven.model.Cell;

public class ConstructorCell {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> demos = new HashSet<>();
		demos.add("BB_HSTJ");
		demos.add("V_BB_HSTJ");
		demos.add("BB_SBTJ_SDS_FJM_LS");
		demos.add("BB_SBTJ_SDS_FJM");
		demos.add("BB_SBTJ_SDS_LS");
		demos.add("BB_SBTJ_SDS");
		demos.add("BB_SBTJ_ZZS");
		demos.add("BB_SBTJ");
		demos.add("DM_SWJG");
		demos.add("KJ_BB_SJ06_SDSJM_NEW2");
		demos.add("KJ_BB_SJ06_SDSJM");
		demos.add("KJ_BB_SJ14");
		demos.add("KJ_BB_XYB_WR");
		demos.add("KJ_BB_XYB");
		demos.add("KJ_BB_YCLXX");
		demos.add("KJ_HSLS_201");
		demos.add("KJ_HSLS_205");
		demos.add("KJ_HSLS_208");
		demos.add("KJ_HSYE_101");
		demos.add("KJ_HSYE_102");
		demos.add("KJ_HSYE_103");
		demos.add("KJ_HSYE_201");
		demos.add("KJ_HSYE_202_NEW2");
		demos.add("KJ_HSYE_202");
		demos.add("KJ_HSYE_203");
		demos.add("KJ_HSYE_204");
		demos.add("KJ_HSYE_205");
		demos.add("KJ_HSYE_206");
		demos.add("KJ_HSYE_207");
		demos.add("KJ_HSYE_208");
		demos.add("KJ_HSYE_209");
		demos.add("KJ_HSYE_302");
		demos.add("KJ_NSRDZKJ_NSRDZ");
		demos.add("KJ_ZNJKJ_ZNJ");
		demos.add("QC_ZMQ_NSR_205");
		demos.add("V_KJ_HSLS_205");
		demos.add("V_KJ_HSYE_205_2017");
		demos.add("V_KJ_HSYE_205");
		demos.add("V_KJ_HSYE_206_2017");
		demos.add("V_KJ_HSYE_NSR_205_ZMQ_2017");
		demos.add("V_KJ_MDTXX_ZMQ_2017");
		demos.add("V_KJ_MDTXX");
		demos.add("V_KJ_QYHX_TEST");
		demos.add("V_KJ_TTXX");
		demos.add("V_KJ_ZQJMXX");
		demos.add("V_KJ_ZZSMDT_205_YGZ");
		demos.add("V_KJ_ZZSMDT_205");
		demos.add("V_KJ_ZZSMDTQCLS_205");
		
		
		demos.add("V_BB_SBTJ_SDS_FJM_LS");
		demos.add("V_BB_SBTJ_SDS_FJM");
		demos.add("V_BB_SBTJ_SDS_LS");
		demos.add("V_BB_SBTJ_SDS");
		demos.add("V_BB_SBTJ_ZZS");
		demos.add("V_BB_SBTJ");
		demos.add("V_DM_SWJG");
		demos.add("V_KJ_BB_SJ06_SDSJM_NEW2");
		demos.add("V_KJ_BB_SJ06_SDSJM");
		demos.add("V_KJ_BB_SJ14");
		demos.add("V_KJ_BB_XYB_WR");
		demos.add("V_KJ_BB_XYB");
		demos.add("V_KJ_BB_YCLXX");
		demos.add("V_KJ_HSLS_201");
		demos.add("V_KJ_HSLS_205");
		demos.add("V_KJ_HSLS_208");
		demos.add("V_KJ_HSYE_101");
		demos.add("V_KJ_HSYE_102");
		demos.add("V_KJ_HSYE_103");
		demos.add("V_KJ_HSYE_201");
		demos.add("V_KJ_HSYE_202_NEW2");
		demos.add("V_KJ_HSYE_202");
		demos.add("V_KJ_HSYE_203");
		demos.add("V_KJ_HSYE_204");
		demos.add("V_KJ_HSYE_205");
		demos.add("V_KJ_HSYE_206");
		demos.add("V_KJ_HSYE_207");
		demos.add("V_KJ_HSYE_208");
		demos.add("V_KJ_HSYE_209");
		demos.add("V_KJ_HSYE_302");
		demos.add("V_KJ_NSRDZKJ_NSRDZ");
		demos.add("V_KJ_ZNJKJ_ZNJ");
		demos.add("V_QC_ZMQ_NSR_205");
		
		
		
		
		
		
		CellDaoImpl cellDao = new CellDaoImpl();
		List<Cell> allCell = cellDao.selectAll();
		
		for (Iterator iterator = allCell.iterator(); iterator.hasNext();) {
			Cell cell = (Cell) iterator.next();
			
			
			if (cell.getFilterzz()!=null && !"".equals(cell.getFilterzz())) {
				for (Iterator iterator1 = demos.iterator(); iterator1.hasNext();) {
					String string = (String) iterator1.next();
					if (cell.getFilterzz().contains(string+".")) {
						cell.setFilterzz(cell.getFilterzz().replace(string+".", ""));
					}
				}
			}
			
			
			
			cellDao.updateByPrimaryKeySelective(cell);
			
		}
		
		
	}

}
