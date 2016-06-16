package org.zjz.bussiness.impl;
/**
 * 操作学生信息的业务实现类
 * @author liyan
 */
import java.util.Vector;

import org.zjz.bussiness.StuAction;
import org.zjz.dao.impl.GroupsDaoImpl;
import org.zjz.dao.impl.StuDaoImpl;
import org.zjz.entity.Student;

public class StuActionImpl implements StuAction{

	public boolean addStu(Student stu) {
		// TODO Auto-generated method stub
		int i = new StuDaoImpl().addStu(stu);
		if(i == 0) return false;
		else return true;
	}

	@Override
	public boolean updateStu(Student stu) {
		int i = new StuDaoImpl().updateStu(stu);
		if(i == 0) return false;
		else return true;
	}

	@Override
	public boolean deleteStu(Student stu) {
		int i = new StuDaoImpl().deleteStu(stu);
		if(i == 0) return false;
		else return true;
	}

	@Override
	public Vector selectStu(Student stu) {
		// TODO Auto-generated method stub
		 return new StuDaoImpl().selectStu(stu);
	}
}
