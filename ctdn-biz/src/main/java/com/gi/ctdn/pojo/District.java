package com.gi.ctdn.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;
import com.gi.xm.platform.view.common.PojoInfo;

public class District extends PojoInfo {

        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String DISTRICTLEVEL = "districtLevel";
        public static final String PARENTID = "parentId";
        public static final String DISTRICTTYPE = "districtType";
        public static final String VAL = "val";
    
	
	/**
	 * @Fields id : 
	 */
	private Integer id;
	
	/**
	 * @Fields name : 
	 */
	private String name;
	
	/**
	 * @Fields districtLevel : 
	 */
	private Integer districtLevel;
	
	/**
	 * @Fields parentId : 
	 */
	private Integer parentId;
	
	/**
	 * @Fields districtType : 
	 */
	private Integer districtType;
	
	/**
	 * @Fields val : 
	 */
	private Integer val;
	
    
	public Integer getId(){
		return id;
	}

	public void setId(Integer id){
		this.id = id;
	}
    
	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}
    
	public Integer getDistrictLevel(){
		return districtLevel;
	}

	public void setDistrictLevel(Integer districtLevel){
		this.districtLevel = districtLevel;
	}
    
	public Integer getParentId(){
		return parentId;
	}

	public void setParentId(Integer parentId){
		this.parentId = parentId;
	}
    
	public Integer getDistrictType(){
		return districtType;
	}

	public void setDistrictType(Integer districtType){
		this.districtType = districtType;
	}
    
	public Integer getVal(){
		return val;
	}

	public void setVal(Integer val){
		this.val = val;
	}
    }