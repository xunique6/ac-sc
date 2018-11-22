package com.atguigu.ac.sc.service;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.atguigu.ac.sc.entities.ResultEntity;

@FeignClient("ActivitiProvider")
public interface ProcessRemoteService {

	@GetMapping("/get/process/definition/list/remote")
	public ResultEntity<List<Map<String,Object>>>   getProcessDefinitionListRemote();
	
}
