package com.jpaul.hrpayroll.controllers.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {

    private String name;

    private Double dailyIncome;

    private Integer days;

    private Double total;

}
