package org.zjz.bussiness;
/**
 * 操作成绩信息的业务接口
 * @author liyan
 */
import java.util.Vector;

import org.zjz.entity.Student;

public interface ScoreAction {
	/**
	 * 添加学生成绩
	 * @param stu
	 * @return 
	 */
	public boolean addScore(int sid,int cid,int grade);
	/**
	 * 查询学生成绩
	 * @param stu
	 */
	public Vector selectScore(Student stu);
	/**
	 * 删除学生成绩
	 * @param stu
	 */
	public boolean deleteScore(Student stu);
	/**
	 * 更新学生成绩
	 * @param stu
	 */
	public boolean updateScore(Student stu);
}
