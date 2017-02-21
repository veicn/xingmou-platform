package com.gi.ctdn.restful.controller;

import com.gi.ctdn.query.TeamMemberJobQueryInfo;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.ctdn.biz.TeamMemberJobBiz;
import com.gi.ctdn.pojo.TeamMemberJobInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * Created by zcy on 17-2-20.
 */
@RequestMapping("teamJob")
public class TeamJobController {

    @Autowired
    private TeamMemberJobBiz teamMemberJobBiz;

    /**
     * 添加团队成员工作经历
     * @param teamMemberJobInfo
     * @return
     */
    @RequestMapping("createTeamJob")
    @ResponseBody
    public MessageInfo<Long> createTeamJob (@RequestBody TeamMemberJobInfo teamMemberJobInfo){
        MessageInfo<Long> messageInfo = new MessageInfo<>();
        if(teamMemberJobInfo.getMemberId()== null){
            messageInfo.setStatus(10001);
            messageInfo.setMessage("teammember id 缺失！");
            return messageInfo;
        }
        if(teamMemberJobInfo.getCompanyName()==null ||teamMemberJobInfo.getPosition() == null||
                 teamMemberJobInfo.getStartDate() ==null|| teamMemberJobInfo.getEndDate() == null ){
            messageInfo.setMessage("必填项未填写完整!");
            messageInfo.setStatus(10001);
            return messageInfo;
        }
        if(teamMemberJobInfo.getDescrip() !=null && teamMemberJobInfo.getDescrip().length()>150){
            messageInfo.setMessage("详情描述超出限制长度!");
            messageInfo.setStatus(10001);
            return messageInfo;
        }

        teamMemberJobInfo.setAddTime(new Date());
        messageInfo = teamMemberJobBiz.createTeamMemberJob(teamMemberJobInfo);
        return messageInfo;
    }

    /**
     * 修改团队成员工作经历
     * @param teamMemberJobInfo
     * @return
     */
    @RequestMapping("updateTeamJob")
    @ResponseBody
    public MessageInfo<Long> updateTeamStudy (@RequestBody TeamMemberJobInfo teamMemberJobInfo){
        MessageInfo<Long> messageInfo = new MessageInfo<>();
        if(teamMemberJobInfo.getId() ==null){
            messageInfo.setStatus(10001);
            messageInfo.setMessage("id缺失！");
            return messageInfo;
        }
        if(teamMemberJobInfo.getCompanyName()==null ||teamMemberJobInfo.getPosition() == null||
                teamMemberJobInfo.getStartDate() ==null|| teamMemberJobInfo.getEndDate() == null ){
            messageInfo.setMessage("必填项未填写完整!");
            messageInfo.setStatus(10001);
            return messageInfo;
        }
        if(teamMemberJobInfo.getDescrip() !=null && teamMemberJobInfo.getDescrip().length()>150){
            messageInfo.setMessage("详情描述超出限制长度!");
            messageInfo.setStatus(10001);
            return messageInfo;
        }
        teamMemberJobInfo.setUpdateTime(new Date());
        messageInfo = teamMemberJobBiz.updateTeamMemberJob(teamMemberJobInfo);
        return messageInfo;
    }

    /**
     * 查询成员工作经历列表
     * @param memberId　团队成员id
     * @return
     */
    @RequestMapping("queryList")
    @ResponseBody
    public MessageInfo<List<TeamMemberJobInfo>> query(Long memberId){
        MessageInfo<List<TeamMemberJobInfo>> messageInfo = new MessageInfo<List<TeamMemberJobInfo>>();
        if(memberId == null){
            messageInfo.setStatus(10001);
            messageInfo.setMessage("memberId 缺失！");
            return messageInfo;
        }
        messageInfo = teamMemberJobBiz.queryByMemberId(memberId);
        return  messageInfo;
    }

    /**
     * 根据id删除团队成员
     * @param id
     * @return
     */
    @RequestMapping("deleteMemberJob")
    @ResponseBody
    public MessageInfo deleteMember(Long id){
        MessageInfo messageInfo = new MessageInfo();
        if(id == null){
            messageInfo.setStatus(10001);
            messageInfo.setMessage("job id 缺失！");
            return messageInfo;
        }
        TeamMemberJobQueryInfo job = new TeamMemberJobQueryInfo();
        job.setId(id);
        messageInfo = teamMemberJobBiz.deleteMemberJob(job);
        return  messageInfo;
    }
}
