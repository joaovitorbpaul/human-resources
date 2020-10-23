package com.jpaul.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpaul.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
