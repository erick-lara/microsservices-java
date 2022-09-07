package com.example.hrpayroll.hrpayroll.controllers;

import com.example.hrpayroll.hrpayroll.entities.Payment;
import com.example.hrpayroll.hrpayroll.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping(value = "/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(
            @PathVariable long workerId,
            @PathVariable int days
    ){
        return ResponseEntity.ok(paymentService.getPayment(workerId, days));
    }
}
