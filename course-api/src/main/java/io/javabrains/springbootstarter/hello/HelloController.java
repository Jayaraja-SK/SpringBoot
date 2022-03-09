package io.javabrains.springbootstarter.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping("/hello") // BY DEAFULT, THE METHOD IS GET
	public String Welcome() {
		return "WELCOME TO SPRING BOOT";
	}
}
