package com.jpaul.hrpayroll.controllers.v1;

import com.jpaul.hrpayroll.entities.Payment;
import com.jpaul.hrpayroll.services.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PaymentController.BASE_URL)
@AllArgsConstructor
public class PaymentController {

    public static final String BASE_URL = "/payments";
    public static final String WORKER_ID_DAYS_DAYS_PATH = "/{workerId}/days/{days}";
    private final PaymentService paymentService;


    @GetMapping(WORKER_ID_DAYS_DAYS_PATH)
    @ResponseStatus(HttpStatus.OK)
    public Payment getPaymentByWorker(@PathVariable Long workerId, @PathVariable Integer days){
        return paymentService.getPayment(workerId, days);
    }
}
