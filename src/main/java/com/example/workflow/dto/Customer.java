package com.example.workflow.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    private String customerName;
    private String customerEmail;
    private String salesStatus;
    private String rmStatus;
    private String docStatus;
    private String creditStatus;
    private String sdsStatus;
    private String welcomeStatus;

    public Long getCustomerId() { return customerId; }

//    public void setCustomerId(Long customerId) { this.customerId = customerId; }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getSalesStatus() {
        return salesStatus;
    }

    public void setSalesStatus(String salesStatus) {
        this.salesStatus = salesStatus;
    }

    public String getRmStatus() {
        return rmStatus;
    }

    public void setRmStatus(String rmStatus) {
        this.rmStatus = rmStatus;
    }

    public String getDocStatus() {
        return docStatus;
    }

    public void setDocStatus(String docStatus) {
        this.docStatus = docStatus;
    }

    public String getCreditStatus() {
        return creditStatus;
    }

    public void setCreditStatus(String creditStatus) {
        this.creditStatus = creditStatus;
    }

    public String getSdsStatus() {
        return sdsStatus;
    }

    public void setSdsStatus(String sdsStatus) {
        this.sdsStatus = sdsStatus;
    }

    public String getWelcomeStatus() {
        return welcomeStatus;
    }

    public void setWelcomeStatus(String welcomeStatus) {
        this.welcomeStatus = welcomeStatus;
    }
}
