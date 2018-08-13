package com.old.driver.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.old.driver.fetcher.OldDriverFetcher;

@Service
public class OldDriverService {
	private static final Logger logger = Logger.getLogger(OldDriverService.class);

	public void boom(String phone) {
		logger.info("开始轰炸：" + phone);
		OldDriverFetcher od = new OldDriverFetcher();
		od.setPhone(phone);
		od.boom();
	}

}
