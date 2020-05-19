package com.oldDriver.controller;

import com.oldDriver.fetcher.OldDriverFetcher;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderDrivaerController {
    private static final Logger logger = Logger.getLogger(OrderDrivaerController.class);

    @Autowired
    private OldDriverFetcher fetcher;

//    @RequestMapping(value = "/addChannel", produces = "text/html;charset=UTF-8")
//    @ResponseBody
//    public String boom(@RequestParam(required = true) String phone,
//            @RequestParam(required = true) String userName, @RequestParam(required = true) String password,
//            @RequestParam(defaultValue = "true", required = true) String durex) {
//        logger.info("------接到轰炸请求--- 是时候干一票了---");
//        fetcher.boom(phone);
//        return null;
//    }

    @RequestMapping(value = "/addChannel", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String boom(@RequestParam(required = true) String phone) {
        logger.info("------接到轰炸请求--- 是时候干一票了---");
        fetcher.boom();
        return null;
    }

}
