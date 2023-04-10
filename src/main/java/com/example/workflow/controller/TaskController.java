package com.example.workflow.controller;

import com.example.workflow.dto.Product;
import com.example.workflow.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TasksService tasksService;

    @PostMapping("/createProduct")
    public ResponseEntity<Product> completeCreateProductTask(@RequestBody Product product) {
        Product createdProduct = tasksService.triggerCreateProduct(product);
        return ResponseEntity.ok(createdProduct);
    }
    @PostMapping("/{id}/approveProduct")
    public ResponseEntity<Void> completeApproveProductTask(@PathVariable Long id) {
        tasksService.triggerApproveProduct(id);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/{id}/dealerEdit")
    public ResponseEntity<Void> completeDealerEditTask(@PathVariable Long id) {
        tasksService.triggerDealerEdit(id);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/{id}/opsEdit")
    public ResponseEntity<Void> completeOpsEditTask(@PathVariable Long id) {
        tasksService.triggerOpsEdit(id);
        return ResponseEntity.ok().build();
    }

}
