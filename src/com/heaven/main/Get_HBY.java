package com.heaven.main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.heaven.dao.impl.CellBYDaoImpl;
import com.heaven.dao.impl.GYHDaoImpl;
import com.heaven.dao.impl.GYLDaoImpl;
import com.heaven.model.CellBy;
import com.heaven.model.GyBbcxPzFbHzq;
import com.heaven.model.GyBbcxPzFbLzq;
/**
 * SJ-01 到 SJ-40
 * 行列表样分离
 * @author jiangyqc
 *
 */
public class Get_HBY {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Integer> demos = new HashMap<String, Integer>();
		demos.put("A", 1);
		demos.put("B", 2);
		demos.put("C", 3);
		demos.put("D", 4);
		demos.put("E", 5);
		demos.put("F", 6);
		demos.put("G", 7);
		demos.put("H", 8);
		demos.put("I", 9);
		demos.put("J", 10);
		demos.put("K", 11);
		demos.put("L", 12);
		demos.put("M", 13);
		demos.put("N", 14);
		demos.put("O", 15);
		demos.put("P", 16);
		demos.put("Q", 17);
		demos.put("R", 18);
		demos.put("S", 19);
		demos.put("T", 20);
		demos.put("U", 21);
		demos.put("V", 22);
		demos.put("W", 23);
		demos.put("X", 24);
		demos.put("Y", 25);
		demos.put("Z", 26);

		demos.put("AA", 27);
		demos.put("AB", 28);
		demos.put("AC", 29);
		demos.put("AD", 30);
		demos.put("AE", 31);
		demos.put("AF", 32);
		demos.put("AG", 33);
		demos.put("AH", 34);
		demos.put("AI", 35);
		demos.put("AJ", 36);
		demos.put("AK", 37);
		demos.put("AL", 38);
		demos.put("AM", 39);
		demos.put("AN", 40);
		demos.put("AO", 41);
		demos.put("AP", 42);
		demos.put("AQ", 43);
		demos.put("AR", 44);
		demos.put("AS", 45);
		demos.put("AT", 46);
		demos.put("AU", 47);
		demos.put("AV", 48);
		demos.put("AW", 49);
		demos.put("AX", 50);
		demos.put("AY", 51);
		demos.put("AZ", 52);

		demos.put("BA", 53);
		demos.put("BB", 54);
		demos.put("BC", 55);
		demos.put("BD", 56);
		demos.put("BE", 57);

		GYHDaoImpl HDao = new GYHDaoImpl();
		GYLDaoImpl LDao = new GYLDaoImpl();

		CellBYDaoImpl cellDao = new CellBYDaoImpl();
		List<CellBy> cellByAll = cellDao.selectAll();

		// clean
		for (Iterator iterator = cellByAll.iterator(); iterator.hasNext();) {
			CellBy cellBy = (CellBy) iterator.next();
			if (!cellBy.getReportName().contains("SJ-")) {
				iterator.remove();
			}
		}

		List<GyBbcxPzFbHzq> cellByAllH = new ArrayList<GyBbcxPzFbHzq>();
		List<GyBbcxPzFbLzq> cellByAllL = new ArrayList<GyBbcxPzFbLzq>();

		GyBbcxPzFbHzq hTemp = null;
		GyBbcxPzFbLzq lTemp = null;

		// B
		for (Iterator iterator = cellByAll.iterator(); iterator.hasNext();) {
			CellBy cellBy = (CellBy) iterator.next();
			if (cellBy.getByCell().contains("B") && !cellBy.getByCell().contains("AB")
					&& !cellBy.getByCell().contains("BA") && !cellBy.getByCell().contains("BB")) {

				hTemp = new GyBbcxPzFbHzq();
				hTemp.setId(new BigDecimal("1"));
				hTemp.setbName(cellBy.getReportName());
				try {
					hTemp.setHh(new BigDecimal(cellBy.getByCell().replace("B", "")));
				} catch (Exception e) {
					System.out.println(cellBy);
					e.printStackTrace();
				}
				hTemp.setZqtj(cellBy.getByCondition());
				hTemp.setSjBydm("SGS_" + cellBy.getReportName().replace("-", ""));
				hTemp.setUuid(hTemp.getSjBydm() + "02" + hTemp.getHh());

				if (HDao.insertSelective(hTemp) > 0) {
					System.out.println("B record + 1");

				} else {
					System.out.println(cellBy.getReportAlias() + " -----" + cellBy.getByCell() + "failure!");
				}

				iterator.remove();
			}
		}

		// C
		for (Iterator iterator = cellByAll.iterator(); iterator.hasNext();) {
			CellBy cellBy = (CellBy) iterator.next();
			if (cellBy.getByCell().contains("C")
					&& (cellBy.getReportName().equals("SJ-25") || cellBy.getReportName().equals("SJ-38"))) {

				hTemp = new GyBbcxPzFbHzq();
				hTemp.setId(new BigDecimal("1"));
				hTemp.setbName(cellBy.getReportName());
				try {
					hTemp.setHh(new BigDecimal(cellBy.getByCell().replace("C", "")));
				} catch (Exception e) {
					System.out.println(cellBy);
					e.printStackTrace();
				}
				hTemp.setZqtj(cellBy.getByCondition());
				hTemp.setSjBydm("SGS_" + cellBy.getReportName().replace("-", ""));
				hTemp.setUuid(hTemp.getSjBydm() + "03" + hTemp.getHh());

				if (HDao.insertSelective(hTemp) > 0) {
					System.out.println("C record + 1");

				} else {
					System.out.println(cellBy.getReportAlias() + " -----" + cellBy.getByCell() + "failure!");
				}

				iterator.remove();

			}
		}

		// Y
		for (Iterator iterator = cellByAll.iterator(); iterator.hasNext();) {
			CellBy cellBy = (CellBy) iterator.next();
			if (cellBy.getByCell().contains("Y") && cellBy.getReportName().equals("SJ-30")) {

				hTemp = new GyBbcxPzFbHzq();
				hTemp.setId(new BigDecimal("1"));
				hTemp.setbName(cellBy.getReportName());
				try {
					hTemp.setHh(new BigDecimal(cellBy.getByCell().replace("Y", "")));
				} catch (Exception e) {
					System.out.println(cellBy);
					e.printStackTrace();
				}
				hTemp.setZqtj(cellBy.getByCondition());
				hTemp.setSjBydm("SGS_" + cellBy.getReportName().replace("-", ""));
				hTemp.setUuid(hTemp.getSjBydm() + "25" + hTemp.getHh());

				if (HDao.insertSelective(hTemp) > 0) {
					System.out.println("Y record + 1");

				} else {
					System.out.println(cellBy.getReportAlias() + " -----" + cellBy.getByCell() + "failure!");
				}

				iterator.remove();

			}
		}

		// z SJ-15
		for (Iterator iterator = cellByAll.iterator(); iterator.hasNext();) {
			CellBy cellBy = (CellBy) iterator.next();
			if (cellBy.getByCell().contains("Z") && cellBy.getReportName().contains("SJ-15")) {

				hTemp = new GyBbcxPzFbHzq();
				hTemp.setId(new BigDecimal("1"));
				hTemp.setbName(cellBy.getReportName());
				try {
					hTemp.setHh(new BigDecimal(cellBy.getByCell().replace("Z", "")));
				} catch (Exception e) {
					System.out.println(cellBy);
					e.printStackTrace();
				}
				hTemp.setZqtj(cellBy.getByCondition());
				hTemp.setSjBydm("SGS_" + cellBy.getReportName().replace("-", ""));
				hTemp.setUuid(hTemp.getSjBydm() + "26" + hTemp.getHh());

				if (HDao.insertSelective(hTemp) > 0) {
					System.out.println("Z-SJ-15 record + 1");

				} else {
					System.out.println(cellBy.getReportAlias() + " -----" + cellBy.getByCell() + "failure!");
				}

				iterator.remove();

			}
		}
		
		// T SJ-17_1
		for (Iterator iterator = cellByAll.iterator(); iterator.hasNext();) {
			CellBy cellBy = (CellBy) iterator.next();
			if (cellBy.getByCell().contains("T") && cellBy.getReportName().contains("SJ-17_1")) {
				
				hTemp = new GyBbcxPzFbHzq();
				hTemp.setId(new BigDecimal("1"));
				hTemp.setbName(cellBy.getReportName());
				try {
					hTemp.setHh(new BigDecimal(cellBy.getByCell().replace("T", "")));
				} catch (Exception e) {
					System.out.println(cellBy);
					e.printStackTrace();
				}
				hTemp.setZqtj(cellBy.getByCondition());
				hTemp.setSjBydm("SGS_" + cellBy.getReportName().replace("-", ""));
				hTemp.setUuid(hTemp.getSjBydm() + "20" + hTemp.getHh());
				
				if (HDao.insertSelective(hTemp) > 0) {
					System.out.println("Z-SJ-17_1 record + 1");
					
				} else {
					System.out.println(cellBy.getReportAlias() + " -----" + cellBy.getByCell() + "failure!");
				}
				
				iterator.remove();
				
			}
		}
		// X SJ-17_1
		for (Iterator iterator = cellByAll.iterator(); iterator.hasNext();) {
			CellBy cellBy = (CellBy) iterator.next();
			if (cellBy.getByCell().contains("X") && cellBy.getReportName().contains("SJ-17_1")) {
				
				hTemp = new GyBbcxPzFbHzq();
				hTemp.setId(new BigDecimal("1"));
				hTemp.setbName(cellBy.getReportName());
				try {
					hTemp.setHh(new BigDecimal(cellBy.getByCell().replace("X", "")));
				} catch (Exception e) {
					System.out.println(cellBy);
					e.printStackTrace();
				}
				hTemp.setZqtj(cellBy.getByCondition());
				hTemp.setSjBydm("SGS_" + cellBy.getReportName().replace("-", ""));
				hTemp.setUuid(hTemp.getSjBydm() + "24" + hTemp.getHh());
				
				if (HDao.insertSelective(hTemp) > 0) {
					System.out.println("Z-SJ-17_1 record + 1");
					
				} else {
					System.out.println(cellBy.getReportAlias() + " -----" + cellBy.getByCell() + "failure!");
				}
				
				iterator.remove();
				
			}
		}
		
		
		// W SJ-17_2
		for (Iterator iterator = cellByAll.iterator(); iterator.hasNext();) {
			CellBy cellBy = (CellBy) iterator.next();
			if (cellBy.getByCell().contains("W") && cellBy.getReportName().contains("SJ-17_2")) {
				
				hTemp = new GyBbcxPzFbHzq();
				hTemp.setId(new BigDecimal("1"));
				hTemp.setbName(cellBy.getReportName());
				try {
					hTemp.setHh(new BigDecimal(cellBy.getByCell().replace("W", "")));
				} catch (Exception e) {
					System.out.println(cellBy);
					e.printStackTrace();
				}
				hTemp.setZqtj(cellBy.getByCondition());
				hTemp.setSjBydm("SGS_" + cellBy.getReportName().replace("-", ""));
				hTemp.setUuid(hTemp.getSjBydm() + "23" + hTemp.getHh());
				
				if (HDao.insertSelective(hTemp) > 0) {
					System.out.println("Z-SJ-17_2 record + 1");
					
				} else {
					System.out.println(cellBy.getReportAlias() + " -----" + cellBy.getByCell() + "failure!");
				}
				
				iterator.remove();
				
			}
		}
		
		// W SJ-17_2
		for (Iterator iterator = cellByAll.iterator(); iterator.hasNext();) {
			CellBy cellBy = (CellBy) iterator.next();
			if (cellBy.getByCell().contains("X") && cellBy.getReportName().contains("SJ-06")) {
				
				hTemp = new GyBbcxPzFbHzq();
				hTemp.setId(new BigDecimal("1"));
				hTemp.setbName(cellBy.getReportName());
				try {
					hTemp.setHh(new BigDecimal(cellBy.getByCell().replace("X", "")));
				} catch (Exception e) {
					System.out.println(cellBy);
					e.printStackTrace();
				}
				hTemp.setZqtj(cellBy.getByCondition());
				hTemp.setSjBydm("SGS_" + cellBy.getReportName().replace("-", ""));
				hTemp.setUuid(hTemp.getSjBydm() + "24" + hTemp.getHh());
				
				if (HDao.insertSelective(hTemp) > 0) {
					System.out.println("SJ-06 record + 1");
					
				} else {
					System.out.println(cellBy.getReportAlias() + " -----" + cellBy.getByCell() + "failure!");
				}
				
				iterator.remove();
				
			}
		}
		// m SJ-23
		for (Iterator iterator = cellByAll.iterator(); iterator.hasNext();) {
			CellBy cellBy = (CellBy) iterator.next();
			if (cellBy.getByCell().contains("M") && cellBy.getReportName().contains("SJ-23")) {
				
				hTemp = new GyBbcxPzFbHzq();
				hTemp.setId(new BigDecimal("1"));
				hTemp.setbName(cellBy.getReportName());
				try {
					hTemp.setHh(new BigDecimal(cellBy.getByCell().replace("M", "")));
				} catch (Exception e) {
					System.out.println(cellBy);
					e.printStackTrace();
				}
				hTemp.setZqtj(cellBy.getByCondition());
				hTemp.setSjBydm("SGS_" + cellBy.getReportName().replace("-", ""));
				hTemp.setUuid(hTemp.getSjBydm() + "13" + hTemp.getHh());
				
				if (HDao.insertSelective(hTemp) > 0) {
					System.out.println("SJ-23 record + 1");
					
				} else {
					System.out.println(cellBy.getReportAlias() + " -----" + cellBy.getByCell() + "failure!");
				}
				
				iterator.remove();
				
			}
		}
		
		// O SJ-13
		for (Iterator iterator = cellByAll.iterator(); iterator.hasNext();) {
			CellBy cellBy = (CellBy) iterator.next();
			if (cellBy.getByCell().contains("O") && cellBy.getReportName().contains("SJ-13")) {
				
				hTemp = new GyBbcxPzFbHzq();
				hTemp.setId(new BigDecimal("1"));
				hTemp.setbName(cellBy.getReportName());
				try {
					hTemp.setHh(new BigDecimal(cellBy.getByCell().replace("O", "")));
				} catch (Exception e) {
					System.out.println(cellBy);
					e.printStackTrace();
				}
				hTemp.setZqtj(cellBy.getByCondition());
				hTemp.setSjBydm("SGS_" + cellBy.getReportName().replace("-", ""));
				hTemp.setUuid(hTemp.getSjBydm() + "15" + hTemp.getHh());
				
				if (HDao.insertSelective(hTemp) > 0) {
					System.out.println("SJ-23 record + 1");
					
				} else {
					System.out.println(cellBy.getReportAlias() + " -----" + cellBy.getByCell() + "failure!");
				}
				
				iterator.remove();
				
			}
		}

		// L
		for (Iterator iterator = cellByAll.iterator(); iterator.hasNext();) {
			CellBy cellBy = (CellBy) iterator.next();

			lTemp = new GyBbcxPzFbLzq();
			lTemp.setId(new BigDecimal("1"));
			lTemp.setbName(cellBy.getReportName());

			try {
				lTemp.setLh(new BigDecimal(demos.get(cleanNumber(cellBy.getByCell()))));
			} catch (Exception e) {
				System.out.println(cellBy);
				e.printStackTrace();
			}

			lTemp.setZqtj(cellBy.getByCondition());
			lTemp.setSjBydm("SGS_" + cellBy.getReportName().replace("-", ""));
			try {
				System.out.println("-----AID:"+cellBy.getByCell());
				lTemp.setUuid(lTemp.getSjBydm() + lTemp.getLh()+Integer.parseInt(cleanChar(cellBy.getByCell())) );
			} catch (NumberFormatException e) {
				System.out.println(cellBy);
				e.printStackTrace();
			}

			if (LDao.insertSelective(lTemp) > 0) {
				System.out.println("LLLLL record + 1");

			} else {
				System.out.println(cellBy.getReportAlias() + " -----" + cellBy.getByCell() + "failure!");
			}

		}

		System.out.println("done: " + cellByAll.size());

	}

	public static String cleanNumber(String str) {
		str = str.replace("0", "");
		str = str.replace("1", "");
		str = str.replace("2", "");
		str = str.replace("3", "");
		str = str.replace("4", "");
		str = str.replace("5", "");
		str = str.replace("6", "");
		str = str.replace("7", "");
		str = str.replace("8", "");
		str = str.replace("9", "");
		return str;
	}

	public static String cleanChar(String str) {
		str = str.replace("A", "");
		str = str.replace("B", "");
		str = str.replace("C", "");
		str = str.replace("D", "");
		str = str.replace("E", "");
		str = str.replace("F", "");
		str = str.replace("G", "");
		str = str.replace("H", "");
		str = str.replace("I", "");
		str = str.replace("J", "");
		str = str.replace("K", "");
		str = str.replace("L", "");
		str = str.replace("M", "");
		str = str.replace("N", "");
		str = str.replace("O", "");
		str = str.replace("P", "");
		str = str.replace("Q", "");
		str = str.replace("R", "");
		str = str.replace("S", "");
		str = str.replace("T", "");
		str = str.replace("U", "");
		str = str.replace("V", "");
		str = str.replace("W", "");
		str = str.replace("X", "");
		str = str.replace("Y", "");
		str = str.replace("Z", "");
		return str;
	}

}
