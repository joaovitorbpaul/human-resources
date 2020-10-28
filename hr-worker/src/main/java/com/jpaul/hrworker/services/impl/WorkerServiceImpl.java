package com.jpaul.hrworker.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.jpaul.hrworker.controllers.dtos.WorkerDTO;
import com.jpaul.hrworker.entities.Worker;
import com.jpaul.hrworker.repositories.WorkerRepository;
import com.jpaul.hrworker.services.WorkerService;

import lombok.AllArgsConstructor;

@Slf4j
@Service
@AllArgsConstructor
public class WorkerServiceImpl implements WorkerService {
	
	private WorkerRepository workerRepository;

	@Override
	public List<WorkerDTO> findAll() {
		List<Worker> workers = workerRepository.findAll();
		return workersToWorkersDTO(workers);
	}

	private List<WorkerDTO> workersToWorkersDTO(List<Worker> workers) {
		return workers.stream().map(WorkerDTO::new).collect(Collectors.toList());
	}

	@Override
	public WorkerDTO findById(Long id) {
		Optional<Worker> workerOpt = workerRepository.findById(id);
		workerOpt.orElseThrow(() -> new IllegalArgumentException(String.format("Worker does not exist with id %s", id)));
		log.info("Worker found by id {} with successfully", id);
		return new WorkerDTO(workerOpt.get());
	}

}
