package com.jpaul.hrworker.services.impl;

import java.util.List;
import java.util.Optional;

import com.jpaul.hrworker.controller.dtos.WorkerDTO;
import org.springframework.stereotype.Service;

import com.jpaul.hrworker.entities.Worker;
import com.jpaul.hrworker.repositories.WorkerRepository;
import com.jpaul.hrworker.services.WorkerService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class WorkerServiceImpl implements WorkerService {
	
	private WorkerRepository workerRepository;

	@Override
	public List<Worker> findAll() {
		return workerRepository.findAll();
	}

	@Override
	public WorkerDTO findById(Long id) {
		Optional<Worker> workerOpt = workerRepository.findById(id);
		workerOpt.orElseThrow(() -> new IllegalArgumentException(String.format("Worker does not exist with id %s", id)));
		return new WorkerDTO(workerOpt.get());
	}

}
