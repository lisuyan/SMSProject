package org.zjz.entity;
/**
 * 创建Admin的实体类
 * @author liyan
 *
 */
public class Admin {
	private String aname;
	private String apsw;
	private int aid;
	public Admin(String name, String psw) {
		// TODO Auto-generated constructor stub
		this.aname = name;
		this.apsw = psw;
	}
	/**
	 * 
	 * @return the aname
	 */
	
	public String getAname() {
		return aname;
	}
	/**
	 * 
	 * @param aname the aname to set
	 */
	public void setAname(String aname) {
		this.aname = aname;
	}
	/**
	 * 
	 * @return the apsw
	 */
	public String getApsw() {
		return apsw;
	}
	/**
	 * 
	 * @param apsw the apsw to set
	 */
	public void setApsw(String apsw) {
		this.apsw = apsw;
	}
	/**
	 * 
	 * @return the aid
	 */
	public int getAid() {
		return aid;
	}
	/**
	 * 
	 * @param aid the aid to set
	 */
	public void setAid(int aid) {
		this.aid = aid;
	}
	
}
