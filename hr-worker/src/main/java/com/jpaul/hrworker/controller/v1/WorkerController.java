package com.jpaul.hrworker.controller.v1;

import java.util.List;

import com.jpaul.hrworker.controller.dtos.WorkerDTO;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.jpaul.hrworker.entities.Worker;
import com.jpaul.hrworker.services.WorkerService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(WorkerController.BASE_URL)
@AllArgsConstructor
public class WorkerController {
	
	public static final String BASE_URL = "/workers";
	public static final String WORKER_BY_ID_PATH = "/{id}";

	private final WorkerService workerService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Worker> findAll(){return workerService.findAll();}

	@GetMapping(WORKER_BY_ID_PATH)
	@ResponseStatus(HttpStatus.OK)
	public WorkerDTO findById(@PathVariable Long id){return workerService.findById(id);}
}
