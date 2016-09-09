package com.gi.xm.platform.query;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class InvestfirmRoundQuery extends Query {
	
	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;
	
			
	private Long id;
			
	private Integer investfrimId;
			
	private Integer roundId;
			
	private Timestamp addTime;
			
	private Timestamp updateTime;
		
    
	public Long getId(){
		return id;
	}
	public void setId(Long id){
		this.id = id;
	}
    
	public Integer getInvestfrimId(){
		return investfrimId;
	}
	public void setInvestfrimId(Integer investfrimId){
		this.investfrimId = investfrimId;
	}
    
	public Integer getRoundId(){
		return roundId;
	}
	public void setRoundId(Integer roundId){
		this.roundId = roundId;
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