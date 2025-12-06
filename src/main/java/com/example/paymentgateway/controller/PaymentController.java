package com.example.paymentgateway.controller;

import com.example.paymentgateway.model.PaymentRequest;
import com.example.paymentgateway.model.PaymentResponse;
import com.example.paymentgateway.service.PaymentGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private final PaymentGateway paymentGateway;

    @Autowired
    public PaymentController(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    @PostMapping("/pay")
    public PaymentResponse pay(@RequestBody PaymentRequest paymentRequest) {
        return paymentGateway.processPayment(paymentRequest);
    }
}
