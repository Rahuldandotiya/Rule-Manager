package com.rule.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ExecutorConfigurationSupport;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@EnableAsync
public class RuleManagerApplication {

	@PostMapping("/{count}")
	@Async
	public CompletableFuture<Object> getMessage(@PathVariable Integer count) throws InterruptedException, ExecutionException{
		StringBuilder res=new StringBuilder();
		List<CompletableFuture<String>> asyncResponse = new ArrayList<>();
		for(int i=1;i<=count;i++) {
			asyncResponse.add(fetchAsync());
		}
		
		CompletableFuture<Void> allOf=CompletableFuture.allOf(asyncResponse.toArray(new CompletableFuture[0]));

	    return allOf.thenApply(ignored->{
	    	asyncResponse.forEach(response->{
	    		res.append("response "+response.join()+"\n");
	    	});
	    	return res.toString();
	    });
	}
	public static void main(String[] args) {
		SpringApplication.run(RuleManagerApplication.class, args);
	}

	private CompletableFuture<String> fetchAsync(){
		return CompletableFuture.supplyAsync(()->{
			RestTemplate restTemplate=new RestTemplate();
			return restTemplate.getForObject("http://localhost:8081/", String.class);
		});
	}

}
