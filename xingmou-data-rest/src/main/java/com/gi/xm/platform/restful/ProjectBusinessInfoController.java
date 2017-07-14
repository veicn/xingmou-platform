package com.gi.xm.platform.restful;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.gi.ctdn.ods.biz.ProjectBusinessInfoBiz;
import com.gi.ctdn.ods.pojo.ProjectBusinessInfo;
import com.gi.xm.platform.mongodb.common.QueryResult;
import com.gi.xm.platform.view.common.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("projectBusinessInfo")
public class ProjectBusinessInfoController {

    @Autowired
	private ProjectBusinessInfoBiz projectBusinessInfoBiz;


    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<ProjectBusinessInfo>> getAllProjectBusinessInfo(){
		MessageInfo<List<ProjectBusinessInfo>>  messageInfo = projectBusinessInfoBiz.getAllProjectBusinessInfo();
		return messageInfo;
	}


		
    @RequestMapping("getListBySourceCode")
    @ResponseBody
	public MessageInfo<List<ProjectBusinessInfo>> getListBySourceCode(String sourceCode){
		MessageInfo<List<ProjectBusinessInfo>> messageInfo = projectBusinessInfoBiz.getListBySourceCode(sourceCode);
		return messageInfo;
	}
		
}
