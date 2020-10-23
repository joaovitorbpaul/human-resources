package com.jpaul.hrpayroll.services.impl;

import com.jpaul.hrpayroll.entities.Payment;
import com.jpaul.hrpayroll.integrations.WorkerClient;
import com.jpaul.hrpayroll.integrations.dtos.WorkerResponse;
import com.jpaul.hrpayroll.services.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final WorkerClient workerClient;

    @Override
    public Payment getPayment(long workerId, int days) {
        WorkerResponse worker = workerClient.findById(workerId);
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
