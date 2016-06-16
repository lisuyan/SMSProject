package org.zjz.dao.impl;
/**
 * 操作课程信息与数据库关系的实现类
 * @author liyan
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import org.zjz.dao.ScheduleDao;
import org.zjz.entity.Schedule;
import org.zjz.entity.Student;
import org.zjz.util.DBUtil;
import org.zjz.util.StringUtil;

public class ScheduleDaoImpl implements ScheduleDao{
	private DBUtil db = new DBUtil();
	private Connection conn = db.getConnection();
	private PreparedStatement ps;
	int i = -1; 
	@Override
	public int addSchedule(Schedule sche) {
		// TODO Auto-generated method stub
		String sql = "insert into schedule values(?,?)";
		int i = -1;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, sche.getCno());
			ps.setString(2, sche.getCname());
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
	public Vector selectSchedule(Schedule sche) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer("select * from schedule");
		int cid = sche.getCno();
		String cname = sche.getCname();
		if(StringUtil.isNotEmpty(cname))
		{
			sql.append(" where cname like '%"+cname+"%'");
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
	public int updateSchedule(Schedule sche) {
		// TODO Auto-generated method stub
		String sql = "update schedule set cname = ? where cno = ?";
		 int i = 0;
		 try {
			ps = conn.prepareStatement(sql);
			System.out.println(sql);
			ps.setString(1, sche.getCname()); 
			ps.setInt(2, sche.getCno());
			 
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
	public int deleteSchedule(Schedule sche) {
		// TODO Auto-generated method stub
		String sql = "delete from schedule where cno = ?";
		int i = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, sche.getCno());
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
