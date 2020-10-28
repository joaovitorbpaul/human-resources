package com.jpaul.hrworker.services;

import java.util.List;

import com.jpaul.hrworker.controllers.dtos.WorkerDTO;

public interface WorkerService {
	
	List<WorkerDTO> findAll();

	WorkerDTO findById(Long id);

}
