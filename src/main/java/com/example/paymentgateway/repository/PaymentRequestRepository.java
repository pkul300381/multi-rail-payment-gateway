package com.example.paymentgateway.repository;

import com.example.paymentgateway.model.PaymentRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRequestRepository extends MongoRepository<PaymentRequest, String> {
}
