package com.jpaul.hrworker.services;

import java.util.List;

import com.jpaul.hrworker.controller.dtos.WorkerDTO;
import com.jpaul.hrworker.entities.Worker;

public interface WorkerService {
	
	List<Worker> findAll();

	WorkerDTO findById(Long id);

}
