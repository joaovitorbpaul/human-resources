package com.jpaul.hrpayroll.integrations.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkerResponse {

    private Long id;

    private String name;

    private Double dailyIncome;

}
