package com.atguigu.ac.sc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.ac.sc.entities.ResultEntity;

@RestController
public class ProcessContoller {
	
	@Autowired
	private RepositoryService repositoryService;
	
	@GetMapping("/get/process/definition/list/remote")
	public ResultEntity<List<Map<String,Object>>>   getProcessDefinitionListRemote(){
		
		ResultEntity<List<Map<String,Object>>> resultEntity = new ResultEntity<>();
		
		try {
			List<Map<String,Object>> processDefinitionMapList = new ArrayList<>();
			
			List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().list();
			
			for (ProcessDefinition processDefinition : list) {
				Map<String,Object> map = new HashMap<>();
				String id = processDefinition.getId();
				int version = processDefinition.getVersion();
				String name = processDefinition.getName();
				String key = processDefinition.getKey();
				map.put("id", id);
				map.put("key", key);
				map.put("name", name);
				map.put("version", version);
				processDefinitionMapList.add(map);
			}
			    resultEntity.setData(processDefinitionMapList);
			    resultEntity.setStatus(ResultEntity.SUCCESS);
			
		} catch (Exception e) {
			e.printStackTrace();
			resultEntity.setStatus(ResultEntity.FAILED);
			resultEntity.setResultMessage(e.getMessage());
		}
		
		return resultEntity;
				
	}
}
