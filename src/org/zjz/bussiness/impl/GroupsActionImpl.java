package org.zjz.bussiness.impl;
/**
 * 操作组信息的业务实现类
 * @author liyan
 */
import java.security.acl.Group;
import java.util.Vector;

import org.zjz.bussiness.GroupsAction;
import org.zjz.dao.impl.GroupsDaoImpl;
import org.zjz.entity.Groups;

public class GroupsActionImpl implements GroupsAction{
	@Override
	public boolean addGroups(Groups group) {
		// TODO Auto-generated method stub
		int i = new GroupsDaoImpl().addGroups(group);
		if(i == 0)return false;
		return true;
	}
	
	@Override
	public Vector selectGroups(Groups group) {
		 return new GroupsDaoImpl().selectGroups(group);
	}
	
	public boolean updateGroups(Groups group)
	{
		int i = new GroupsDaoImpl().updateGroups(group);
		if(i == 0) return false;
		else return true;
	}
	
	public boolean deleteGroups(Groups group)
	{
		int i = new GroupsDaoImpl().deleteGroups(group);
		if(i == 0) return false;
		else return true;
	}
}
