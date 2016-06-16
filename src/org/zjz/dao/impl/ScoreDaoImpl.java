package org.zjz.dao.impl;
/**
 * 操作分数信息与数据库关系的实现类
 * @author liyan
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import org.zjz.dao.ScheduleDao;
import org.zjz.dao.ScoreDao;
import org.zjz.entity.Schedule;
import org.zjz.entity.Student;
import org.zjz.util.DBUtil;
import org.zjz.util.StringUtil;

public class ScoreDaoImpl implements ScoreDao{
	private DBUtil db = new DBUtil();
	private Connection conn = db.getConnection();
	private PreparedStatement ps;
	int i = -1;
	@Override
	public int addScore(int sid,int cid,int grade) {
		// TODO Auto-generated method stub
		String sql = "insert into score values(?,?,?)";
		int i = -1;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, sid);
			ps.setInt(2, cid);
			ps.setInt(3,grade);
			System.out.println(sql);
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
	public Vector selectScore(Student stu) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer("select s.sname,s.sid,sr.grade,sc.cno from score sr join stu s on sr.sid = s.sid join schedule sc on sr.cid = sc.cno");
		int sid = stu.getSid();
		//System.out.println(sql);
		if(StringUtil.isNotEmpty(sid+""))
		{
			sql.append(" where s.sid = "+sid);
		}
		//System.out.println(sql);
		Vector vec = new Vector();
		try {
			ps = conn.prepareStatement(sql.toString());
			System.out.println(sql.toString());
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Vector v = new Vector();
				v.add(rs.getString(1));
				v.add(rs.getInt(2));
				v.add(rs.getInt(3));
				v.add(rs.getString(4));
				
				vec.add(v);
			}
			//return vec;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//return vec;
		}finally{
			System.out.println(vec);
			return vec;
		}
	}
	@Override
	public int updateScore(Student stu) {
		// TODO Auto-generated method stub
		String sql = "update score set sid = ? where cno = ?";
		 int i = 0;
		 try {
			ps = conn.prepareStatement(sql);
			System.out.println(sql);
			ps.setInt(1, stu.getSid());
			ps.setString(2, stu.getSname()); 
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
	public int deleteScore(Student stu) {
		// TODO Auto-generated method stub
		String sql = "delete from score where sid = ?";
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
