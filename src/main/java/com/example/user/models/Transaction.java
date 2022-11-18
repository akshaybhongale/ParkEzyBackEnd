package com.example.user.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Transaction")
public class Transaction {
    @Id
    private String transactionId;
    private String parkingId;
    private String vehicleId;
    private String paymentId;
    private long startTime;
    private long endTime;
    private double totalAmount;
    private boolean isOnGoing;

    public Transaction(String transactionId, String parkingId, String vehicleId, long startTime, long endTime, double totalAmount, boolean isOnGoing, String paymentId) {
        this.transactionId = transactionId;
        this.parkingId = parkingId;
        this.vehicleId = vehicleId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.totalAmount = totalAmount;
        this.isOnGoing = isOnGoing;
        this.paymentId = paymentId;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", parkingId='" + parkingId + '\'' +
                ", vehicleId='" + vehicleId + '\'' +
                ", paymentId='" + paymentId + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", totalAmount=" + totalAmount +
                ", isOnGoing=" + isOnGoing +
                '}';
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getParkingId() {
        return parkingId;
    }

    public void setParkingId(String parkingId) {
        this.parkingId = parkingId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean isOnGoing() {
        return isOnGoing;
    }

    public void setOnGoing(boolean onGoing) {
        isOnGoing = onGoing;
    }
}
