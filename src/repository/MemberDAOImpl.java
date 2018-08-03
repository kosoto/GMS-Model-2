package repository;

import java.sql.*;
import java.util.*;
import domain.*;
import enums.*;
import factory.*;
import pool.DBConstant;
import template.PstmtQuery;
import template.QueryTemplate;

public class MemberDAOImpl implements MemberDAO{
	private static MemberDAO instance = new MemberDAOImpl();

	public static MemberDAO getInstance() {return instance;}
	private MemberDAOImpl() {}
	

	@Override
	public List<MemberBean> memberList() {
		List<MemberBean> list = new ArrayList<>();
		MemberBean member = null;
		try {
			ResultSet rs = 
					DataBaseFactory.createDataBase(Vendor.ORACLE,
					DBConstant.USER_NAME, DBConstant.PASSWORD)
					.getConnection()
					.createStatement()
					.executeQuery(MemberQuery.MEMBER_LIST.toString());
			while(rs.next()) {
				member = new MemberBean();
				member.setMemberId(rs.getString("MEM_ID"));
				member.setPass(rs.getString("PASSWORD"));
				member.setTeamId(rs.getString("TEAM_ID"));
				member.setName(rs.getString("NAME"));
				member.setAge(rs.getString("AGE"));
				member.setRoll(rs.getString("ROLL"));
				member.setSsn(rs.getString("SSN"));
				member.setGender(rs.getString("GENDER"));
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public MemberBean findById(String word) {
		MemberBean member = null;
		try {
			ResultSet rs = DataBaseFactory.createDataBase(Vendor.ORACLE,
					DBConstant.USER_NAME,DBConstant.PASSWORD)
					.getConnection()
					.createStatement()
					.executeQuery(
						/*	String.format(
									MemberQuery.FIND_BY_ID.toString(),
									id)*/
							//SelectQuery.select(word.split("/")[0], word.split("/")[1], word.split("/")[2])
							QueryFactory.createQuery(
									Vendor.SELECT, 
									word.split("/")[0],
									word.split("/")[1], 
									word.split("/")[2]).getQuery()
							);
			while(rs.next()) {
				member = new MemberBean();
				member.setMemberId(rs.getString("MEM_ID"));
				member.setPass(rs.getString("PASSWORD"));
				member.setTeamId(rs.getString("TEAM_ID"));
				member.setName(rs.getString("NAME"));
				member.setAge(rs.getString("AGE"));
				member.setRoll(rs.getString("ROLL"));
				member.setSsn(rs.getString("SSN"));
				member.setGender(rs.getString("GENDER"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return member;
	}

	@Override
	public void updateMember(MemberBean member) {
		try {
			DataBaseFactory.createDataBase(Vendor.ORACLE, 
					DBConstant.USER_NAME, DBConstant.PASSWORD)
			.getConnection()
			.createStatement()
			.executeUpdate(
					String.format(
							MemberQuery.UPDATE_MEMBER.toString(), 
							member.getPass(),
							member.getTeamId().toUpperCase(),
							member.getRoll(),
							member.getMemberId())
					);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 성공 실패 여부
	}

	@Override
	public void deleteMember(MemberBean member) {
		try {
			DataBaseFactory.createDataBase(Vendor.ORACLE, 
					DBConstant.USER_NAME, DBConstant.PASSWORD)
			.getConnection()
			.createStatement()
			.executeUpdate(
					String.format(
							MemberQuery.DELETE_MEMBER.toString(), 
							member.getMemberId(),
							member.getPass())
					);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public MemberBean login(MemberBean member) {
		MemberBean mem = null;
		try {
			ResultSet rs = DataBaseFactory.createDataBase(
					Vendor.ORACLE,
					DBConstant.USER_NAME,
					DBConstant.PASSWORD)
					.getConnection()
					.createStatement().executeQuery(String.format(
							"SELECT MEM_ID MEMID, "
									+" TEAM_ID TEAMID, "
									+" NAME, "
									+" SSN, "
									+" ROLL, "
									+" PASSWORD, "
									+" GENDER, "
									+" AGE "
									+" FROM MEMBER "
									+" WHERE MEM_ID LIKE '%s' "
									+" AND PASSWORD LIKE '%s' "
							,member.getMemberId(),member.getPass()));			
			while(rs.next()) {
				mem = new MemberBean();
				mem.setMemberId(rs.getString("MEMID"));
				mem.setPass(rs.getString("PASSWORD"));
				mem.setTeamId(rs.getString("TEAMID"));
				mem.setGender(rs.getString("GENDER"));
				mem.setName(rs.getString("NAME"));
				mem.setSsn(rs.getString("SSN"));
				mem.setRoll(rs.getString("ROLL"));
				mem.setAge(rs.getString("AGE"));
			}				
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		return mem;
	}
	@Override
	public String insertMember(MemberBean member) {
		String result = "";
		if(!existID(member.getMemberId())) {
			try {
				DataBaseFactory.createDataBase(
						Vendor.ORACLE,
						DBConstant.USER_NAME,
						DBConstant.PASSWORD)
						.getConnection()
						.createStatement()
						.executeUpdate(
								String.format(
								MemberQuery.INSERT_MEMBER.toString(), 
										member.getMemberId().toUpperCase(),
										member.getName(),
										member.getSsn(),
										member.getPass(),
										member.getAge(),
										member.getGender(),
										member.getRoll(),
										member.getTeamId().toUpperCase()
										));
					
			} catch (Exception e) {
				e.printStackTrace();
			}
			result = "등록성공";
		}else{
			result = "아이디가 이미 있습니다.";
		}
		
		return result;
		
	}
	@Override
	public boolean existID(String id) {
		boolean flag = false;
		try {
			flag = DataBaseFactory.createDataBase(
					Vendor.ORACLE, 
					DBConstant.USER_NAME, 
					DBConstant.PASSWORD)
			.getConnection()
			.createStatement()
			.executeQuery(String.format(
					MemberQuery.EXIST_ID.toString(),
					id
					)
			).next();
			//flag = (rs.next());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	@Override
	public int countMember() {
		int count = 0;
		try {
			ResultSet rs = DataBaseFactory.createDataBase(
					Vendor.ORACLE,
					DBConstant.USER_NAME, 
					DBConstant.PASSWORD)
			.getConnection()
			.createStatement()
			.executeQuery(MemberQuery.COUNT_MEMBER.toString());
			while(rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	@Override
	public List<MemberBean> findSome(String word) {
		QueryTemplate q = new PstmtQuery();
		List<MemberBean> list = new ArrayList<>();
		HashMap<String, Object> map = new HashMap<>();
		map.put("column", word.split("/")[0]);
		map.put("value", word.split("/")[1]);
		map.put("table", Domain.MEMBER);
		q.play(map);
		for(Object s: q.getList()) {
			list.add((MemberBean) s);
		}
		return list;
	}

}








