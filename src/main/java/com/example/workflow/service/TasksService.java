package com.example.workflow.service;

import com.example.workflow.*;
import com.example.workflow.Repository.CustomerRepository;
import com.example.workflow.dto.Customer;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.impl.persistence.entity.TaskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TasksService {
    @Autowired
    private TaskService taskService;
    @Autowired
    private CreateCustomer createCustomer;
    @Autowired
    private SalesEvent salesEvent;
    @Autowired
    private RmEvent rmEvent;
    @Autowired
    private DocEvent docEvent;
    @Autowired
    private CreditEvent creditEvent;
    @Autowired
    private SdcEvent sdcEvent;
    @Autowired
    private WelcomeEvent welcomeEvent;

    private final CustomerRepository customerRepository;

    public TasksService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public Customer triggerCreateCustomer(Customer customer) {
        long leftLimit = 1L;
        long rightLimit = 1000000L;
        long generatedLong = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
//        customer.setCustomerId(generatedLong);
        Customer createdCustomer = customerRepository.save(customer);
        System.out.println("Customer Details:"+createdCustomer.getCustomerId());
        TaskEntity task = (TaskEntity) taskService.createTaskQuery().taskId("create_customer").singleResult();
        createCustomer.notify(task);
        return createdCustomer;
    }

    public void triggerSalesEvent(Long id) {
        Customer existingCustomer = customerRepository.findById(id).orElse(null);

        if (existingCustomer != null) {
            existingCustomer.setSalesStatus("Done");
            customerRepository.save(existingCustomer);
        }
        TaskEntity task = (TaskEntity) taskService.createTaskQuery().taskId("sales_status").singleResult();
        salesEvent.notify(task);
    }

    public void triggerRmEvent(Long id) {
        Customer existingCustomer = customerRepository.findById(id).orElse(null);

        if (existingCustomer != null) {
            existingCustomer.setRmStatus("Done");
            customerRepository.save(existingCustomer);
        }
        TaskEntity task = (TaskEntity) taskService.createTaskQuery().taskId("rm_status").singleResult();
        rmEvent.notify(task);
    }

    public void triggerDocEvent(Long id) {
        Customer existingCustomer = customerRepository.findById(id).orElse(null);

        if (existingCustomer != null) {
            existingCustomer.setDocStatus("Done");
            customerRepository.save(existingCustomer);
        }
        TaskEntity task = (TaskEntity) taskService.createTaskQuery().taskId("doc_status").singleResult();
        docEvent.notify(task);
    }

    public void triggerCreditEvent(Long id) {
        Customer existingCustomer = customerRepository.findById(id).orElse(null);

        if (existingCustomer != null) {
            existingCustomer.setCreditStatus("Done");
            customerRepository.save(existingCustomer);
        }
        TaskEntity task = (TaskEntity) taskService.createTaskQuery().taskId("credit_status").singleResult();
        creditEvent.notify(task);
    }

    public void triggerSdcEvent(Long id) {
        Customer existingCustomer = customerRepository.findById(id).orElse(null);

        if (existingCustomer != null) {
            existingCustomer.setSdsStatus("Done");
            customerRepository.save(existingCustomer);
        }
        TaskEntity task = (TaskEntity) taskService.createTaskQuery().taskId("sdc_status").singleResult();
        sdcEvent.notify(task);
    }

    public void triggerWelcomeEvent(Long id) {
        Customer existingCustomer = customerRepository.findById(id).orElse(null);

        if (existingCustomer != null) {
            existingCustomer.setWelcomeStatus("Done");
            customerRepository.save(existingCustomer);
        }
        TaskEntity task = (TaskEntity) taskService.createTaskQuery().taskId("welcome_status").singleResult();
        welcomeEvent.notify(task);
    }
}
