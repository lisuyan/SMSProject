package org.zjz.dao.impl;
/**
 * 操作学生信息与数据库关系的实现类
 * @author liyan
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import org.zjz.dao.StuDao;
import org.zjz.entity.Student;
import org.zjz.util.DBUtil;
import org.zjz.util.StringUtil;

public class StuDaoImpl implements StuDao{
	private DBUtil db = new DBUtil();
	private Connection conn = db.getConnection();
	private PreparedStatement ps;
	int i = -1; 
	@Override
	public int addStu(Student stu) {
		// TODO Auto-generated method stub
		String sql = "insert into stu values(?,?,?,?,?)";
		int i = -1;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,stu.getSid());
			ps.setString(2, stu.getSname());
			ps.setString(3, stu.getSsex());
			ps.setInt(4, stu.getSage());
			ps.setInt(5, stu.getGid());
			//System.out.println(sql);
			i = ps.executeUpdate();
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(conn!=null) db.close();
		}
		return i;
	}

	@Override
	public Vector selectStu(Student stu) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer("select s.sid,s.sname,s.ssex,s.sage,s.gid from Stu s,groups g where s.gid = g.gid");
		String sname = stu.getSname();
		String sex = stu.getSsex();
		int gid= stu.getGid();
		if(StringUtil.isNotEmpty(sname))
		{
			sql.append(" and s.sname ='" +sname+"'");
		}
		if(gid>0)
		{
			sql.append(" and s.gid =" +gid);
		}
		System.out.println(sql);
		Vector vec = new Vector();
		try {
			ps = conn.prepareStatement(sql.toString());
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Vector v = new Vector();
				v.add(rs.getInt(1));
				v.add(rs.getString(2));
				v.add(rs.getString(3));
				v.add(rs.getInt(4));
				v.add(rs.getInt(5));
				vec.add(v);
			}
			return vec;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return vec;
		}
		
	}

	@Override
	public int updateStu(Student stu) {
		 String sql = "update stu set sid = ?,sname = ?,ssex = ?,sage = ? where gid = ?";
		 int i = 0;
		 try {
			ps = conn.prepareStatement(sql);
			System.out.println(sql);
			ps.setInt(1, stu.getSid());
			ps.setString(2, stu.getSname());
			ps.setString(3,stu.getSsex());
			ps.setInt(4, stu.getSage());
			ps.setInt(5, stu.getGid());
			 
			i = ps.executeUpdate();
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return i;
		}
		finally
		{
			if(conn!=null) db.close();
		}
	}

	@Override
	public int deleteStu(Student stu) {
		// TODO Auto-generated method stub
		String sql = "delete from stu where sid = ?";
		int i = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, stu.getSid());
			i = ps.executeUpdate(); 
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return i;
		}
		finally
		{
			if(conn != null) db.close();
		}
	}
}
