package org.zjz.dao;
/**
 * 操作管理员信息的数据库接口
 * @author liyan
 */
import org.zjz.entity.Admin;

public interface AdminDao {
	/**
	 * 通过用户名和密码查询数据库的数据，并返回一条记录
	 * @param admin
	 * @return
	 */
	public Admin selectByNameAndPwd(Admin admin);
}
