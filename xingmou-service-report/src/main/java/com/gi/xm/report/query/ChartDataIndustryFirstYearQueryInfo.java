package com.gi.xm.report.query;

import com.gi.xm.platform.view.common.QueryInfo;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;
import java.sql.Timestamp;

public class ChartDataIndustryFirstYearQueryInfo extends QueryInfo {
	
	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

	
	private Long id;
	
	private Integer yaar;
	
	private Integer industryId;
	
	private String industryName;
	
	private Long marketMoney;
	
	private Integer marketMoneyRate;
	
	private Long marketUser;
	
	private Integer marketUserRate;
	
	private Long singleUserValue;
	
	private Long marketMoneyStock;
	
	private Integer projectNum;
	
	private Integer investedNum;
	
	private Integer investedNumRate;
	
	private Long investedMoney;
	
	private Integer investedMoneyRate;
	
	private Long investedPerMoney;
	
	private Long investedMedianMoney;
	
	private Long investedMaxMoney;
	

    private Long[] years;

    public Long[] getYears() {
        return years;
    }

    public void setYears(Long[] years) {
        this.years = years;
    }

    public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
    
	public Integer getYaar(){
		return yaar;
	}
	
	public void setYaar(Integer yaar){
		this.yaar = yaar;
	}
    
	public Integer getIndustryId(){
		return industryId;
	}
	
	public void setIndustryId(Integer industryId){
		this.industryId = industryId;
	}
    
	public String getIndustryName(){
		return industryName;
	}
	
	public void setIndustryName(String industryName){
		this.industryName = industryName;
	}
    
	public Long getMarketMoney(){
		return marketMoney;
	}
	
	public void setMarketMoney(Long marketMoney){
		this.marketMoney = marketMoney;
	}
    
	public Integer getMarketMoneyRate(){
		return marketMoneyRate;
	}
	
	public void setMarketMoneyRate(Integer marketMoneyRate){
		this.marketMoneyRate = marketMoneyRate;
	}
    
	public Long getMarketUser(){
		return marketUser;
	}
	
	public void setMarketUser(Long marketUser){
		this.marketUser = marketUser;
	}
    
	public Integer getMarketUserRate(){
		return marketUserRate;
	}
	
	public void setMarketUserRate(Integer marketUserRate){
		this.marketUserRate = marketUserRate;
	}
    
	public Long getSingleUserValue(){
		return singleUserValue;
	}
	
	public void setSingleUserValue(Long singleUserValue){
		this.singleUserValue = singleUserValue;
	}
    
	public Long getMarketMoneyStock(){
		return marketMoneyStock;
	}
	
	public void setMarketMoneyStock(Long marketMoneyStock){
		this.marketMoneyStock = marketMoneyStock;
	}
    
	public Integer getProjectNum(){
		return projectNum;
	}
	
	public void setProjectNum(Integer projectNum){
		this.projectNum = projectNum;
	}
    
	public Integer getInvestedNum(){
		return investedNum;
	}
	
	public void setInvestedNum(Integer investedNum){
		this.investedNum = investedNum;
	}
    
	public Integer getInvestedNumRate(){
		return investedNumRate;
	}
	
	public void setInvestedNumRate(Integer investedNumRate){
		this.investedNumRate = investedNumRate;
	}
    
	public Long getInvestedMoney(){
		return investedMoney;
	}
	
	public void setInvestedMoney(Long investedMoney){
		this.investedMoney = investedMoney;
	}
    
	public Integer getInvestedMoneyRate(){
		return investedMoneyRate;
	}
	
	public void setInvestedMoneyRate(Integer investedMoneyRate){
		this.investedMoneyRate = investedMoneyRate;
	}
    
	public Long getInvestedPerMoney(){
		return investedPerMoney;
	}
	
	public void setInvestedPerMoney(Long investedPerMoney){
		this.investedPerMoney = investedPerMoney;
	}
    
	public Long getInvestedMedianMoney(){
		return investedMedianMoney;
	}
	
	public void setInvestedMedianMoney(Long investedMedianMoney){
		this.investedMedianMoney = investedMedianMoney;
	}
    
	public Long getInvestedMaxMoney(){
		return investedMaxMoney;
	}
	
	public void setInvestedMaxMoney(Long investedMaxMoney){
		this.investedMaxMoney = investedMaxMoney;
	}
    
    }