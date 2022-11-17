package com.example.user.service;


import com.example.user.models.ParkingSpot;
import com.example.user.repos.ParkingRepos;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ParkingSpotService {


    /**
     * For debugging purpose
     */
    private static final Logger logger = LoggerFactory.getLogger(ParkingSpotService.class);

    private final ParkingRepos parkingRepos;


    public ParkingSpot create(ParkingSpot parkingSpot) {
        logger.info("create parking ::" + parkingSpot.getParkingName());
        return parkingRepos.save(parkingSpot);
    }

    public List<ParkingSpot> getAllList() {
        return parkingRepos.findAll();
    }

    public void remove(String id) {
        parkingRepos.deleteById(id);
    }

    public ParkingSpot update(ParkingSpot parkingSpot) {
        logger.info("update parking ::" + parkingSpot);
        Optional<ParkingSpot> parkingSpot1 = parkingRepos.findById(parkingSpot.getParkingId());
        if (parkingSpot1.isPresent()) {
            logger.info("parking if db parkingSpot1 ::" + parkingSpot1);
            ParkingSpot trainee2 = parkingSpot;
            trainee2.setParkingId(parkingSpot1.get().getParkingId());
            logger.info("parking if updated trainee2 ::" + trainee2);
            return parkingRepos.save(trainee2);
        } else {
            logger.info("parking present else ::" + parkingSpot);
            return parkingRepos.save(parkingSpot);
        }
    }

    public ParkingSpot getParkingDetails(String id) {
        Optional<ParkingSpot> user = parkingRepos.findById(id);
        return user.orElse(null);
    }

    public void deleteAll() {
        parkingRepos.deleteAll();
    }


}
