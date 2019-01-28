package com.loki.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import com.loki.pojo.Quote;

public class ConsumeRestApplication {

	private static final Logger log = LoggerFactory.getLogger(ConsumeRestApplication.class);

	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();

		Quote q = restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
		log.info(q.toString());
	}

}
