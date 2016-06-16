package org.zjz.dao;
/**
 * 操作学生信息的数据库接口
 * @author liyan
 */
import java.util.Vector;

import org.zjz.entity.Student;

public interface StuDao {
	/**
	 * 添加学生信息
	 * @param stu
	 * @return
	 */
	public int addStu(Student stu);
	/**
	 * 查询学生信息
	 * @param stu
	 * @return
	 */
	public Vector selectStu(Student stu);
	/**
	 * 更新学生信息
	 * @param stu
	 * @return
	 */
	public int updateStu(Student stu);
	/**
	 * 删除学生信息
	 * @param stu
	 * @return
	 */
	public int deleteStu(Student stu);
}
