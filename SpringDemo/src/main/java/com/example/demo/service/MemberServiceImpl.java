package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepo;


@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepo memberRepo;

	@Override
	public Member getMember(int memberId) {
		return memberRepo.getMember(memberId);
	}

	@Override
	public List<Member> getMembers() {
		return memberRepo.getMembers();
	}

	@Override
	public int saveMember(Member member) {
		return memberRepo.saveMember(member);
	}

}