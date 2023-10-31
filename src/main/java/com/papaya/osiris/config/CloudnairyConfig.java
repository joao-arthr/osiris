package com.papaya.osiris.config;

import com.cloudinary.Cloudinary;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class CloudnairyConfig {
    @Value("${cloud_name}")
    private final String cloudName;
    @Value("${api_key}")
    private final String apiKey;
    @Value("${api_secret}")
    private final String apiSecret;

    @Bean
    public Cloudinary cloudinary(){
        return new Cloudinary(Map.of("cloud_name", cloudName, "api_key", apiKey, "api_secret", apiSecret));
    }
}
