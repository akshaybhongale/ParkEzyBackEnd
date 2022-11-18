package com.example.user.controller;

import com.example.user.models.Vehicle;
import com.example.user.models.WebResponse;
import com.example.user.service.VehicleService;
import com.example.user.utils.Util;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/vehicle")
@AllArgsConstructor
public class VehicleController {


    private final VehicleService vehicleService;

    @RequestMapping(value = "/addVehicle", method = RequestMethod.POST)
    public ResponseEntity<Object> addVehicle(@RequestBody Vehicle vehicle) {
        vehicle.setVehicleId(Util.getVehicleId());
        Vehicle vehicle1 = vehicleService.create(vehicle);

        WebResponse webResponse = new WebResponse("object", vehicle1,
                HttpStatus.OK, "added  details successfully");
        return new ResponseEntity<>(webResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<Object> update(
            @RequestBody Vehicle vehicle1) {
        vehicleService.update(vehicle1);
        WebResponse webResponse = new WebResponse("object", "",
                HttpStatus.OK, "updated  details successfully");
        return new ResponseEntity<>(webResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{vehicleId}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("vehicleId") String vehicleId) {
        vehicleService.remove(vehicleId);
        WebResponse webResponse = new WebResponse("object", "",
                HttpStatus.OK, "deleted  successfully");
        return new ResponseEntity<>(webResponse, HttpStatus.OK);
    }

    /**
     * This method is used to get list all register use
     *
     * @return list of register user
     */
    @GetMapping(value = "/getVehicleList")
    public ResponseEntity<Object> getList() {
        WebResponse webResponse = new WebResponse("array", vehicleService.getAllList(),
                HttpStatus.OK, "fetched details successfully");
        return new ResponseEntity<>(webResponse, HttpStatus.OK);
    }


    @RequestMapping(value = "/getVehicleDetails/{vehicleId}", method = RequestMethod.GET)
    public ResponseEntity<Object> getVehicleDetails(@PathVariable("vehicleId") String vehicleId) {
        Vehicle parkingSpot = vehicleService.getVehicleDetails(vehicleId);
        WebResponse webResponse;
        if (parkingSpot != null) {
            webResponse = new WebResponse("object", parkingSpot,
                    HttpStatus.OK, "details fetched successfully");
        } else {
            webResponse = new WebResponse("object", "",
                    HttpStatus.OK, "no record found");
        }
        return new ResponseEntity<>(webResponse, HttpStatus.OK);
    }
}
