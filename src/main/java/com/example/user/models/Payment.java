package com.example.user.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Payment")
public class Payment {
    @Id
    private String paymentId;
    private String paymentName ;
    private String icon;
    private String balance;
    private boolean isPrimary;

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId='" + paymentId + '\'' +
                ", paymentName='" + paymentName + '\'' +
                ", icon='" + icon + '\'' +
                ", balance='" + balance + '\'' +
                ", isPrimary=" + isPrimary +
                '}';
    }

    public Payment(String paymentId, String paymentName, String icon, String balance, boolean isPrimary) {
        this.paymentId = paymentId;
        this.paymentName = paymentName;
        this.icon = icon;
        this.balance = balance;
        this.isPrimary = isPrimary;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public void setPrimary(boolean primary) {
        isPrimary = primary;
    }
}
