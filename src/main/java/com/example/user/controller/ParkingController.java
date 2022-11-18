package com.example.user.controller;

import com.example.user.models.ParkingSpot;
import com.example.user.models.WebResponse;
import com.example.user.service.ParkingSpotService;
import com.example.user.utils.Util;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/parking")
@AllArgsConstructor
public class ParkingController {

    private final ParkingSpotService parkingSpotService;

    @RequestMapping(value = "/addParking", method = RequestMethod.POST)
    public ResponseEntity<Object> addParking(@RequestBody ParkingSpot parkingSpot) {
        parkingSpot.setParkingId(Util.getParkingId());
        ParkingSpot parkingSpot1 = parkingSpotService.create(parkingSpot);

        WebResponse webResponse = new WebResponse("object", parkingSpot1,
                HttpStatus.OK, "added parking details successfully");
        return new ResponseEntity<>(webResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<Object> update(
            @RequestBody ParkingSpot parkingSpot) {
        parkingSpotService.update(parkingSpot);
        WebResponse webResponse = new WebResponse("object", "",
                HttpStatus.OK, "updated parking details successfully");
        return new ResponseEntity<>(webResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{parkingId}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("parkingId") String parkingId) {
        parkingSpotService.remove(parkingId);
        WebResponse webResponse = new WebResponse("object", "",
                HttpStatus.OK, "deleted parking successfully");
        return new ResponseEntity<>(webResponse, HttpStatus.OK);
    }

    /**
     * This method is used to get list all register use
     *
     * @return list of register user
     */
    @GetMapping(value = "/getParkingList")
    public ResponseEntity<Object> getList() {
        WebResponse webResponse = new WebResponse("array", parkingSpotService.getAllList(),
                HttpStatus.OK, "fetched details successfully");
        return new ResponseEntity<>(webResponse, HttpStatus.OK);
    }


    @RequestMapping(value = "/getParkingDetails/{parkingId}", method = RequestMethod.GET)
    public ResponseEntity<Object> getParkingDetails(@PathVariable("parkingId") String parkingId) {
        ParkingSpot parkingSpot = parkingSpotService.getParkingDetails(parkingId);
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
