package com.atguigu.ac.sc.service;

import java.util.List;

import com.atguigu.ac.sc.entities.Member;

public interface MemberService {

	int removeById(Integer memberId);

	int save(Member record);

	Member getById(Integer memberId);

	List<Member> getAll();

	int updateById(Member record);

	int getMemberLoginAcctCount(String loginAcc);
}
