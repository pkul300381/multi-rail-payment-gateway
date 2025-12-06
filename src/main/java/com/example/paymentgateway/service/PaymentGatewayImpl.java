package com.example.paymentgateway.service;

import com.example.paymentgateway.model.PaymentRequest;
import com.example.paymentgateway.model.PaymentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentGatewayImpl implements PaymentGateway {

    private final List<PaymentProcessor> paymentProcessors;

    @Autowired
    public PaymentGatewayImpl(List<PaymentProcessor> paymentProcessors) {
        this.paymentProcessors = paymentProcessors;
    }

    @Override
    public PaymentResponse processPayment(PaymentRequest paymentRequest) {
        Optional<PaymentProcessor> paymentProcessor = paymentProcessors.stream()
                .filter(p -> p.getProcessorName().equalsIgnoreCase(paymentRequest.getPaymentMethod()))
                .findFirst();

        if (paymentProcessor.isPresent()) {
            return paymentProcessor.get().process(paymentRequest);
        } else {
            throw new IllegalArgumentException("Unsupported payment method: " + paymentRequest.getPaymentMethod());
        }
    }
}
