package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;

@RestController
public class MemberController {

	@Autowired
	MemberService service;

	@RequestMapping(value = "/memberlog/member/{memberId}", produces="application/json")
	public Member getMemberInfo(@PathVariable int memberId) {
		return service.getMember(memberId);
	}

	@RequestMapping(value = "/memberinfo/members", produces="application/json")
	public List<Member> getMembers() {
		return service.getMembers();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/memberlog/member/add")
	public int saveMember(@RequestBody Member member) {
		return service.saveMember(member);
	}

}