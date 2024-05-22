package com.ec.svg.web.svgwebapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootApplication
@Controller
public class SvgWebAppApplication {

	private static final Logger logger = LoggerFactory.getLogger(SvgWebAppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SvgWebAppApplication.class, args);
	}

	@GetMapping("/resource")
	@ResponseBody
	public Map<String, Object> home() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("id", UUID.randomUUID().toString());
		model.put("content", "Hello World");
		return model;
	}

	@GetMapping(value = "/{path:[^\\.]*}")
	public String redirect(@PathVariable("path") String pathString ) {
		logger.info("redirecting: " + pathString);
		return "forward:/";
	}
}
