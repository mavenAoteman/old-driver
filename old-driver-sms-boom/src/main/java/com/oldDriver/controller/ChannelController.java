//package com.puhui.crawler.web.controller;
//
//import javax.annotation.Resource;
//
//import org.apache.log4j.Logger;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.puhui.crawler.service.BlackListService;
//import com.puhui.crawler.service.ChannelService;
//import com.puhui.crawler.service.MobileService;
//
///**
// * 爬虫第三方切换数据源状态
// */
//@Controller
//public class ChannelController {
//    private static final Logger logger = Logger.getLogger(ChannelController.class);
//    @Resource
//    ChannelService channelService;
//    @Resource
//    private MobileService mobileService;
//    @Resource
//    private BlackListService blackListService;
//
//    /**
//     * 在redis添加一个切换渠道
//     * @param dataType
//     * @param typeKey
//     * @param channelName
//     * @param durex
//     * @return
//     */
//    @RequestMapping(value = "/addChannel", produces = "text/html;charset=UTF-8")
//    @ResponseBody
//    public String addChannel(@RequestParam(required = true) String dataType,
//            @RequestParam(required = true) String typeKey, @RequestParam(required = true) String channelName,
//            @RequestParam(defaultValue = "true", required = true) String durex) {
//        logger.info("addChannel " + dataType + typeKey + channelName);
//        return channelService.addChannels(dataType, typeKey, channelName);
//    }
//
//    /**
//     * 在redis删除一个切换渠道
//     * @param dataType
//     * @param typeKey
//     * @param durex
//     * @return
//     */
//    @RequestMapping(value = "/delChannel", produces = "text/html;charset=UTF-8")
//    @ResponseBody
//    public boolean delChannel(@RequestParam(required = true) String dataType,
//            @RequestParam(required = false) String typeKey,
//            @RequestParam(defaultValue = "true", required = true) String durex) {
//        logger.info("delChannel " + dataType + typeKey);
//        return channelService.delChannels(dataType, typeKey);
//    }
//
//    /**
//     * 查询一个渠道
//     * @param dataType
//     * @param typeKey
//     * @param durex
//     * @return
//     */
//    @RequestMapping(value = "/selChannel", produces = "text/html;charset=UTF-8")
//    @ResponseBody
//    public String selChannel(@RequestParam(required = true) String dataType,
//            @RequestParam(required = false) String typeKey,
//            @RequestParam(defaultValue = "true", required = true) String durex) {
//        logger.info("selChannel " + dataType + typeKey);
//        return channelService.getChannels(dataType, typeKey);
//    }
//
//    /**
//     * 修改
//     * @param dataType
//     * @param typeKey
//     * @param channelName
//     * @param durex
//     * @return
//     */
//    @RequestMapping(value = "/upChannel", produces = "text/html;charset=UTF-8")
//    @ResponseBody
//    public String upChannel(@RequestParam(required = true) String dataType,
//            @RequestParam(required = true) String typeKey, @RequestParam(required = true) String channelName,
//            @RequestParam(defaultValue = "true", required = true) String durex) {
//        logger.info("upChannel " + dataType + typeKey + channelName);
//        return channelService.upChannels(dataType, typeKey, channelName);
//    }
//    
//}
