package com.jpaul.hrpayroll.controllers.v1;

import com.jpaul.hrpayroll.entities.Payment;
import com.jpaul.hrpayroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

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


//    @HystrixCommand(fallbackMethod = "getPaymentByWorkerAlternative")
    @GetMapping(WORKER_ID_DAYS_DAYS_PATH)
    @ResponseStatus(HttpStatus.OK)
    public Payment getPaymentByWorker(@PathVariable Long workerId, @PathVariable Integer days){
        return new PaymentDTO(paymentService.getPayment(workerId, days));
    }
    
}
