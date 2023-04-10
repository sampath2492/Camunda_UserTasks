package com.example.workflow.service;

import com.example.workflow.ApproveDraft;
import com.example.workflow.CreateDraft;
import com.example.workflow.DealerEdit;
import com.example.workflow.OpsEdit;
import com.example.workflow.Repository.ProductRepository;
import com.example.workflow.dto.Product;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.impl.persistence.entity.TaskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TasksService {
    @Autowired
    private TaskService taskService;
    @Autowired
    private CreateDraft createDraft;
    @Autowired
    private ApproveDraft approveDraft;
    @Autowired
    private DealerEdit dealerEdit;
    @Autowired
    private OpsEdit opsEdit;

    private final ProductRepository productRepository;

    public TasksService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product triggerCreateProduct(Product product) {
        long leftLimit = 1L;
        long rightLimit = 1000000L;
        long generatedLong = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
//        product.setId(generatedLong);
        product.setProductstatus("DRAFT");
        Product createdProduct = productRepository.save(product);
        TaskEntity task = (TaskEntity) taskService.createTaskQuery().taskId("create-draft").singleResult();
        createDraft.notify(task);
        return createdProduct;
    }

    public void triggerApproveProduct(Long id) {
        Product existingProduct = productRepository.findById(id).orElse(null);

        if (existingProduct != null) {
            existingProduct.setProductstatus("APPROVER");
            productRepository.save(existingProduct);
        }
        TaskEntity task = (TaskEntity) taskService.createTaskQuery().taskId("approve_draft").singleResult();
        createDraft.notify(task);
    }

    public void triggerDealerEdit(Long id) {
        Product existingProduct = productRepository.findById(id).orElse(null);

        if (existingProduct != null) {
            existingProduct.setProductstatus("DEALER");
            productRepository.save(existingProduct);
        }
        TaskEntity task = (TaskEntity) taskService.createTaskQuery().taskId("dealer_edit").singleResult();
        createDraft.notify(task);
    }

    public void triggerOpsEdit(Long id) {
        Product existingProduct = productRepository.findById(id).orElse(null);

        if (existingProduct != null) {
            existingProduct.setProductstatus("APPROVED");
            productRepository.save(existingProduct);
        }
        TaskEntity task = (TaskEntity) taskService.createTaskQuery().taskId("ops_edit").singleResult();
        createDraft.notify(task);
    }
}
