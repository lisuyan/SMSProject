package org.zjz.dao;
/**
 * 操作成绩信息的数据库接口
 * @author liyan
 */
import java.util.Vector;

import org.zjz.entity.Schedule;
import org.zjz.entity.Student;

public interface ScoreDao {
	/**
	 * 添加分数信息
	 * @param sche
	 * @return
	 */
	public int addScore(int sid,int cid,int grade);
	/**
	 * 查询分数信息
	 * @param sche
	 * @return
	 */
	public Vector selectScore(Student stu);
	/**
	 * 更新分数信息
	 * @param sche
	 * @return
	 */
	public int updateScore(Student stu);
	/**
	 * 删除分数信息
	 * @param sche
	 * @return
	 */
	public int deleteScore(Student stu);
}
