package com.gi.ctdn.dao;

import java.util.List;

import com.gi.ctdn.pojo.EventInfoList;
import org.apache.ibatis.annotations.Param;

import com.gi.ctdn.pojo.EventInfo;

public interface EventInfoDAO {
	
			
	List<EventInfo> selectBySourceCode(@Param("sourceCode") String sourceCode);
				
	EventInfoList selectByEventId(@Param("eventId") Integer eventId);

	List<EventInfo> selectByName(@Param("company") String name);

	List<EventInfo> selectByInvestDate();

	List<EventInfo> selectFromCtdn(@Param("pageSize") Integer pageSize);

	List<EventInfo> selectFromCtdn(EventInfo info);

	Integer selectEventCount();

}