package com.gi.ctdn.restful;

import com.gi.ctdn.ods.biz.*;
import com.gi.ctdn.ods.pojo.*;
import com.gi.ctdn.view.common.MessageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("op")
public class OPController {

    @Autowired
    private AlexaPvUvBiz alexaPvUvBiz;

    @Autowired
    private AsoIosDownBiz asoIosDownBiz;
    @Autowired
    private AsoIosRateBiz asoIosRateBiz;
    @Autowired
    private AsoIosRateDailyBiz asoIosRateDailyBiz;
    @Autowired
    private OpIndiceSummaryBiz opIndiceSummaryBiz;
    @Autowired
    private QqAndroidDownBiz qqAndroidDownBiz;
    @Autowired
    private QqAndroidRateBiz qqAndroidRateBiz;
    @Autowired
    private QqAndroidRateDailyBiz qqAndroidRateDailyBiz;
    @Autowired
    private WeixinIndiceBiz weixinIndiceBiz;
    @Autowired
    private WeiboIndiceBiz weiboIndiceBiz;

    private static final Logger LOGGER = LoggerFactory.getLogger(OPController.class);

    @RequestMapping("pvuv/{code}")
    @ResponseBody
    public MessageInfo<List<AlexaPvUv>> alexaPvUvpvuv(@PathVariable String code) {
        MessageInfo<List<AlexaPvUv>> messageInfo = alexaPvUvBiz.getListByCode(code);
        return messageInfo;
    }
/*

    @RequestMapping("pvuv")
    @ResponseBody
    public MessageInfo<List<AlexaPvUv>> alexaPvUvpvuv(String domain) {
        if(domain!=null){
            domain = domain.replace("https://","");
            domain = domain.replace("http://","");
            if (domain.indexOf("/")!=-1){
                domain = domain.split("/")[0];
            }
            String arr [] =domain.split(".");
            int len = arr.length;
            if (len >2){
                if (arr[len-2]=="cn" && len >2 ){
                    domain= arr[len-4]+"."+arr[len-3]+"."+arr[len-2];
                }else{
                    domain=arr[len-2]+"."+arr[len-1];
                }
            }
        }
        MessageInfo<List<AlexaPvUv>> messageInfo = alexaPvUvBiz.getListByDoamin(domain);
        return messageInfo;
        }
*/

        @RequestMapping("iosdown/{appid}")
        @ResponseBody
        public MessageInfo<List<AsoIosDown>> asoIosDowniosdown(@PathVariable Long appid){
            MessageInfo<List<AsoIosDown>> messageInfo = asoIosDownBiz.getListByAppid(appid);
            return messageInfo;
        }


        @RequestMapping("rateinfo/{appid}")
        @ResponseBody
        public MessageInfo<List<AsoIosRate>> asoIosRate(@PathVariable Long appid){
            MessageInfo<List<AsoIosRate>> messageInfo = asoIosRateBiz.getListByAppid(appid);
            return messageInfo;
        }

        @RequestMapping("iosratedaily/{appid}")
        @ResponseBody
        public MessageInfo<List<AsoIosRateDaily>> asoIosRateDaily(@PathVariable Long appid){
            MessageInfo<List<AsoIosRateDaily>> messageInfo = asoIosRateDailyBiz.getListByAppid(appid);
            return messageInfo;
        }

        /**
         * ios所有运营数据
         * @param appid
         * @return
         */
        @RequestMapping("ios/{appid}")
        @ResponseBody
        public Map ios(@PathVariable Long appid) {
            MessageInfo<List<AsoIosDown>> downData = asoIosDownBiz.getListByAppid(appid);
            MessageInfo<List<AsoIosRate>> rateData = asoIosRateBiz.getListByAppid(appid);
            MessageInfo<List<AsoIosRateDaily>> rateDailyData = asoIosRateDailyBiz.getListByAppid(appid);
            Map<String,Object> map = new HashMap<>();
            map.put("downData",downData);
            map.put("rateData",rateData);
            map.put("rateDailyData",rateDailyData);
            return map;
        }




        @RequestMapping("is")
        @ResponseBody
        public MessageInfo<List<OpIndiceSummary>> opIndiceSummary(@RequestBody OpIndiceSummary opIndiceSummary){
            MessageInfo<List<OpIndiceSummary>> messageInfo = opIndiceSummaryBiz.getListByCode(opIndiceSummary.getCode());
            return messageInfo;
        }



        @RequestMapping("qqandroiddown/{appid}")
        @ResponseBody
        public MessageInfo<List<QqAndroidDown>> qqAndroidDown(@PathVariable Long appid){
            MessageInfo<List<QqAndroidDown>> messageInfo = qqAndroidDownBiz.getListByAppid(appid);
            return messageInfo;
        }
        @RequestMapping("qqandroidrate/{appid}")
        @ResponseBody
        public MessageInfo<List<QqAndroidRate>> qqAndroidRate(@PathVariable Long appid){
            MessageInfo<List<QqAndroidRate>> messageInfo = qqAndroidRateBiz.getListByAppid(appid);
            return messageInfo;
        }


        @RequestMapping("qqandroidratedaily/{appid}")
        @ResponseBody
        public MessageInfo<List<QqAndroidRateDaily>> qqAndroidRateDaily(@PathVariable Long appid){
            MessageInfo<List<QqAndroidRateDaily>> messageInfo = qqAndroidRateDailyBiz.getListByAppid(appid);
            return messageInfo;
        }

        /**
         * android所有运营数据
         * @param appid
         * @return
         */
        @RequestMapping("android/{appid}")
        @ResponseBody
        public Map android(@PathVariable Long appid) {
            MessageInfo<List<QqAndroidDown>> downData = qqAndroidDownBiz.getListByAppid(appid);
            MessageInfo<List<QqAndroidRate>> rateData = qqAndroidRateBiz.getListByAppid(appid);
            MessageInfo<List<QqAndroidRateDaily>> rateDailyData = qqAndroidRateDailyBiz.getListByAppid(appid);
            Map<String,Object> map = new HashMap<>();
            map.put("downData",downData);
            map.put("rateData",rateData);
            map.put("rateDailyData",rateDailyData);
            return map;
        }

        @RequestMapping("weixinindice/{wxid}")
        @ResponseBody
        public MessageInfo<List<WeixinIndice>> weixinIndice(@PathVariable String wxid){
            MessageInfo<List<WeixinIndice>> messageInfo = weixinIndiceBiz.getListByWxid(wxid);
            return messageInfo;
        }


        @RequestMapping("weiboIndice/{wbid}")
        @ResponseBody
        public MessageInfo<List<WeiboIndice>> weiboIndice(@PathVariable Long wbid){
            MessageInfo<List<WeiboIndice>> messageInfo = weiboIndiceBiz.getListByWbid(wbid);
            return messageInfo;
        }


    }
