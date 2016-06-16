package org.zjz.bussiness;
/**
 * 操作课程信息的业务接口
 * @author liyan
 */
import java.util.Vector;

import org.zjz.entity.Schedule;

public interface ScheduleAction {
	/**
	 * 查询课程信息
	 * @param sche
	 * @return
	 */
	public Vector selectSchedule(Schedule sche);
	/**
	 * 增加课程信息
	 * @param sche
	 * @return
	 */
	public boolean addSchedule(Schedule sche);
	/**
	 * 删除课程信息
	 * @param sche
	 * @return
	 */
	public boolean deleteSchedule(Schedule sche); 
	/**
	 * 更新课程信息
	 * @param sche
	 * @return
	 */
	public boolean updateSchedule(Schedule sche);
}
