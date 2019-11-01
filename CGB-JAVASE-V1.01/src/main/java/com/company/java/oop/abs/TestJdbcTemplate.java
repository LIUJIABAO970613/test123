package com.company.java.oop.abs;
import java.sql.Connection;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariDataSource;
/**借助此对象实现与数据库的交互*/
class JdbcTemplate{
	//DataSource为java中连接池规范
	//ref(has a) 
	private DataSource dataSource;
	public JdbcTemplate(DataSource dataSource) {
		this.dataSource=dataSource;
	}
	public Connection getConnection()throws Exception {
		return dataSource.getConnection();
	}
}
/**借助此对象创建连接池对象*/
interface DataSourceFactory{
	  /**HiKariCP连接池*/
	 static DataSource newHiKariCP() {
		 HikariDataSource hds=
		 new HikariDataSource();
		 hds.setJdbcUrl("jdbc:mysql:///test?serverTimezone=GMT");
		 hds.setUsername("root");
		 hds.setPassword("root");
		 //hds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		 return hds;
	 }
	 static DataSource newDruid() {
		 return null;
	 }
}

public class TestJdbcTemplate {
    public static void main(String[] args)throws Exception {
    	DataSource dataSource=
    	DataSourceFactory.newHiKariCP();
		JdbcTemplate jt=
		new JdbcTemplate(dataSource);
		Connection conn=
		jt.getConnection();
		System.out.println(conn);
	}
}





