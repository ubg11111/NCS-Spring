package com.khie.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
// Spring에서 일반적으로 DAO 클래스에 적용되는 애노테이션
public class MemberDAOImpl implements MemberDAO{

	@Autowired
	// 자동으로 의존 관계를 설정해 주는 애노테이션.
	// 무조건 객체에 대한 의존을 주입해 주는 애노테이션.
	private JdbcTemplate template;
	
	String sql = null;
	
	
	
	@Override
	// Products  테이블에서 전체 회원 목록을 조회하는 메서드.
	public List<MemberDTO> getMemberList() {
		
		List<MemberDTO> list = null;
		
		sql = "select * from member10 order by num desc";
		
		// RowMapper 자바객체로 변환시켜주는 인터페이스 기능
		return list =  this.template.query(sql, new RowMapper<MemberDTO>() {
			
			@Override
			public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

				MemberDTO dto = new MemberDTO();
				
				dto.setNum(rs.getInt("num"));
				dto.setMemid(rs.getString("memid"));
				dto.setMemname(rs.getString("memname"));
				dto.setPwd(rs.getString("pwd"));
				dto.setAge(rs.getInt("age"));
				dto.setMileage(rs.getInt("mileage"));
				dto.setJob(rs.getString("job"));
				dto.setAddr(rs.getString("addr"));
				dto.setRegdate(rs.getString("regdate"));
				
				return dto;
			}
			
		});
		
	}

	@Override
	// MEMBER10 테이블에 회원을 등록하는 메서드.
	public int insertMember(final MemberDTO dto) {
		
		sql = "select max(num) from member10";
		
		final int count = this.template.queryForInt(sql);
		
		sql = "insert into member10 values(?,?,?,?,?,?,?,?, sysdate)";
		
		return this.template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, count + 1);
				ps.setString(2, dto.getMemid());
				ps.setString(3, dto.getMemname());
				ps.setString(4, dto.getPwd());
				ps.setInt(5, dto.getAge());
				ps.setInt(6, dto.getMileage());
				ps.setString(7, dto.getJob());
				ps.setNString(8, dto.getAddr());
			}
		});
		
	}

	@Override
	public MemberDTO getMember(int num) {
	
		sql = "select * from member10 where num = ?";
		
		return this.template.queryForObject(sql, new RowMapper<MemberDTO>() {

			@Override
			public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				MemberDTO dto = new MemberDTO();
				
				dto.setNum(rs.getInt("num"));
				dto.setMemid(rs.getString("memid"));
				dto.setMemname(rs.getString("memname"));
				dto.setPwd(rs.getString("pwd"));
				dto.setAge(rs.getInt("age"));
				dto.setMileage(rs.getInt("mileage"));
				dto.setJob(rs.getString("job"));
				dto.setAddr(rs.getString("addr"));
				dto.setRegdate(rs.getString("regdate"));
				
				return dto;
			}
			
		}, num);
	
	}

	@Override
	public int updateMember(final MemberDTO dto) {
		
		sql = "update member10 set age = ?, mileage = ?, job = ?, addr = ?"
				+ " where num = ?";
		
		return this.template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				
				ps.setInt(1, dto.getAge());
				ps.setInt(2, dto.getMileage());
				ps.setString(3, dto.getJob());
				ps.setString(4, dto.getAddr());
				ps.setInt(5, dto.getNum());
			}
		});
	
	}

	@Override
	public int deleteMember(final int num) {
		
		sql = "delete from member10 where num = ?";
		
		return this.template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, num);
			}
		});
	}
		
		

	@Override
	public void updateSequence(final int num) {
		
		sql = "update member10 set num = num - 1 where num > ?";
		
		this.template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, num);
			}
		});
	}

	@Override
	public List<MemberDTO> searchMemberList(String field, String keyword) {
		
		List<MemberDTO> searchList = null;
		
		if(field.equals("id")) { // 아이디로 검색한 경우
			
			sql = "select * from member10 "
					+ "where memid like ? order by num desc";
			
			searchList = this.template.query(sql, new RowMapper<MemberDTO>() {
				
				public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
					
					MemberDTO dto = new MemberDTO();
					
					dto.setNum(rs.getInt("num"));
					dto.setMemid(rs.getString("memid"));
					dto.setMemname(rs.getString("memname"));
					dto.setPwd(rs.getString("pwd"));
					dto.setAge(rs.getInt("age"));
					dto.setMileage(rs.getInt("mileage"));
					dto.setJob(rs.getString("job"));
					dto.setAddr(rs.getString("addr"));
					dto.setRegdate(rs.getString("regdate"));
					
					return dto;
					
				}
				
			}, "%"+keyword+"%");
				
		}else if(field.equals("name")) {
			
			sql = "select * from member10 "
					+ "where memname like ? order by num desc";
			
			searchList = this.template.query(sql, new RowMapper<MemberDTO>() {
				
				public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
					
					MemberDTO dto = new MemberDTO();
					
					dto.setNum(rs.getInt("num"));
					dto.setMemid(rs.getString("memid"));
					dto.setMemname(rs.getString("memname"));
					dto.setPwd(rs.getString("pwd"));
					dto.setAge(rs.getInt("age"));
					dto.setMileage(rs.getInt("mileage"));
					dto.setJob(rs.getString("job"));
					dto.setAddr(rs.getString("addr"));
					dto.setRegdate(rs.getString("regdate"));
					
					return dto;
					
				}
				
			}, "%"+keyword+"%");
			
		}// 이름으로 검색한경우
		else if(field.equals("job")) { // 직업으로 검색한경우
			
			sql = "select * from member10 "
					+ "where job like ? order by num desc";
			
			searchList = this.template.query(sql, new RowMapper<MemberDTO>() {
				
				public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
					
					MemberDTO dto = new MemberDTO();
					
					dto.setNum(rs.getInt("num"));
					dto.setMemid(rs.getString("memid"));
					dto.setMemname(rs.getString("memname"));
					dto.setPwd(rs.getString("pwd"));
					dto.setAge(rs.getInt("age"));
					dto.setMileage(rs.getInt("mileage"));
					dto.setJob(rs.getString("job"));
					dto.setAddr(rs.getString("addr"));
					dto.setRegdate(rs.getString("regdate"));
					
					return dto;
					
				}
				
			}, "%"+keyword+"%");
		}
		
		return searchList;
	}
}
