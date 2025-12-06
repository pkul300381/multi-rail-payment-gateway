package com.example.paymentgateway.repository;

import com.example.paymentgateway.model.PaymentResponse;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentResponseRepository extends MongoRepository<PaymentResponse, String> {
}
