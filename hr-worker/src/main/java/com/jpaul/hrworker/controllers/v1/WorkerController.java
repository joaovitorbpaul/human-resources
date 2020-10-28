package com.jpaul.hrworker.controllers.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jpaul.hrworker.controllers.dtos.WorkerDTO;
import com.jpaul.hrworker.services.WorkerService;
import com.sun.istack.NotNull;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RefreshScope
@RestController
@RequestMapping(WorkerController.BASE_URL)
@RequiredArgsConstructor
public class WorkerController {

	public static final String BASE_URL = "/workers";
	public static final String WORKER_BY_ID_PATH = "/{id}";
	
	@Value("${test.config}")
	private String testConfig;

	@NotNull
	private final Environment env;

	@NotNull
	private final WorkerService workerService;
	
	@GetMapping("/configs")
	@ResponseStatus(HttpStatus.OK)
	public void getConfigs() {
		log.debug("CONFIG = " + testConfig);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<WorkerDTO> findAll() {
		log.debug("PORT = " + env.getProperty("local.server.port"));
		return workerService.findAll();
	}

	@GetMapping(WORKER_BY_ID_PATH)
	@ResponseStatus(HttpStatus.OK)
	public WorkerDTO findById(@PathVariable Long id) {
		log.debug("PORT = " + env.getProperty("local.server.port"));
		return workerService.findById(id);
	}
}
