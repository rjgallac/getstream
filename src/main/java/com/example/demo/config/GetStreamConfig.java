package com.example.demo.config;

import io.getstream.client.Client;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.MalformedURLException;

@Configuration
public class GetStreamConfig {

    @Value("${stream.api_key}")
    private String apiKey;

    @Value("${stream.api_secret}")
    private String apiSecret;

     @Bean
     public Client getStreamClient() {
         try {
             return Client.builder(apiKey, apiSecret).build();
         } catch (MalformedURLException e) {
             throw new RuntimeException(e);
         }
     }
}
