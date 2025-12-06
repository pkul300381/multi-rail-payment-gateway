package com.example.paymentgateway.service;

import com.example.paymentgateway.model.PaymentRequest;
import com.example.paymentgateway.model.PaymentResponse;

public interface PaymentProcessor {
    PaymentResponse process(PaymentRequest paymentRequest);
    String getProcessorName();
}
