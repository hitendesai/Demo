package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Member;

public interface MemberService {
	public Member getMember(int memberId);
	public List<Member> getMembers();
	public int saveMember(Member member);
}
