package com.rule.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class RuleManagerApplication {

	@PostMapping("/{count}")
	public String getMessage(@PathVariable Integer count){
		StringBuilder res=new StringBuilder();
		for(int i=1;i<=count;i++) {
			RestTemplate restTemplate = new RestTemplate();
		    String response= restTemplate.getForObject("http://localhost:8081/", String.class);
		    res.append("response "+i+": "+response+"\n");
		}
		return res.toString();
	}
	public static void main(String[] args) {
		SpringApplication.run(RuleManagerApplication.class, args);
	}

}
