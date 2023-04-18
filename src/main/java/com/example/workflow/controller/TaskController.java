package com.example.workflow.controller;

import com.example.workflow.dto.Customer;
import com.example.workflow.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class TaskController {

    @Autowired
    private TasksService tasksService;

    @PostMapping("/create")
    public ResponseEntity<Customer> completeCreateCustomerTask(@RequestBody Customer customer) {
        Customer createdCustomer = tasksService.triggerCreateCustomer(customer);
        return ResponseEntity.ok(createdCustomer);
    }
    @PostMapping("/{id}/salesEvent")
    public ResponseEntity<Void> completeSalesEvent(@PathVariable Long id) {
        tasksService.triggerSalesEvent(id);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/{id}/rmEvent")
    public ResponseEntity<Void> completeRmEvent(@PathVariable Long id) {
        tasksService.triggerRmEvent(id);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/{id}/docEvent")
    public ResponseEntity<Void> completeDocEvent(@PathVariable Long id) {
        tasksService.triggerDocEvent(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/creditEvent")
    public ResponseEntity<Void> completeCreditEvent(@PathVariable Long id) {
        tasksService.triggerCreditEvent(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/sdcEvent")
    public ResponseEntity<Void> completeSdcEvent(@PathVariable Long id) {
        tasksService.triggerSdcEvent(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/welcome")
    public ResponseEntity<Void> completeWelcomeEvent(@PathVariable Long id) {
        tasksService.triggerWelcomeEvent(id);
        return ResponseEntity.ok().build();
    }

}
