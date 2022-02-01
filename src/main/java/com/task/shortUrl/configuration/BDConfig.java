package com.task.shortUrl.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class BDConfig {

//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("org.postgresql.Driver");
//        dataSource.setPassword("1234");
//        dataSource.setUrl("jdbc:postgresql://localhost:5432/URL");
//        dataSource.setUsername("postgres");
//        return dataSource;
//    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setPassword("8374665f37f11d296befeaf56a1f8e3dac55b7e27bd155d98d62683325cb5211");
        dataSource.setUrl("jdbc:postgresql://ec2-52-30-133-191.eu-west-1.compute.amazonaws.com:5432/dedp93ps6i9ccu");
        dataSource.setUsername("nqpfispchiwnbc");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }


}
