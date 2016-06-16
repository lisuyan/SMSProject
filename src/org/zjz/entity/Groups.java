package org.zjz.entity;
/**
 * 创建组的实体类
 * @author liyan
 *
 */
public class Groups {
	private int gid;
	private String gname;
	private String gdesc;
	
	public Groups(){}
	
	public Groups(int gid, String gname, String gdesc) 
	{
		// TODO Auto-generated constructor stub
		super();
		this.gid = gid;
		this.gname = gname;
		this.gdesc = gdesc;
	}

	
	public int getGid()
	{
		return gid;
	}
	public int setGid(int gid)
	{
		return this.gid = gid;
	}
	
	public String getGname()
	{
		return gname;
	}
	public void setGname(String gname)
	{
		this.gname = gname;
	}
	
	public String getGdesc()
	{
		return gdesc;
	}
	public void setGdesc()
	{
		this.gdesc = gdesc;
	}

	public String toString() {
		return gname;
	}
	
}