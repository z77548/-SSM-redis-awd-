package com.ssm.chapter.config;

import java.util.concurrent.Executor;

import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class webconfi extends  AsyncConfigurerSupport{
	
	@Override
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(5);
		taskExecutor.setMaxPoolSize(10);
		taskExecutor.setQueueCapacity(200);
		taskExecutor.initialize();
		return taskExecutor;
	}
}
