package org.zjz.bussiness;
/**
 * 操作学生信息的业务接口
 * @author liyan
 */
import java.util.Vector;

import org.zjz.entity.Student;

public interface StuAction {
	/**
	 * 插入学生信息
	 * @param stu
	 * @return
	 */
	public boolean addStu(Student stu);
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
	public boolean updateStu(Student stu);
	/**
	 * 删除学生信息
	 * @param stu
	 * @return
	 */
	public boolean deleteStu(Student stu);
}
