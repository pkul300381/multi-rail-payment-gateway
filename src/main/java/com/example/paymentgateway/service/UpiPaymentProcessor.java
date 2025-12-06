package com.example.paymentgateway.service;

import com.example.paymentgateway.model.PaymentRequest;
import com.example.paymentgateway.model.PaymentResponse;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UpiPaymentProcessor implements PaymentProcessor {

    private final Random random = new Random();

    @Override
    public PaymentResponse process(PaymentRequest paymentRequest) {
        System.out.println("Processing UPI payment for order: " + paymentRequest.getOrderId());

        if (paymentRequest.getAmount() <= 0) {
            throw new IllegalArgumentException("Invalid payment amount.");
        }

        PaymentResponse response = new PaymentResponse();
        response.setOrderId(paymentRequest.getOrderId());

        if (random.nextBoolean()) {
            response.setStatus("SUCCESS");
            response.setTransactionId("UPI" + System.currentTimeMillis());
        } else {
            response.setStatus("FAILURE");
            response.setTransactionId("UPI" + System.currentTimeMillis());
        }

        return response;
    }

    @Override
    public String getProcessorName() {
        return "UPI";
    }
}
