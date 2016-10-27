package com.gi.xm.doc.restful.controller;


import com.gi.xm.doc.biz.IndustryReportsBiz;
import com.gi.xm.doc.pojo.IndustryReportsInfo;
import com.gi.xm.doc.query.IndustryReportsQueryInfo;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("share")
public class IndustryReportsController {

    @Autowired
	private IndustryReportsBiz industryReportsBiz;


	@RequestMapping("query")
	@ResponseBody
	public MessageInfo<QueryResultInfo<IndustryReportsInfo>>  queryIndustryReports (@RequestBody IndustryReportsQueryInfo industryReportsQueryInfo) {
		MessageInfo<QueryResultInfo<IndustryReportsInfo>> resultMessageInfo = industryReportsBiz.queryIndustryReports(industryReportsQueryInfo);
		if (resultMessageInfo != null && resultMessageInfo.getData()!= null && !resultMessageInfo.getData().getRecords().isEmpty()){
			for (IndustryReportsInfo industryReportsInfo:resultMessageInfo.getData().getRecords()){
					Integer sourceType = industryReportsInfo.getSourceType();
					if ( sourceType != null && sourceType == 1){
						industryReportsInfo.setSource("艾瑞网");
						industryReportsInfo.setIcon("");
					}else if ( sourceType != null && sourceType == 2){
						industryReportsInfo.setSource("易观");
					}

			}
		}
		return resultMessageInfo;
	}

    @RequestMapping("get/{id}")
    @ResponseBody
	public MessageInfo<IndustryReportsInfo> getIndustryReports(@PathVariable("id") Integer id ){
		MessageInfo<IndustryReportsInfo> messageInfo =  industryReportsBiz.getIndustryReports(id);
		return messageInfo;
	}

}
