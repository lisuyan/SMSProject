package org.zjz.dao;
/**
 * 定义分组的增、删、改、查的数据库接口
 * @author liyan
 *
 */
import java.security.acl.Group;
import java.util.Vector;

import org.zjz.entity.Groups;

public interface GroupsDao {
	/**
	 *添加分组信息
	 * @param group
	 * @return
	 */
	public int addGroups(Groups group);
	 /**
	  * 查询分组信息
	  * @param group
	  * @return
	  */
	public Vector selectGroups(Groups group);
	/**
	 * 更新分组信息
	 * @param group
	 * @return
	 */
	public int updateGroups(Groups group);
	/**
	 * 删除分组信息
	 * @param group
	 * @return
	 */
	public int deleteGroups(Groups group);
	 
	
}
