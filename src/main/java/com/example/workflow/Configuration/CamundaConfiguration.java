package com.example.workflow.Configuration;

import com.example.workflow.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CamundaConfiguration {

    @Bean
    public CreateCustomer createCustomerListener() {
        return new CreateCustomer();
    }

    @Bean
    public SalesEvent salesEventListener() {
        return new SalesEvent();
    }

    @Bean
    public RmEvent rmEventListener() {
        return new RmEvent();
    }

    @Bean
    public DocEvent docEventListener() { return new DocEvent(); }

    @Bean
    public CreditEvent creditEventListener() {
        return new CreditEvent();
    }

    @Bean
    public SdcEvent sdcEventListener() { return new SdcEvent();
    }

    @Bean
    public WelcomeEvent welcomeEventListener() {
        return new WelcomeEvent();
    }
}
