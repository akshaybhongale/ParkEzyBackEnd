package com.example.user.models;

public class TransactionRequest {
    private String parkingId;
    private String vehicleId;
    private String paymentId;
    private String transactionId;

    public TransactionRequest(String parkingId, String vehicleId, String paymentId,String transactionId) {
        this.parkingId = parkingId;
        this.vehicleId = vehicleId;
        this.paymentId = paymentId;
        this.transactionId=transactionId;
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

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
