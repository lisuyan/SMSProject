package org.zjz.bussiness;
/**
 * 操作组信息的业务接口
 * @author liyan
 */
import java.util.Vector;

import org.zjz.entity.Groups;

public interface GroupsAction {
	/**
	 * 添加组的信息
	 * @param group
	 * @return
	 */
	public boolean addGroups(Groups group);
	/**
	 * 查询分组信息
	 * @param group
	 * @return
	 */
	public Vector selectGroups(Groups group);
}
