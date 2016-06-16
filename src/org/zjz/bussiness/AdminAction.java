package org.zjz.bussiness;
/**
 * 操作管理员信息的业务接口
 * @author liyan
 */
import org.zjz.entity.Admin;

public interface AdminAction 
{
	public boolean checkUser(Admin admin);
}
