package com.example.prometheus_demo.controller;

import io.prometheus.client.Counter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
class EndPointController {

	private static Random random = new Random();

	private static final Counter requestTotal = Counter.build()
			.name("my_sample_counter")
			.labelNames("status")
			.help("A simple Counter to illustrate custom Counters in Spring Boot and Prometheus").register();

	@GetMapping("/endpoint")
	public String handle(@RequestParam(defaultValue = "World") String name) {
		if (random.nextInt(2) > 0) {
			requestTotal.labels("success").inc();
		} else {
			requestTotal.labels("error").inc();
		}

		return String.format("EndPoint: %d", random.nextInt(1000));
	}

	@GetMapping("/endpointA")
	public String handlerA() {
		return String.format("EndPoint A: %d", random.nextInt(1000));
	}

	@GetMapping("/endpointB")
	public String handlerB() {
		return String.format("EndPoint B: %d", random.nextInt(1000));
	}
}
