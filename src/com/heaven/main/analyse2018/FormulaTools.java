package com.heaven.main.analyse2018;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class FormulaTools {
	public static void main(String[] args) throws SQLException {
		ResultSet rs = null;
		PreparedStatement s1 = null;
		Connection cn1 = null;

		String SourceFromAdd = "jdbc:oracle:thin:@10.1.196.200:1521:zjdevdb";
		String SourceFromUser = "j1_sgs";
		String SourceFromPass = "SGS.sgs123";

		String datanum = "";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn1 = DriverManager.getConnection(SourceFromAdd, SourceFromUser, SourceFromPass);
			if (cn1 != null) {
				s1 = cn1.prepareStatement(
						"select '\"' || bbmc || '\":[' || xml || '],' as xml from ("
						+ "select bbmc, substr(xml, 0, instr(xml, ',', -1) - 1) as xml from ("
						+ "select bbmc, xmlagg(xmlparse(content bodys || ',' wellformed) order by bbmc) .getclobval() as xml from ("
						+ "select t.BBMC, "
						+ "'[\"' || replace(t.formula, '\"', '''') || '\",\"' || replace(t.tips, '\"', '''') || '\",\"' || t.flag || '\"]' as bodys "
						+ "from GY_BBCX_SHXX_FORMULAS t where t.Nfsq = 2018 AND t.yxbz = 'Y'"
						+ ") group by bbmc))");
				rs = s1.executeQuery();

				while (rs.next()) {
					datanum = rs.getString(1);
					System.out.println(datanum);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			s1.close();
			cn1.close();
		}
	}
}
