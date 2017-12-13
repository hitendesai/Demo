package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Member;

public interface MemberRepo {
	public List<Member> getMembers();
	public Member getMember(int memberId);
	public int saveMember(Member member);
}
