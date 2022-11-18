package com.example.user.controller;

import com.example.user.models.Transaction;
import com.example.user.models.TransactionRequest;
import com.example.user.models.WebResponse;
import com.example.user.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/transaction")
@AllArgsConstructor
public class TransactionController {

    private TransactionService transactionService;

    @RequestMapping(value = "/confirmParking", method = RequestMethod.POST)
    public ResponseEntity<Object> addVehicle(@RequestBody TransactionRequest transactionRequest) {
        Transaction transaction = transactionService.confirmParking(transactionRequest);

        WebResponse webResponse = new WebResponse("object", transaction,
                HttpStatus.OK, "added  details successfully");
        return new ResponseEntity<>(webResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/checkout", method = RequestMethod.POST)
    public ResponseEntity<Object> update(
            @RequestBody TransactionRequest transactionRequest) {
        transactionService.payParking(transactionRequest);
        WebResponse webResponse = new WebResponse("object", "",
                HttpStatus.OK, "updated  details successfully");
        return new ResponseEntity<>(webResponse, HttpStatus.OK);
    }
}
