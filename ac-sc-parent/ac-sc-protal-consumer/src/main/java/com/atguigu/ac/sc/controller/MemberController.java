package com.atguigu.ac.sc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.atguigu.ac.sc.entities.Member;
import com.atguigu.ac.sc.entities.ResultEntity;
import com.atguigu.ac.sc.service.MemberRemoteService;
import com.atguigu.ac.sc.utils.ACConst;



@Controller
public class MemberController {
	
	
	@Autowired
	private MemberRemoteService MemberRemoteService;
	
	@PostMapping("/member/doRegister")
	public String  doRegister(Member member ,Model model) {
		
		if(member == null) {
			return "member/reg";
		}
		
		ResultEntity<String> resultEntity = MemberRemoteService.doRegisterRemote(member);
		
		String status = resultEntity.getStatus();
		
		if(ResultEntity.SUCCESS.equals(status)) {
			return "member/login";
		}
		
		if(ResultEntity.FAILED.equals(status)) {
			String message = resultEntity.getResultMessage();
			model.addAttribute(ACConst.MESSAGE, message);
			return "member/reg";
		}
		
		return "member/reg";
	}
	
	

	@GetMapping("/member/toRegPage")
	public String  toRegisterPage() {
		return "member/reg";
	}
}
