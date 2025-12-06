package com.example.paymentgateway.service;

import com.example.paymentgateway.model.PaymentRequest;
import com.example.paymentgateway.model.PaymentResponse;
import org.springframework.stereotype.Service;

@Service
public class NetBankingPaymentProcessor implements PaymentProcessor {

    @Override
    public PaymentResponse process(PaymentRequest paymentRequest) {
        // Simulate net banking payment processing
        System.out.println("Processing net banking payment for order: " + paymentRequest.getOrderId());
        PaymentResponse response = new PaymentResponse();
        response.setOrderId(paymentRequest.getOrderId());
        response.setStatus("SUCCESS");
        response.setTransactionId("NET" + System.currentTimeMillis());
        return response;
    }

    @Override
    public String getProcessorName() {
        return "NETBANKING";
    }
}
