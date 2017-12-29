package com.gi.ctdn.dao;

import com.gi.ctdn.pojo.Industry;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IndustryDAO {
	
	
	List<Industry> selectAll();

	List<Industry> selectindustrysByStatus(@Param("status") int status);

	List<Industry> selectOrgindustrystatus();
	
	List<Industry> selectParentindustrys();

	List<Industry> getIndustryByIds(@Param("industryIds")List<Integer> industrtIds);
}