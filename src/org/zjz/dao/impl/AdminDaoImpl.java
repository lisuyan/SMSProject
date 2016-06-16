package org.zjz.dao.impl;
/**
 * 操作管理员信息与数据库关系的实现类
 * @author liyan
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.zjz.dao.AdminDao;
import org.zjz.entity.Admin;
import org.zjz.util.DBUtil;

public class AdminDaoImpl implements AdminDao{

	@Override
	public Admin selectByNameAndPwd(Admin admin) {
		// TODO Auto-generated method stub
		DBUtil db = new DBUtil();
		Connection conn = db.getConnection();
		PreparedStatement ps;
		ResultSet rs;
	
		String name = admin.getAname();
		String pwd = admin.getApsw();
		Admin a = null;
		String sql = "select * from admin where username = ? and password = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pwd);
			System.out.println(pwd);
			System.out.println(name);
			rs = ps.executeQuery();
			if(rs.next())
			{
				String aname= rs.getString(1);
				String apwd = rs.getString(2);
				a = new Admin(aname,apwd);
				a.setAname(aname);
				a.setApsw(apwd);
			}
			return a;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return a;
		}
		
		finally
		{
			db.close();
		}
	}
}
