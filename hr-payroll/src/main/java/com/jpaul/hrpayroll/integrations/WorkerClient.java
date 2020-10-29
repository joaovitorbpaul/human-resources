package com.jpaul.hrpayroll.integrations;

import com.jpaul.hrpayroll.integrations.dtos.WorkerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "hr-worker", path = "${hr-worker.contextPath.path}")
public interface WorkerClient {

    @GetMapping("/{id}")
    WorkerResponse findById(@PathVariable Long id);

}
