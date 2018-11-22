package com.atguigu.ac.sc.mapper;

import com.atguigu.ac.sc.entities.Member;
import java.util.List;

public interface MemberMapper {
    int deleteByPrimaryKey(Integer memberId);

    int insert(Member record);

    Member selectByPrimaryKey(Integer memberId);

    List<Member> selectAll();

    int updateByPrimaryKey(Member record);

	int selectMemberByLoginAcc(String loginAcc);
}