package org.zjz.entity;
/**
 * 创建学生实体类
 * @author liyan
 *
 */
public class Student {
	private int sid;
	private String sname;
	private String ssex;
	private int sage;
	private int gid;
	 
	public Student(String sname2, int gid2) {
		// TODO Auto-generated constructor stu
		super();
		this.sname = sname2;
		this.gid = gid2;
	}

	public Student(String sname, String ssex, int gid) {
		super();
		this.sname = sname;
		this.ssex = ssex;
		this.gid = gid;
	}
	
	public Student(int sid, String name, String sex,int age,int gid) {
		// TODO Auto-generated constructor stub
		super();
		this.sid = sid;
		this.sname = name;
		this.ssex = sex;
		this.sage = age;
		this.gid = gid;
	}
	public Student() {
		// TODO Auto-generated constructor stub
		super();
	}

	public Student(int parseInt, String sname2, int parseInt2) {
		// TODO Auto-generated constructor stub
		this.sid = sid;
		this.sname = sname;
		this.sage = sage;
	}

	public Student(int parseInt, String name, String ssex2, int parseInt2, String string) {
		// TODO Auto-generated constructor stub
		this.sid = parseInt;
		this.sname = name;
		this.ssex = ssex2;
		this.sage = parseInt2;
		this.gid = gid;
	}
	/**
	 * 
	 * @return the sid
	 */
	public int getSid() {
		return sid;
	}
	/**
	 * 
	 * @param sid the sid to set
	 */
	public void setSid(int sid) {
		this.sid = sid;
	}
	/**
	 * 
	 * @return the aname
	 */
	public String getSname() {
		return sname;
	}
	/**
	 * 
	 * @param sname the sname to set
	 */
	public void setSname(String sname) {
		this.sname = sname;
	}
	 
	/**
	 * 
	 * @return the ssex
	 */
	public String getSsex() {
		return ssex;
	}
	/**
	 * 
	 * @param ssex the ssex to set
	 */
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	/**
	 * 
	 * @return the sage
	 */
	public int  getSage() {
		return sage;
	}
	/**
	 * 
	 * @param sage the asge to set
	 */
	public void setSage(int sage) {
		this.sage = sage;
	}
	/**
	 * 
	 * @return gid
	 */
	public int getGid() {
		return gid;
	}
	/**
	 * 
	 * @param gid the gid to set
	 */
	public void setGid(int gid) {
		this.gid = gid;
	}	
}
