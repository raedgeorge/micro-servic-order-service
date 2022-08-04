package com.atech.ms.orderservice.services.beer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

/**
 * @author raed abu Sa'da
 * on 01/08/2022
 */

@Slf4j
@Service
@ConfigurationProperties(prefix = "com.atech", ignoreUnknownFields = false)
public class BeerServiceImpl implements BeerService{

    private static final String URL_PATH = "/api/v1/beer/";
    private static final String UPC_URL_PATH = "/api/v1/beerUpc/";
    private String hostServicePath;

    private final RestTemplate restTemplate;

    public BeerServiceImpl(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate  =restTemplateBuilder.build();
    }

    public void setHostServicePath(String hostServicePath) {
        this.hostServicePath = hostServicePath;
    }

    @Override
    public BeerDto getBeerById(UUID beerId) {

       return restTemplate.getForObject(hostServicePath + URL_PATH + beerId.toString(), BeerDto.class);

    }

    @Override
    public BeerDto getBeerByUpc(String upc) {

        return restTemplate.getForObject(hostServicePath + UPC_URL_PATH + upc, BeerDto.class);
    }
}
