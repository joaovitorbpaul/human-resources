package com.jpaul.hrpayroll.services;

import com.jpaul.hrpayroll.entities.Payment;

public interface PaymentService {
	Payment getPayment(long workerId, int days);
}
