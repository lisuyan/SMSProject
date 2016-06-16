package org.zjz.dao.impl;
/**
 * 操作组信息与数据库关系的实现类
 * @author liyan
 */
import java.nio.channels.SelectableChannel;
import java.security.acl.Group;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import org.zjz.dao.GroupsDao;
import org.zjz.entity.Groups;
import org.zjz.util.DBUtil;
import org.zjz.util.StringUtil;

public class GroupsDaoImpl implements GroupsDao
{
	private DBUtil db = new DBUtil();
	private Connection conn = db.getConnection();
	private PreparedStatement ps;
	@Override
	public int addGroups(Groups group) {
		// TODO Auto-generated method stub
		String sql = "insert into groups values(?,?,?)";
		int i = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, group.getGid());
			ps.setString(2, group.getGname());
			ps.setString(3, group.getGdesc());
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

	public static void main(String[] args) {
		Groups group = new Groups();
		new GroupsDaoImpl().selectGroups(group);
	}
	@Override
	public Vector selectGroups(Groups group) {
		//if(group!=null)
		String gname = group.getGname();
		System.out.println(gname);
		StringBuffer sql = new StringBuffer("select * from groups");
		if(StringUtil.isNotEmpty(gname))
		sql.append(" where gname like '%"+gname+"%'");
		// TODO Auto-generated method stub
		//System.out.println(sql);
		Vector v =  new Vector();
		try {
			ps = conn.prepareStatement(sql.toString());
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Vector v1 = new Vector();
				v1.add(rs.getString("gid"));
				v1.add(rs.getString("gname"));
				v1.add(rs.getString("gdesc"));
				v.add(v1);
			}	
			//System.out.println(v);
			return v;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return v;
		}
		finally
		{
			if(conn!=null) db.close();
			return v;
		}
	}

	@Override
	public int updateGroups(Groups group) {
		// TODO Auto-generated method stub
		String sql = "update groups set gdesc = ? , gname = ? where gid = ?";
		int i = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(3, group.getGid());
			ps.setString(2, group.getGname());
			ps.setString(1, group.getGdesc());
			//System.out.println("meilai");
			i = ps.executeUpdate();
			//System.out.println("meilai");
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
	public int deleteGroups(Groups group) {
		// TODO Auto-generated method stub
		String sql = "delete from groups where gid = ?";
		int i = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, group.getGid());
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
}
