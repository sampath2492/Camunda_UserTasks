package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;

import java.util.logging.Level;
import java.util.logging.Logger;

public class OpsEdit implements TaskListener {

    @Override
    public void notify(DelegateTask delegateTask) {
        Logger.getLogger("Product workFlow")
                .log(Level.INFO, "Ops Setup is Completed");
        Logger.getLogger("Product workFlow")
                .log(Level.INFO, "Product is Crated Successfully.");
    }
}
