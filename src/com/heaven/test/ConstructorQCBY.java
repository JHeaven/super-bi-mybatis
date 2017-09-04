package com.heaven.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.heaven.dao.impl.GYHDaoImpl;
import com.heaven.dao.impl.GYLDaoImpl;
import com.heaven.model.GyBbcxPzFbHzq;
import com.heaven.model.GyBbcxPzFbLzq;

/**
 * 解析清册表样到sql语句
 * 
 * @author jiangyqc
 *
 */
public class ConstructorQCBY {

	public static void main(String[] args) {

		GYHDaoImpl HDao = new GYHDaoImpl();
		GYLDaoImpl LDao = new GYLDaoImpl();

		Set<String> demos = new HashSet<>();
		demos.add("BB_HSTJ");
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
		
		
		
		
		List<GyBbcxPzFbHzq> allGyBbcxPzFbHzq = HDao.selectAll();
		for (Iterator iterator = allGyBbcxPzFbHzq.iterator(); iterator.hasNext();) {
			GyBbcxPzFbHzq gyBbcxPzFbHzq = (GyBbcxPzFbHzq) iterator.next();
			if (gyBbcxPzFbHzq.getZqtj() != null) {
				gyBbcxPzFbHzq.setZqtj(gyBbcxPzFbHzq.getZqtj().replace("\"", ""));

				gyBbcxPzFbHzq.setZqtj(gyBbcxPzFbHzq.getZqtj().replace(" like ", " LIKE "));
				gyBbcxPzFbHzq.setZqtj(gyBbcxPzFbHzq.getZqtj().replace("[", "("));
				gyBbcxPzFbHzq.setZqtj(gyBbcxPzFbHzq.getZqtj().replace("]", ")"));
				gyBbcxPzFbHzq.setZqtj(gyBbcxPzFbHzq.getZqtj().replace(" and ", " AND "));
				gyBbcxPzFbHzq.setZqtj(gyBbcxPzFbHzq.getZqtj().replace(" or ", " OR "));

				for (Iterator iterator1 = demos.iterator(); iterator1.hasNext();) {
					String string = (String) iterator1.next();
					if (gyBbcxPzFbHzq.getZqtj().contains(string+".")) {
						gyBbcxPzFbHzq.setZqtj(gyBbcxPzFbHzq.getZqtj().replace(string+".", ""));
					}
				}
				
				
				
				
				
				System.out.println(gyBbcxPzFbHzq.getZqtj());
				
				if (HDao.updateByPrimaryKeySelective(gyBbcxPzFbHzq) > 0 ) {
					System.out.println("H" + 1);
				}

			}

		}
		
		
		
		
		
		
		
		List<GyBbcxPzFbLzq> allGyBbcxPzFbLzq = LDao.selectAll();
		
			
	for (Iterator iterator = allGyBbcxPzFbLzq.iterator(); iterator.hasNext();) {
		GyBbcxPzFbLzq gyBbcxPzFbLzq = (GyBbcxPzFbLzq) iterator.next();
			if (gyBbcxPzFbLzq.getZqtj() != null) {
				gyBbcxPzFbLzq.setZqtj(gyBbcxPzFbLzq.getZqtj().replace("\"", ""));

				gyBbcxPzFbLzq.setZqtj(gyBbcxPzFbLzq.getZqtj().replace(" like ", " LIKE "));
				gyBbcxPzFbLzq.setZqtj(gyBbcxPzFbLzq.getZqtj().replace(" and ", " AND "));
				gyBbcxPzFbLzq.setZqtj(gyBbcxPzFbLzq.getZqtj().replace("[", "("));
				gyBbcxPzFbLzq.setZqtj(gyBbcxPzFbLzq.getZqtj().replace("]", ")"));
				gyBbcxPzFbLzq.setZqtj(gyBbcxPzFbLzq.getZqtj().replace(" or ", " OR "));

				for (Iterator iterator1 = demos.iterator(); iterator1.hasNext();) {
					String string = (String) iterator1.next();
					if (gyBbcxPzFbLzq.getZqtj().contains(string+".")) {
						gyBbcxPzFbLzq.setZqtj(gyBbcxPzFbLzq.getZqtj().replace(string+".", ""));
					}
				}
				
				
				
				
				
				System.out.println(gyBbcxPzFbLzq.getZqtj());
				
				if (LDao.updateByPrimaryKeySelective(gyBbcxPzFbLzq) > 0 ) {
					System.out.println("L + 1");
				}

			}

		}

		
		
		
		
		
	}

	

}
