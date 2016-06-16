package org.zjz.bussiness.impl;
/**
 * 操作成绩信息的业务实现类
 * @author liyan
 */
import java.util.Vector;

import org.zjz.bussiness.ScoreAction;
import org.zjz.dao.impl.ScheduleDaoImpl;
import org.zjz.dao.impl.ScoreDaoImpl;
import org.zjz.dao.impl.StuDaoImpl;
import org.zjz.entity.Student;

public class ScoreActionImpl implements ScoreAction{

	@Override
	public boolean addScore(int sid,int cid,int grade) {
		// TODO Auto-generated method stub
		int i = new ScoreDaoImpl().addScore(sid, cid, grade);
		if(i == 0) return false;
		else return true;
	}

	@Override
	public Vector selectScore(Student stu) {
		// TODO Auto-generated method stub
		return new ScoreDaoImpl().selectScore(stu);
	}

	@Override
	public boolean deleteScore(Student stu) {
		// TODO Auto-generated method stub
		int i = new ScoreDaoImpl().deleteScore(stu);
		if(i == 0) return false;
		else return true;
	}

	@Override
	public boolean updateScore(Student stu) {
		// TODO Auto-generated method stub
		int i = new ScoreDaoImpl().updateScore(stu);
		if(i == 0) return false;
		else return true;
	}
}
