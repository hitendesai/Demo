package com.example.demo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Member;

@Repository
public class MemberRepoImpl implements MemberRepo {

	@Autowired
	private NamedParameterJdbcTemplate template;

	@Override
	public Member getMember(int memberId) {
		String sql = "select * from member where member_uid = :member_uid";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("member_uid", memberId);
		return (Member)template.queryForObject(sql, paramMap, new MemberRowMapper());
	}

	@Override
	public List<Member> getMembers() {
		String sql = "select * from member";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		return template.query(sql, paramMap, new MemberRowMapper());
	}

	@Override
	public int saveMember(Member member) {
		String sql = "insert into member (last_name, first_name, member_cancel_reason) values(:last, :first, :reason)";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("last", member.getLastName());
		paramSource.addValue("first", member.getFirstName());
		paramSource.addValue("reason", member.getCancelReason());
		template.update(sql, paramSource);

		sql = "select @@identity()";
		paramSource = new MapSqlParameterSource();
		return template.queryForObject(sql, paramSource, int.class);
	}


	public class MemberRowMapper implements RowMapper<Member> {
		public Member mapRow(ResultSet rs, int index) throws SQLException {
			Member member = new Member();
			member.setMemberId(rs.getInt("member_uid"));
			member.setLastName(rs.getString("last_name"));
			member.setFirstName(rs.getString("first_name"));
			member.setCancelReason(rs.getString("member_cancel_reason"));
			member.setSsn(rs.getString("ssn"));
			return member;
		}
	}

}