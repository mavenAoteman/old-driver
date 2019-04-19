package com.old.driver.service;

import com.old.driver.util.ThreadUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.old.driver.fetcher.OldDriverFetcher;

import java.util.concurrent.Callable;

@Service
public class OldDriverService {
	private static final Logger logger = Logger.getLogger(OldDriverService.class);

	public void boom(String phone) {
		logger.info("开始轰炸：" + phone);
		ThreadUtils.EXECUTOR_SERVICE.submit(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				OldDriverFetcher od = new OldDriverFetcher();
				od.setPhone(phone);
				od.boom();
				return 1;
			}
		});

	}

}
