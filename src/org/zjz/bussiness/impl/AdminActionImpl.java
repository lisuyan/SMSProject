package org.zjz.bussiness.impl;
/**
 * 操作管理员信息的业务实现类
 * @author liyan
 */
import org.zjz.bussiness.AdminAction;
import org.zjz.dao.impl.AdminDaoImpl;
import org.zjz.entity.Admin;

public class AdminActionImpl implements AdminAction{
	@Override
	public boolean checkUser(Admin admin) {
		// TODO Auto-generated method stub
		Admin a = new AdminDaoImpl().selectByNameAndPwd(admin);
		if(a == null) return false;
		return true;
	}
}
