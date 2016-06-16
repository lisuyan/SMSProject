package org.zjz.dao;
/**
 * 操作课程信息的数据库接口
 * @author liyan
 */
import java.util.Vector;

import org.zjz.entity.Schedule;

public interface ScheduleDao {
	/**
	 * 添加课程信息
	 * @param sche
	 * @return
	 */
	public int addSchedule(Schedule sche);
	/**
	 * 查询课程信息
	 * @param sche
	 * @return
	 */
	public Vector selectSchedule(Schedule sche);
	/**
	 * 更新课程信息
	 * @param sche
	 * @return
	 */
	public int updateSchedule(Schedule sche);
	/**
	 * 删除课程信息
	 * @param sche
	 * @return
	 */
	public int deleteSchedule(Schedule sche);
}
