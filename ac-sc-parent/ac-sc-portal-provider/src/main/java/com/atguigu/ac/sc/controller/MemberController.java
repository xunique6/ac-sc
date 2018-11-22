package com.atguigu.ac.sc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.ac.sc.entities.Member;
import com.atguigu.ac.sc.entities.ResultEntity;
import com.atguigu.ac.sc.service.MemberService;
import com.atguigu.ac.sc.utils.ACConst;

@RestController
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	
	@PostMapping("/portal/provider/member/register")
	public ResultEntity<String> doRegisterRemote(@RequestBody Member member){
		
		ResultEntity<String> resultEntity = new ResultEntity<>(); 
		
		String loginAcc = member.getLoginAcc();
		
		try {
			int count = memberService.getMemberLoginAcctCount(loginAcc);
			if(count == 0) {
				memberService.save(member);
				resultEntity.setStatus(ResultEntity.SUCCESS);
			}else {
				resultEntity.setStatus(ResultEntity.FAILED);
				resultEntity.setResultMessage(ACConst.MESSAGE_REGISTER_FAILED);
			}
		} catch (Exception e) {
			e.printStackTrace();
			resultEntity.setStatus(ResultEntity.FAILED);
			resultEntity.setResultMessage(e.getMessage());
		}
		return resultEntity;
	}
	
	
	
	@GetMapping("/portal/provider/member/{memberId}")
	 public  ResultEntity<Member>   getMemberById(@PathVariable("memberId") Integer memberId ){
		 Member member = memberService.getById(memberId);
		 ResultEntity<Member> resultEntity = new ResultEntity<>();
		 resultEntity.setData(member);
		 resultEntity.setStatus(ResultEntity.SUCCESS);
		 return  resultEntity;
	 }
}
