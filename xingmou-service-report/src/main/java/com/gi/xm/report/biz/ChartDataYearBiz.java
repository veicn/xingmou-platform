

package com.gi.xm.report.biz;

import java.util.List;

import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.report.query.ChartDataYearQueryInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gi.xm.report.dao.ChartDataYearDAO;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.report.pojo.ChartDataYear;

@Service("chartDataYearBiz")
public class ChartDataYearBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(ChartDataYearBiz.class);

    @Autowired
	ChartDataYearDAO chartDataYearDAO;


			
	public MessageInfo<List<ChartDataYear>> getListByYaar(Integer[] years){

		MessageInfo<List<ChartDataYear>> messageInfo = new MessageInfo<List<ChartDataYear>>();
		try {
			List<ChartDataYear> chartDataYearList = chartDataYearDAO.selectByYaar(years);
			messageInfo.setData(chartDataYearList);
		} catch (Exception e) {
			LOGGER.error("getListByYaar","查询ChartDataYear失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
	public MessageInfo<QueryResultInfo<ChartDataYear>> queryChartDataYear(ChartDataYearQueryInfo chartDataYearQueryInfo) {
		MessageInfo<QueryResultInfo<ChartDataYear>> message = new MessageInfo<QueryResultInfo<ChartDataYear>>();
		try {
			QueryResultInfo<ChartDataYear> queryResult = new QueryResultInfo<ChartDataYear>();
			PageHelper.startPage(chartDataYearQueryInfo.getPageIndex(), chartDataYearQueryInfo.getPageSize());
			List<ChartDataYear> chartDataYearList = chartDataYearDAO.queryChartDataYear(chartDataYearQueryInfo);
			PageInfo<ChartDataYear> pageInfo = new PageInfo<ChartDataYear>(chartDataYearList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(chartDataYearList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryChartDataYear", "分页查询ChartDataYear失败", e);
			message.setStatus(10001);
		}
		return message;
	}


}