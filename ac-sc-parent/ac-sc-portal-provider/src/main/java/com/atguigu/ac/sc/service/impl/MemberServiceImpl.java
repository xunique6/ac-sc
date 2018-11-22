package com.atguigu.ac.sc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.ac.sc.entities.Member;
import com.atguigu.ac.sc.mapper.MemberMapper;
import com.atguigu.ac.sc.service.MemberService;
import com.atguigu.ac.sc.utils.StringUtils;

@Service
@Transactional(readOnly=true)
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper memberMapper;
	
	@Transactional(readOnly=false,rollbackFor=Exception.class,propagation=Propagation.REQUIRES_NEW)
	@Override
	public int removeById(Integer memberId) {
		// TODO Auto-generated method stub
		return memberMapper.deleteByPrimaryKey(memberId);
	}
	@Transactional(readOnly=false,rollbackFor=Exception.class,propagation=Propagation.REQUIRES_NEW)
	@Override
	public int save(Member record) {
		String loginPwd = record.getLoginPwd();
		String md5 = StringUtils.md5(loginPwd);
		record.setLoginPwd(md5);
		return memberMapper.insert(record);
	}

	@Override
	public Member getById(Integer memberId) {
		// TODO Auto-generated method stub
		return memberMapper.selectByPrimaryKey(memberId);
	}

	@Override
	public List<Member> getAll() {
		// TODO Auto-generated method stub
		return memberMapper.selectAll();
	}
	@Transactional(readOnly=false,rollbackFor=Exception.class,propagation=Propagation.REQUIRES_NEW)
	@Override
	public int updateById(Member record) {
		// TODO Auto-generated method stub
		return memberMapper.updateByPrimaryKey(record);
	}
	@Override
	public int getMemberLoginAcctCount(String loginAcc) {
		int count = memberMapper.selectMemberByLoginAcc(loginAcc);
		return count;
	}

}
