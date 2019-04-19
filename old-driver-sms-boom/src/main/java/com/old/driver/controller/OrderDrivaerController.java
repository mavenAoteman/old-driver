package com.old.driver.controller;

import com.old.driver.service.OldDriverService;
import io.swagger.annotations.Api;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/channel")
@Api(tags = "短信轰炸接口", description = "短信轰炸接口说明", hidden = true)
public class OrderDrivaerController {
    private static final Logger logger = Logger.getLogger(OrderDrivaerController.class);
    @Autowired
    OldDriverService service;


    @RequestMapping(value = "/addChannel", produces = "text/html;charset=UTF-8",method = RequestMethod.GET)
    @ResponseBody
    public String boom(@RequestParam(required = true) String phone) {
        logger.info("------接到轰炸请求--- 是时候干一票了---");
        service.boom(phone);
        return "ok";
    }

}
