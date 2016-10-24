package com.gi.xm.platform.view;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;
import java.sql.Timestamp;
import com.gi.xm.platform.view.common.QueryInfo;

public class DataQueryInfo extends QueryInfo {
	
	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

	
	private Integer id;
	
	private Integer projectNum;
	
	private Integer projectInvestedNum;
	
	private Long investedMoney;
	
	private Long investedMoneyPerProject;
	
	private Integer investfirmNum;
	
	private Integer eventNum;
	
	private Timestamp addTime;
	
	private Timestamp updateTime;
		
    
	public Integer getId(){
		return id;
	}
	
	public void setId(Integer id){
		this.id = id;
	}
    
	public Integer getProjectNum(){
		return projectNum;
	}
	
	public void setProjectNum(Integer projectNum){
		this.projectNum = projectNum;
	}
    
	public Integer getProjectInvestedNum(){
		return projectInvestedNum;
	}
	
	public void setProjectInvestedNum(Integer projectInvestedNum){
		this.projectInvestedNum = projectInvestedNum;
	}
    
	public Long getInvestedMoney(){
		return investedMoney;
	}
	
	public void setInvestedMoney(Long investedMoney){
		this.investedMoney = investedMoney;
	}
    
	public Long getInvestedMoneyPerProject(){
		return investedMoneyPerProject;
	}
	
	public void setInvestedMoneyPerProject(Long investedMoneyPerProject){
		this.investedMoneyPerProject = investedMoneyPerProject;
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

	public Integer getInvestfirmNum() {
		return investfirmNum;
	}

	public void setInvestfirmNum(Integer investfirmNum) {
		this.investfirmNum = investfirmNum;
	}

	public Integer getEventNum() {
		return eventNum;
	}

	public void setEventNum(Integer eventNum) {
		this.eventNum = eventNum;
	}
    }