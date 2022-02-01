package com.task.shortUrl.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Timer;

@Configuration
public class CFG {

    @Bean
    public Timer timer(){
        return new Timer();
    }

}
