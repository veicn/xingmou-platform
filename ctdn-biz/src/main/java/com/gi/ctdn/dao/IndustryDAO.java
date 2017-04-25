package com.gi.ctdn.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.ctdn.pojo.Industry;

public interface IndustryDAO {
	
	
	List<Industry> selectAll();

	List<Industry> selectFirstIndustry();

	List<Industry> selectNextIndustry(@Param("industryId") Integer industryId);
}