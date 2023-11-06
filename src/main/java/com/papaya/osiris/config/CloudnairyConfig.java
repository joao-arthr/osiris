package com.papaya.osiris.config;

import com.cloudinary.Cloudinary;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@RequiredArgsConstructor
@ComponentScan
public class CloudnairyConfig {
    private final String cloudName = "dvxkj7fwq";
    private final String apiKey = "974855883575445";
    private final String apiSecret = "pxCtlp3yNn7KpynRSVEMzmbC9WA";

    @Bean
    public Cloudinary cloudinary(){
        return new Cloudinary(Map.of("cloud_name", cloudName, "api_key", apiKey, "api_secret", apiSecret));
    }
}
