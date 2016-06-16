package org.zjz.bussiness.impl;
/**
 * 操作课程信息的业务实现类
 * @author liyan
 */
import java.util.Vector;

import org.zjz.bussiness.ScheduleAction;
import org.zjz.dao.ScheduleDao;
import org.zjz.dao.impl.ScheduleDaoImpl;
import org.zjz.dao.impl.StuDaoImpl;
import org.zjz.entity.Schedule;

public class ScheduleActionImpl implements ScheduleAction{
	@Override
	public boolean addSchedule(Schedule sche) {
		// TODO Auto-generated method stub
		//此处应该运用多态，这样比较合理，符合标准规范
		ScheduleDao scheDao = new ScheduleDaoImpl();
		int i = scheDao.addSchedule(sche);
		//int i = new ScheduleDaoImpl().addSchedule(sche);
		if(i == 0) return false;
		else return true;
	}
	
	@Override
	public Vector selectSchedule(Schedule sche) {
		// TODO Auto-generated method stub
		 return new ScheduleDaoImpl().selectSchedule(sche);
	}

	@Override
	public boolean updateSchedule(Schedule sche) {
		// TODO Auto-generated method stub
		int i = new ScheduleDaoImpl().updateSchedule(sche);
		if(i == 0) return false;
		else return true;
	}
	
	@Override
	public boolean deleteSchedule(Schedule sche) {
		// TODO Auto-generated method stub
		int i = new ScheduleDaoImpl().deleteSchedule(sche);
		if(i == 0) return false;
		else return true;
	}
}
