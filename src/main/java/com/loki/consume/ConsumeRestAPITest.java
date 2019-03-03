package com.loki.consume;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

public class ConsumeRestAPITest {

	private static final Logger log = LoggerFactory.getLogger(ConsumeRestAPITest.class);

	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();

		Quote q = restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
		log.info(q.toString());
	}

}
