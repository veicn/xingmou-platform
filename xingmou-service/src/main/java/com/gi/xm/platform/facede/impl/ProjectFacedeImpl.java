
package com.gi.xm.platform.facede.impl;

import java.util.*;

import com.alibaba.dubbo.config.annotation.Service;
import com.gi.xm.platform.biz.DistrictBiz;
import com.gi.xm.platform.biz.IndustryBiz;
import com.gi.xm.platform.biz.RoundBiz;
import com.gi.xm.platform.facede.IndustryFacede;
import com.gi.xm.platform.facede.convertor.*;
import com.gi.xm.platform.pojo.District;
import com.gi.xm.platform.pojo.Industry;
import com.gi.xm.platform.pojo.Round;
import com.gi.xm.platform.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import com.gi.xm.platform.biz.ProjectBiz;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;


import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.Project;
import com.gi.xm.platform.query.ProjectQuery;


import com.gi.xm.platform.facede.ProjectFacede;

@Service
public class ProjectFacedeImpl implements ProjectFacede {

	@Autowired
	private ProjectBiz projectBiz;

	public MessageInfo<Integer> deleteProject(Long id){
		
		Message<Integer> message  = projectBiz.deleteProject(id);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Long> createProject(ProjectInfo projectInfo){
		
		Project project = ProjectConvertor.toProject(projectInfo);
		Message<Long> message  =  projectBiz.createProject( project );
		MessageInfo<Long> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateProject(ProjectInfo projectInfo){
		
		Project project = ProjectConvertor.toProject(projectInfo);
		Message<Integer> message  =  projectBiz.updateProject( project );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		public MessageInfo<Integer> changeStatus(
			Long id,
			Integer status,
			String operatorId){
			
		Message<Integer> message  = projectBiz.changeStatus(id,status,operatorId);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<ProjectInfo> getProject( Long id ){
		
		Message<Project> message  = projectBiz.getProject( id );
		MessageInfo<ProjectInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		ProjectInfo projectInfo = ProjectConvertor.toProjectInfo(message.getData());
		messageInfo.setData(projectInfo);
		return messageInfo;
	}

    public MessageInfo<List<ProjectInfo>> getAllProject(){
	
		Message<List<Project>> message  = projectBiz.getAllProject();
		MessageInfo<List<ProjectInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<ProjectInfo> projectInfoList = ProjectConvertor.toProjectInfoList(message.getData());
		messageInfo.setData(projectInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<ProjectInfo>> queryProject(ProjectQueryInfo projectQueryInfo) {
		ProjectQuery projectQuery = ProjectConvertor.toProjectQuery(projectQueryInfo);
		Message<QueryResult<Project>> message = projectBiz.queryProject(projectQuery);
		MessageInfo<QueryResultInfo<ProjectInfo>> messageInfo = new MessageInfo<QueryResultInfo<ProjectInfo>>();
		QueryResultInfo<ProjectInfo> queryResultInfo = ProjectConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}
   
		


	public MessageInfo<List<ProjectInfo>> getListBySourceId(Long sourceId){
	
		Message<List<Project>> message  = projectBiz.getListBySourceId(sourceId);
		MessageInfo<List<ProjectInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<ProjectInfo> projectInfoList = ProjectConvertor.toProjectInfoList(message.getData());
		messageInfo.setData(projectInfoList);
		return messageInfo;	
	}

    @Override
    public MessageInfo<QueryResultInfo<ProjectInfo>> searchProject(ProjectQueryInfo projectQueryInfo) {
        ProjectQuery projectQuery = ProjectConvertor.toProjectQuery(projectQueryInfo);
        Message<QueryResult<Project>> message = projectBiz.searchProject(projectQuery);
        MessageInfo<QueryResultInfo<ProjectInfo>> messageInfo = new MessageInfo<QueryResultInfo<ProjectInfo>>();
        QueryResultInfo<ProjectInfo> queryResultInfo = ProjectConvertor.toQueryResultInfo(message.getData());
        messageInfo.setData(queryResultInfo);
        return messageInfo;
    }

	@Override
	public MessageInfo<QueryResultInfo<ProjectInfo>> queryCompetationlist(ProjectQueryInfo projectQueryInfo) {
		ProjectQuery projectQuery = ProjectConvertor.toProjectQuery(projectQueryInfo);
		Message<QueryResult<Project>> message = projectBiz.queryCompetationlist(projectQuery);
		MessageInfo<QueryResultInfo<ProjectInfo>> messageInfo = new MessageInfo<QueryResultInfo<ProjectInfo>>();
		QueryResultInfo<ProjectInfo> queryResultInfo = ProjectConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}

}