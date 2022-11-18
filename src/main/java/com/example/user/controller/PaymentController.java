package com.example.user.controller;


import com.example.user.models.Payment;
import com.example.user.models.WebResponse;
import com.example.user.service.PaymentService;
import com.example.user.utils.Util;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/payment")
@AllArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @RequestMapping(value = "/addPayment", method = RequestMethod.POST)
    public ResponseEntity<Object> addPayment(@RequestBody Payment parkingSpot) {
        parkingSpot.setPaymentId(Util.getPaymentId());
        Payment parkingSpot1 = paymentService.create(parkingSpot);

        WebResponse webResponse = new WebResponse("object", parkingSpot1,
                HttpStatus.OK, "added parking details successfully");
        return new ResponseEntity<>(webResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<Object> update(
            @RequestBody Payment parkingSpot) {
        paymentService.update(parkingSpot);
        WebResponse webResponse = new WebResponse("object", "",
                HttpStatus.OK, "updated parking details successfully");
        return new ResponseEntity<>(webResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{paymentId}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("paymentId") String parkingId) {
        paymentService.remove(parkingId);
        WebResponse webResponse = new WebResponse("object", "",
                HttpStatus.OK, "deleted parking successfully");
        return new ResponseEntity<>(webResponse, HttpStatus.OK);
    }

    /**
     * This method is used to get list all register use
     *
     * @return list of register user
     */
    @GetMapping(value = "/getPaymentList")
    public ResponseEntity<Object> getList() {
        WebResponse webResponse = new WebResponse("array", paymentService.getAllList(),
                HttpStatus.OK, "fetched details successfully");
        return new ResponseEntity<>(webResponse, HttpStatus.OK);
    }


    @RequestMapping(value = "/getPaymentDetails/{paymentId}", method = RequestMethod.GET)
    public ResponseEntity<Object> getPaymentDetails(@PathVariable("paymentId") String parkingId) {
        Payment parkingSpot = paymentService.getPaymentDetails(parkingId);
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
