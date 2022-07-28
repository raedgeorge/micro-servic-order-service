package com.atech.ms.orderservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author raed abu Sa'da
 * on 28/07/2022
 */

@EnableScheduling
@EnableAsync
@Configuration
public class TaskConfig {

    @Bean
    public TaskExecutor taskExecutor(){
        return new SimpleAsyncTaskExecutor();
    }
}
