package com.gi.ctdn.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;

import com.gi.ctdn.pojo.ProjectListInfo;
import org.apache.ibatis.annotations.Param;

import com.gi.ctdn.pojo.ProjectList;

public interface ProjectListDAO {

	ProjectListInfo selectByCode(@Param("code") String code);

	List<ProjectList> selectListByCode(@Param("compCode") String code);

	List<ProjectList> selectCompetitiveSimilar(@Param("sourceCode") String sourceCode);

	List<ProjectList> selectByFinanceDate();

	List<ProjectList> selectListByCodes(@Param("codes") List<String> codes);

	List<ProjectList> selectByLoadDate(@Param("industryIds") List<Integer> industryIds);
	
	List<ProjectList> selectByLatestFinanceDate( @Param("industryIds")List<Integer> industryIds);
		
}