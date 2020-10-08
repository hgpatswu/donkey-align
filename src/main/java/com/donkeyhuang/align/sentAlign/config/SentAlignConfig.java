package com.donkeyhuang.align.sentAlign.config;

import com.donkeyhuang.align.sentAlign.manager.SentAlignerJNI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(SentAlignConfigProperties.class)
public class SentAlignConfig {

    @Autowired
    private SentAlignConfigProperties prop;

    private SentAlignerJNI aligner;

    @Bean
    public SentAlignerJNI sentAlignerJNI() {
        if (aligner == null) aligner = new SentAlignerJNI();

        aligner.init(prop);

        return aligner;
    }


}
