package com.example.workflow.Configuration;

import com.example.workflow.ApproveDraft;
import com.example.workflow.CreateDraft;
import com.example.workflow.DealerEdit;
import com.example.workflow.OpsEdit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CamundaConfiguration {

    @Bean
    public CreateDraft createDraftListener() {
        return new CreateDraft();
    }

    @Bean
    public ApproveDraft approveDraftListener() {
        return new ApproveDraft();
    }

    @Bean
    public DealerEdit dealerEditListener() {
        return new DealerEdit();
    }

    @Bean
    public OpsEdit opsEditListener() {
        return new OpsEdit();
    }
}
