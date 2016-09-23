package com.gi.xm.platform.query;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class ProjectPersonQuery extends Query {
	
	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;
	
			
	private Integer id;
			
	private Long projectId;
			
	private String name;
			
	private String icon;
	
	private String postionName;
			
	public String getPostionName() {
		return postionName;
	}
	public void setPositionName(String postionName) {
		this.postionName = postionName;
	}
	private Integer isCoreMember;
			
	private Timestamp addTime;
			
	private Timestamp updateTime;
		
    
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
    
	public Long getProjectId(){
		return projectId;
	}
	public void setProjectId(Long projectId){
		this.projectId = projectId;
	}
    
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
    
	public String getIcon(){
		return icon;
	}
	public void setIcon(String icon){
		this.icon = icon;
	}
    
	public Integer getIsCoreMember(){
		return isCoreMember;
	}
	public void setIsCoreMember(Integer isCoreMember){
		this.isCoreMember = isCoreMember;
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