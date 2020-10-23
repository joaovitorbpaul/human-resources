package com.jpaul.hrworker.services;

import com.jpaul.hrworker.controller.dtos.WorkerDTO;

import java.util.List;

public interface WorkerService {
	
	List<WorkerDTO> findAll();

	WorkerDTO findById(Long id);

}
