package com.gi.ctdn.pojo;

import com.gi.ctdn.view.common.Query;

public class OrgMediaInfo extends Query {

        public static final String INVESTORG = "投资机构";
        public static final String ORGID = "机构ID";
        public static final String CODE = "投资机构code";
        public static final String TITLE = "标题";
        public static final String EVENTDATE = "日期[H、N、L:必须]";
        public static final String SOURCE = "来源[N、L:必须，H：为空]";
        public static final String CONTENT = "内容";
        public static final String LINK = "排名[L]";
        public static final String TYPE = "类型[H:历史，N：相关新闻，L：榜单]";


	/**
	 * @Fields investOrg : 投资机构
	 */
	private String investOrg;

	/**
	 * @Fields orgId : 机构ID
	 */
	private Integer orgId;

	/**
	 * @Fields code : 投资机构code
	 */
	private String code;

	/**
	 * @Fields title : 标题
	 */
	private String title;

	/**
	 * @Fields eventDate : 日期[H、N、L:必须]
	 */
	private String eventDate;

	/**
	 * @Fields source : 来源[N、L:必须，H：为空]
	 */
	private String source;

	/**
	 * @Fields content : 内容
	 */
	private String content;

	/**
	 * @Fields rank : 排名[L]
	 */
	private String link;

	/**
	 * @Fields type : 类型[H:历史，N：相关新闻，L：榜单]
	 */
	private String type;


	public String getInvestOrg(){
		return investOrg;
	}

	public void setInvestOrg(String investOrg){
		this.investOrg = investOrg;
	}

	public Integer getOrgId(){
		return orgId;
	}

	public void setOrgId(Integer orgId){
		this.orgId = orgId;
	}

	public String getCode(){
		return code;
	}

	public void setCode(String code){
		this.code = code;
	}

	public String getTitle(){
		return title;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getEventDate(){
		return eventDate;
	}

	public void setEventDate(String eventDate){
		this.eventDate = eventDate;
	}

	public String getSource(){
		return source;
	}

	public void setSource(String source){
		this.source = source;
	}

	public String getContent(){
		return content;
	}

	public void setContent(String content){
		this.content = content;
	}

	public String getLink(){
		return link;
	}

	public void setLink(String link){
		this.link = link;
	}

	public String getType(){
		return type;
	}

	public void setType(String type){
		this.type = type;
	}
    }