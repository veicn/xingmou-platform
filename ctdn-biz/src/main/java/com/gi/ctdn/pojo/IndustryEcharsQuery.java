package com.gi.ctdn.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by zcy on 18-1-13.
 */
@ApiModel
public class IndustryEcharsQuery {

    @ApiModelProperty("行业id")
    private  Integer industryId;

    @ApiModelProperty("时间类型")
    private  String timeType;

    @ApiModelProperty("地区id")
    private  Integer districtSubId;

    @ApiModelProperty("轮次 id")
    private  Integer industryRoundId;

    @ApiModelProperty("天/月/年数")
    private Integer time;

    @ApiModelProperty("是否进入下一轮:持续获投分析查询使用")
    private Integer isHasNextEvent;

    @ApiModelProperty("季度筛选")
    private String investQuarter;

    public Integer getIndustryId() {
        return industryId;
    }

    public void setIndustryId(Integer industryId) {
        this.industryId = industryId;
    }

    public String getTimeType() {
        return timeType;
    }

    public void setTimeType(String timeType) {
        this.timeType = timeType;
    }

    public Integer getDistrictSubId() {
        return districtSubId;
    }

    public void setDistrictSubId(Integer districtSubId) {
        this.districtSubId = districtSubId;
    }

    public Integer getIndustryRoundId() {
        return industryRoundId;
    }

    public void setIndustryRoundId(Integer industryRoundId) {
        this.industryRoundId = industryRoundId;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getIsHasNextEvent() {
        return isHasNextEvent;
    }

    public void setIsHasNextEvent(Integer isHasNextEvent) {
        this.isHasNextEvent = isHasNextEvent;
    }

    public String getInvestQuarter() {
        return investQuarter;
    }

    public void setInvestQuarter(String investQuarter) {
        this.investQuarter = investQuarter;
    }
}
