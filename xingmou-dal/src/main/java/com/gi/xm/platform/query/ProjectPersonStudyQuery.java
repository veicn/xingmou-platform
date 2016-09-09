package com.gi.xm.platform.query;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class ProjectPersonStudyQuery extends Query {
	
	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;
	
			
	private Long id;
			
	private Long personId;
			
	private String schoolName;
			
	private String startDate;
			
	private String endDate;
			
	private String majorName;
			
	private String educationName;
			
	private Timestamp addTime;
			
	private Timestamp updateTime;
		
    
	public Long getId(){
		return id;
	}
	public void setId(Long id){
		this.id = id;
	}
    
	public Long getPersonId(){
		return personId;
	}
	public void setPersonId(Long personId){
		this.personId = personId;
	}
    
	public String getSchoolName(){
		return schoolName;
	}
	public void setSchoolName(String schoolName){
		this.schoolName = schoolName;
	}
    
	public String getStartDate(){
		return startDate;
	}
	public void setStartDate(String startDate){
		this.startDate = startDate;
	}
    
	public String getEndDate(){
		return endDate;
	}
	public void setEndDate(String endDate){
		this.endDate = endDate;
	}
    
	public String getMajorName(){
		return majorName;
	}
	public void setMajorName(String majorName){
		this.majorName = majorName;
	}
    
	public String getEducationName(){
		return educationName;
	}
	public void setEducationName(String educationName){
		this.educationName = educationName;
	}
    
	public Timestamp getAddTime(){
		return addTime;
	}
	public void setAddTime(Timestamp addTime){
		this.addTime = addTime;
	}
    
	public Timestamp getUpdateTime(){
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime){
		this.updateTime = updateTime;
	}
    }