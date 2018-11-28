package com.rws.basic.oauth.basicoauth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BasicGetRequest {

    private Logger logger = LoggerFactory.getLogger(BasicGetRequest.class);

    @Value("${rest.endpoint.configuration.endpointUrl}")
    private String endpointUrl;

    private final RestTemplate restTemplate;

    @Autowired
    BasicGetRequest(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    void makeGetRequest() {
        try {
            logger.info("Attempting a get request to endpoint " + endpointUrl + " !");
            this.restTemplate.getForEntity(endpointUrl, String.class);
            logger.info("SUCCESS!!! Successful connection - Spring application connected to endpoint!");
        } catch (Exception e) {
            logger.info("Failed to connect!! Stack Trace Below:" , e );
        }
    }

    /*
    Example of a post request using the API Key security for Amazon
    void makePostRequest() {
        String API_KEY = "x-api-key";
        String awsKey = "awsApiKeyValueGoesHere";
        HttpHeaders headers = new HttpHeaders();
        headers.set(API_KEY, apiValue);
        String body = "body";
        HttpEntity<?> request = new HttpEntity<>(body, headers);
        restTemplate.postForEntity("postEndPointUrl", request, String.class);
    }
    */


}
