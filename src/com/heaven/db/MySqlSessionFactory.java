package com.heaven.db;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 获取sqlsession
 * @author HEAVEN
 * 
 */

public class MySqlSessionFactory {

	/**
	 * 获取sqlsessionfactory
	 * 
	 * @throws IOException
	 */

	public static SqlSessionFactory getSqlSessionFactory() throws IOException {
		//0.xml文件的路径相对于src目录
		//1.jar包中Resources.class有多个方法（多个返回值）实现读取xml文件（控制读取的格式）
		//2.jar包中classLoaderWrapper.class实现读取，判断classloader是否null，找到xml文件路径，没有xml则报错
		//3.最后利用java提供的classloader.class读取文件
		InputStream inputStream = Resources.getResourceAsStream("conf.xml");
		
		//1.jar包中SqlSessionFactoryBuilder.class重载了多个build方法，允许InputStream，reader，以及用生成类的方法创建sessionfactory
		//2.找到合适的build入口之后 利用jar包中的XMLConfigBuilder 解析上面得到的xml文件流
		//3.得到XMLConfigBuilder对象，转换成Configuration，利用new DefaultSqlSessionFactory得到SqlSessionFactory
		return new SqlSessionFactoryBuilder().build(inputStream);

	}
	
	/**
	 * 得到sqlsession
	 * 注意：默认不是自动提交
	 * @return
	 * @throws IOException
	 */
	
	public static SqlSession getSqlSession() throws IOException{
		//重载了多个opensession方法，利用DefaultSqlSessionFactory方法根据各种配置信息打开一个会话
		return getSqlSessionFactory().openSession();
	}
	
	/**
	 * 得到sqlsession
	 * 是否自动提交
	 * @param isAutoCommit
	 * @return
	 * @throws IOException
	 */
	public static SqlSession getSqlSession(boolean isAutoCommit) throws IOException{
		return getSqlSessionFactory().openSession(isAutoCommit);
	}
	

}