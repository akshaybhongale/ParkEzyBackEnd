package com.example.user.service;

import com.example.user.models.Payment;
import com.example.user.repos.IPaymentRepos;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PaymentService {


    /**
     * For debugging purpose
     */
    private static final Logger logger = LoggerFactory.getLogger(PaymentService.class);

    private final IPaymentRepos iPaymentRepos;


    public Payment create(Payment vehicle) {
        logger.info("create parking ::" + vehicle);
        return iPaymentRepos.save(vehicle);
    }

    public List<Payment> getAllList() {
        return iPaymentRepos.findAll();
    }

    public void remove(String id) {
        iPaymentRepos.deleteById(id);
    }

    public Payment update(Payment vehicle) {
        logger.info("update Payment ::" + vehicle);
        Optional<Payment> vehicle1 = iPaymentRepos.findById(vehicle.getPaymentId());
        if (vehicle1.isPresent()) {
            logger.info("Payment if db vehicle1 ::" + vehicle1);
            Payment trainee2 = vehicle;
            trainee2.setPaymentId(vehicle1.get().getPaymentId());
            logger.info("Payment if updated trainee2 ::" + trainee2);
            return iPaymentRepos.save(trainee2);
        } else {
            logger.info("Payment present else ::" + vehicle);
            return iPaymentRepos.save(vehicle);
        }
    }

    public Payment getPaymentDetails(String id) {
        Optional<Payment> user = iPaymentRepos.findById(id);
        return user.orElse(null);
    }

    public void deleteAll() {
        iPaymentRepos.deleteAll();
    }


}