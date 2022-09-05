package com.atech.ms.orderservice.config;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author raed abu Sa'da
 * on 24/08/2022
 */

@Profile("local-discovery")
@EnableEurekaClient
@Configuration
public class LocalDiscovery {
}
