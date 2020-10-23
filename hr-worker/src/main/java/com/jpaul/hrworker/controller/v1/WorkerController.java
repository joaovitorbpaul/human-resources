package com.jpaul.hrworker.controller.v1;

import com.jpaul.hrworker.controller.dtos.WorkerDTO;
import com.jpaul.hrworker.entities.Worker;
import com.jpaul.hrworker.services.WorkerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(WorkerController.BASE_URL)
@AllArgsConstructor
public class WorkerController {
	
	public static final String BASE_URL = "/workers";
	public static final String WORKER_BY_ID_PATH = "/{id}";

	private final WorkerService workerService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<WorkerDTO> findAll(){return workerService.findAll();}

	@GetMapping(WORKER_BY_ID_PATH)
	@ResponseStatus(HttpStatus.OK)
	public WorkerDTO findById(@PathVariable Long id){return workerService.findById(id);}
}
