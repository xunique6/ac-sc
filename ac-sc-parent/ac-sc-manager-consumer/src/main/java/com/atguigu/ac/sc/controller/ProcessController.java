package com.atguigu.ac.sc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.atguigu.ac.sc.entities.ResultEntity;
import com.atguigu.ac.sc.service.ProcessRemoteService;
import com.atguigu.ac.sc.utils.ACConst;

@Controller
public class ProcessController {
	
	@Autowired
	private ProcessRemoteService processRemoteService;
	
	@GetMapping("/consumer/process/definition/list")
	public String showProcessDefinitionList(Model model) {
		
		ResultEntity<List<Map<String,Object>>> resultEntity = processRemoteService.getProcessDefinitionListRemote();
		
		if(resultEntity == null) {
			return "error";
		}
		
		String status = resultEntity.getStatus();
		
		if(ResultEntity.SUCCESS.equals(status)) {
			List<Map<String,Object>> processDefinitionList = resultEntity.getData();
			model.addAttribute("processDefinitionList", processDefinitionList);
			return "process/definition_list";
		}else {
			
			model.addAttribute(ACConst.MESSAGE, resultEntity.getResultMessage());
			
			return "error";
		}

	}
	
	@PostMapping("/consumer/process/upload")
	public String  uploadProcessDefinitionFile(@RequestParam("bpnmFile")MultipartFile multipartFile) {
		boolean empty = multipartFile.isEmpty();
		
			System.err.println(empty?"文件没有收到":"文件接收到了！！");
		
		return "main";
	}
	
	
	
	
}
