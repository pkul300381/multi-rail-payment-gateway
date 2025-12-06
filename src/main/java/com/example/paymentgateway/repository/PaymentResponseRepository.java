package com.example.paymentgateway.repository;

import com.example.paymentgateway.model.PaymentResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentResponseRepository extends JpaRepository<PaymentResponse, Long> {
}
