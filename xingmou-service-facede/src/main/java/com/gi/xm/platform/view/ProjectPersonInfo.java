package com.gi.xm.platform.view;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class ProjectPersonInfo implements Serializable {

	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

			
	/**
	 * @Fields id : 
	 */
	private Integer id;
			
	/**
	 * @Fields projectId : 项目id
	 */
	private Long projectId;
			
	/**
	 * @Fields name : 姓名
	 */
	private String name;
	
	/**
	 * @Fields name : 职位
	 */
	private String postionName;
			
	public String getPostionName() {
		return postionName;
	}

	public void setPostionName(String postionName) {
		this.postionName = postionName;
	}

	/**
	 * @Fields icon : 头像
	 */
	private String icon;
			
	/**
	 * @Fields isCoreMember : 1核心成员 0非核心成员
	 */
	private Integer isCoreMember;
			
	/**
	 * 成员工作经历
	 * @return
	 */
	private List<ProjectPersonJobInfo> jobList;
	/**
	 * 成员学习经历
	 * @return
	 */
	private List<ProjectPersonStudyInfo> studyList;
	/**
	 * 标签列表
	 * @return
	 */
	private List<LabelInfo> labelList;
	
	public List<ProjectPersonJobInfo> getJobList() {
		return jobList;
	}

	public void setJobList(List<ProjectPersonJobInfo> jobList) {
		this.jobList = jobList;
	}

	public List<ProjectPersonStudyInfo> getStudyList() {
		return studyList;
	}

	public void setStudyList(List<ProjectPersonStudyInfo> studyList) {
		this.studyList = studyList;
	}

	public List<LabelInfo> getLabelList() {
		return labelList;
	}

	public void setLabelList(List<LabelInfo> labelList) {
		this.labelList = labelList;
	}

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
    
}