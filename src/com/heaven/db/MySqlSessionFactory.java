package com.heaven.db;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * ��ȡsqlsession
 * @author HEAVEN
 * 
 */

public class MySqlSessionFactory {

	/**
	 * ��ȡsqlsessionfactory
	 * 
	 * @throws IOException
	 */

	public static SqlSessionFactory getSqlSessionFactory() throws IOException {
		//0.xml�ļ���·�������srcĿ¼
		//1.jar����Resources.class�ж���������������ֵ��ʵ�ֶ�ȡxml�ļ������ƶ�ȡ�ĸ�ʽ��
		//2.jar����classLoaderWrapper.classʵ�ֶ�ȡ���ж�classloader�Ƿ�null���ҵ�xml�ļ�·����û��xml�򱨴�
		//3.�������java�ṩ��classloader.class��ȡ�ļ�
		InputStream inputStream = Resources.getResourceAsStream("conf.xml");
		
		//1.jar����SqlSessionFactoryBuilder.class�����˶��build����������InputStream��reader���Լ���������ķ�������sessionfactory
		//2.�ҵ����ʵ�build���֮�� ����jar���е�XMLConfigBuilder ��������õ���xml�ļ���
		//3.�õ�XMLConfigBuilder����ת����Configuration������new DefaultSqlSessionFactory�õ�SqlSessionFactory
		return new SqlSessionFactoryBuilder().build(inputStream);

	}
	
	/**
	 * �õ�sqlsession
	 * ע�⣺Ĭ�ϲ����Զ��ύ
	 * @return
	 * @throws IOException
	 */
	
	public static SqlSession getSqlSession() throws IOException{
		//�����˶��opensession����������DefaultSqlSessionFactory�������ݸ���������Ϣ��һ���Ự
		return getSqlSessionFactory().openSession();
	}
	
	/**
	 * �õ�sqlsession
	 * �Ƿ��Զ��ύ
	 * @param isAutoCommit
	 * @return
	 * @throws IOException
	 */
	public static SqlSession getSqlSession(boolean isAutoCommit) throws IOException{
		return getSqlSessionFactory().openSession(isAutoCommit);
	}
	

}