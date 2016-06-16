package org.zjz.entity;
/**
 * 创建一个课程的实体类
 * @author liyan
 *
 */
public class Schedule {
	private int cid;
	private String cname;
	/**
	 * 
	 * @return the cno
	 */
	public int getCno() {
		return cid;
	}
	/**
	 * 
	 * @param cno the cno to set
	 */
	public void setCno(int cno) {
		this.cid = cno;
	}
	/**
	 * 
	 * @return the cname
	 */
	public String getCname() {
		return cname;
	}
	/**
	 * 
	 * @param cname the cname to set
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}
}
