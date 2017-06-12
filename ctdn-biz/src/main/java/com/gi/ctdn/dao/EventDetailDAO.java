package com.gi.ctdn.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.ctdn.pojo.EventDetail;

public interface EventDetailDAO {
	
			
	List<EventDetail> selectByEventId(@Param("eventId") Integer eventId);

	List<EventDetail> selectByProjTitle(@Param("projTitle") String projTitle);
		
	List<EventDetail> selectAll();
}