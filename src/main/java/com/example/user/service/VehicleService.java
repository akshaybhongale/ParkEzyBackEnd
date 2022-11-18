package com.example.user.service;

import com.example.user.models.Vehicle;
import com.example.user.repos.IVehicleRepos;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class VehicleService {


    /**
     * For debugging purpose
     */
    private static final Logger logger = LoggerFactory.getLogger(VehicleService.class);

    private final IVehicleRepos iVehicleRepos;


    public Vehicle create(Vehicle vehicle) {
        logger.info("create parking ::" + vehicle);
        return iVehicleRepos.save(vehicle);
    }

    public List<Vehicle> getAllList() {
        return iVehicleRepos.findAll();
    }

    public void remove(String id) {
        iVehicleRepos.deleteById(id);
    }

    public Vehicle update(Vehicle vehicle) {
        logger.info("update vehicle ::" + vehicle);
        Optional<Vehicle> vehicle1 = iVehicleRepos.findById(vehicle.getVehicleId());
        if (vehicle1.isPresent()) {
            logger.info("vehicle if db vehicle1 ::" + vehicle1);
            Vehicle trainee2 = vehicle;
            trainee2.setVehicleId(vehicle1.get().getVehicleId());
            logger.info("vehicle if updated trainee2 ::" + trainee2);
            return iVehicleRepos.save(trainee2);
        } else {
            logger.info("vehicle present else ::" + vehicle);
            return iVehicleRepos.save(vehicle);
        }
    }

    public Vehicle getVehicleDetails(String id) {
        Optional<Vehicle> user = iVehicleRepos.findById(id);
        return user.orElse(null);
    }

    public void deleteAll() {
        iVehicleRepos.deleteAll();
    }


}
