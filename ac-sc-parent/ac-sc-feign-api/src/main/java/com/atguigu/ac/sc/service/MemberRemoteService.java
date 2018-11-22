package com.atguigu.ac.sc.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.atguigu.ac.sc.entities.Member;
import com.atguigu.ac.sc.entities.ResultEntity;

@FeignClient("PortalProvider")
public interface MemberRemoteService {

	@PostMapping("/portal/provider/member/register")
	public ResultEntity<String> doRegisterRemote(@RequestBody Member member);
}
