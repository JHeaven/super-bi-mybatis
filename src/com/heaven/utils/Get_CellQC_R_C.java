package com.heaven.utils;

import com.heaven.dao.CellQcMapper;
import com.heaven.model.CellQc;

public class Get_CellQC_R_C {

	public static int getRC(String originalStr, CellQcMapper cellDao, CellQc cellTop) {

		int temp_r = 0;

		String[] originalTwoStr = originalStr.split("</cl>\\r\\n");

		for (int i = 0; i < originalTwoStr.length; i++) {
			// System.out.println("=================================");
			// System.out.println(originalTwoStr[i]);

			String str = originalTwoStr[i] + "</cl>";

			String[] oneStr = str.split("\\r\\n");
			String[] twoStr = null;

			int r = 0;

			int c = 0;

			String temp = oneStr[0].substring(6);
			// System.out.println("temp============"+temp);
			r = Integer.parseInt(temp.substring(0, temp.indexOf(" ")));

			temp = temp.substring(temp.indexOf(" ") + 3);

			int tempLeft = temp.indexOf(" ") < 0 ? temp.indexOf(">") : temp.indexOf(" ");
			c = Integer.parseInt(temp.substring(0, tempLeft));
			System.out.print("r = " + r + " , c = " + c + "  ");

			CellQc cell = new CellQc();

			cell.setRowsnum(new Long(r));
			cell.setColsnum(new Long(c));

			if (temp_r != r) {
				temp_r = r;
				System.out.println("");

			} else {
				// System.out.print("\t");

				// new
				cell = new CellQc();
			}

			for (int i1 = oneStr.length - 1; i1 > 0; i1--) {
				// System.out.println(oneStr[i1]);

				cell.setRowsnum(new Long(r));
				cell.setColsnum(new Long(c));

				if (i1 == 0 || i1 == (oneStr.length - 1)) {
					continue;
				}

				int tempEq = oneStr[i1].indexOf("=");

				twoStr = new String[2];
				twoStr[0] = oneStr[i1].substring(0, tempEq).trim();
				twoStr[1] = oneStr[i1].substring(tempEq + 1).trim();

				// System.out.println(twoStr[0] + "=" + twoStr[1]);

				if ("Text".equals(twoStr[0])) {
					// System.out.print("" + twoStr[1]+" ");

					cell.setText(twoStr[1]);
				}

				if ("fixcaption".equals(twoStr[0])) {
					// System.out.print("fixcaption:" + twoStr[1]+" ");

					cell.setFixcaption(twoStr[1]);

				}

				if ("expzz".equals(twoStr[0])) {
					// System.out.print("表达式:" + twoStr[1]+" ");

					cell.setExpzz(twoStr[1]);

				}

				if ("displayexp".equals(twoStr[0])) {
					// System.out.print("显示表达式:" + twoStr[1]+" ");

					cell.setDisplayexp(twoStr[1]);

				}

				if ("condition".equals(twoStr[0])) {
					// System.out.print("增加过滤条件:" + twoStr[1]+" ");

					cell.setCondition(twoStr[1]);

				}

				if ("filter.zz".equals(twoStr[0])) {
					// System.out.print("增加过滤条件:" + twoStr[1]+" ");

					cell.setFilterzz(twoStr[1]);

				}

				if ("url".equals(twoStr[0])) {
					// System.out.print("链接:" + twoStr[1]+" ");

					cell.setUrl(twoStr[1]);

				}

				if ("DetailName".equals(twoStr[0])) {
					// System.out.print("详细名称:" + twoStr[1]+" ");
					cell.setDetailname(twoStr[1]);
				}
			}

			// add
			cell.setId(100L);
			cell.setReportAlias(cellTop.getReportAlias());
			cell.setReportCaption(cellTop.getReportCaption());
			cell.setReportId(cellTop.getReportId());
			cell.setReportName(cellTop.getReportName());
			cell.setReportTaskid(cellTop.getReportTaskid());
			cell.setReportType(cellTop.getReportType());

			if (cell.getExpzz() != null && !"".equals(cell.getExpzz())) {
				if (cell.getExpzz().indexOf(".") > 0) {
					cell.setRelativeTable(cell.getExpzz().substring(0, cell.getExpzz().indexOf(".")));
					if (cell.getRelativeTable().lastIndexOf("(") > 0) {
						cell.setRelativeTable(cell.getRelativeTable().substring(cell.getRelativeTable().lastIndexOf("(")+1));
					}
					if (cell.getRelativeTable().lastIndexOf(",") > 0) {
						cell.setRelativeTable(cell.getRelativeTable().substring(cell.getRelativeTable().lastIndexOf(",")+1));
					}
				}
			}

			if (cell.getUrl() != null && !"".equals(cell.getUrl())) {
				if (cell.getUrl().contains("_z")) {
					cell.setIsZq("Y");

					if (cell.getUrl().contains("_zmenu")) {
						// multiue

						String cellUrlWithZq = cell.getUrl().replace(" ", "");
						int _zMenu = cellUrlWithZq.indexOf("_z,");
						cell.setQcName("");
						while (_zMenu > 0) {

							cellUrlWithZq = cellUrlWithZq.substring(_zMenu + 4);
							int temp1 = cellUrlWithZq.indexOf("','") < cellUrlWithZq.indexOf("'")
									? cellUrlWithZq.indexOf("','")
									: cellUrlWithZq.indexOf("'");

							cell.setQcName(cell.getQcName() + cellUrlWithZq.substring(0, temp1) + "=");
							_zMenu = cellUrlWithZq.indexOf("_z,");
						}

						cell.setQcName(cell.getQcName().substring(0, cell.getQcName().length() - 1));

					} else {
						// single
						if (!cell.getUrl().contains("_zr()")) {
							String tempstr = cell.getUrl().substring(cell.getUrl().indexOf("javascript:_z('") + 15);
							cell.setQcName(tempstr.substring(0,tempstr.indexOf("',") < 0 ?tempstr.indexOf("')"): tempstr.indexOf("',")));
						}

					}
				} else {
					cell.setIsZq("N");
				}

			} else {
				cell.setIsZq("N");
			}

			int isOK = 0;
			System.out
					.println(cellDao.insertSelective(cell) > 0 ? " result : record + 1" : " result : record failed !");

			// System.out.println("==============================");

		}

		return 0;
	}

}
