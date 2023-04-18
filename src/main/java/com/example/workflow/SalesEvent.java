package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SalesEvent implements TaskListener {

    @Override
    public void notify(DelegateTask delegateTask) {
        Logger.getLogger("Customer workFlow")
                .log(Level.INFO, "Sales Info Entered.");
    }
}
