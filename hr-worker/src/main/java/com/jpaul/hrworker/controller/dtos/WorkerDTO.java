package com.jpaul.hrworker.controller.dtos;

import com.jpaul.hrworker.entities.Worker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkerDTO {

	private Long id;

	private String name;

	private Double dailyIncome;

	public WorkerDTO(Worker worker){
		setId(worker.getId());
		setName(worker.getName());
		setDailyIncome(worker.getDailyIncome());
	}

}
