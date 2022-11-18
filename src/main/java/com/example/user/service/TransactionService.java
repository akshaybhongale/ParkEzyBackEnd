package com.example.user.service;

import com.example.user.models.ParkingSpot;
import com.example.user.models.Transaction;
import com.example.user.models.TransactionRequest;
import com.example.user.repos.IParkingRepos;
import com.example.user.repos.ITransactionRepos;
import com.example.user.repos.IVehicleRepos;
import com.example.user.utils.Util;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
@Service
public class TransactionService {

    /**
     * For debugging purpose
     */

    private static final Logger logger = LoggerFactory.getLogger(TransactionService.class);

    private final VehicleService vehicleService;

    private final ITransactionRepos iTransactionRepos;

    private final ParkingSpotService parkingSpotService;


    public Transaction confirmParking(TransactionRequest request){
        ParkingSpot parkingSpot =parkingSpotService.getParkingDetails(request.getParkingId());
        parkingSpot.setAvailable(false);
        parkingSpotService.update(parkingSpot);
        Transaction transaction = new Transaction(Util.getTransactionId(),
                request.getParkingId(),
                request.getVehicleId(),
                Util.getEpochTime(),
                0,
                0,
                true,
                request.getPaymentId());
        return  iTransactionRepos.save(transaction);
    }

    public Transaction payParking(TransactionRequest request){
        Optional<Transaction> transaction=iTransactionRepos.findById(request.getTransactionId());
        if(transaction.isPresent()){
            Transaction transaction1=transaction.get();
            long endTime =Util.getEpochTime();
            long startTime =transaction1.getStartTime();
            long time =endTime-startTime;
            long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(time);
            logger.info("currentTime: "+endTime+" startTime: "+startTime+" Difference time "+diffInMinutes);
            if(diffInMinutes >2){
                transaction1.setTotalAmount(30);
            }else {
                transaction1.setTotalAmount(20);
            }
            transaction1.setOnGoing(false);
            transaction1.setEndTime(endTime);
            ParkingSpot parkingSpot=parkingSpotService.getParkingDetails(request.getParkingId());
            parkingSpot.setAvailable(true);
            iTransactionRepos.save(transaction1);
            parkingSpotService.update(parkingSpot);
            return transaction1;
        }else {
            return null;
        }
    }

}
