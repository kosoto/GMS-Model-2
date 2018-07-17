package repository;

import java.sql.*;
import java.util.*;
import domain.*;
import enums.*;
import factory.*;
import pool.DBConstant;

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
				member.setTeamId(rs.getString("TEAM_ID"));
				member.setName(rs.getString("NAME"));
				member.setAge(rs.getString("AGE"));
				member.setRoll(rs.getString("ROLL"));
				member.setSsn(rs.getString("SSN"));
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*if(countMember() == list.size()) {
			System.out.println("전체 리스트 인원 호출 성공"+list);			
		}
*/
		return list;
	}

	@Override
	public List<MemberBean> findByTeamId(String word) {
		List<MemberBean> list = new ArrayList<>();
		MemberBean member = null;
		try {
			ResultSet rs = DataBaseFactory.createDataBase(Vendor.ORACLE, 
					DBConstant.USER_NAME, DBConstant.PASSWORD)
					.getConnection()
					.createStatement()
					.executeQuery(
							String.format(MemberQuery.FIND_BY_TEAM_ID.toString(),
									word)							
							);
			while(rs.next()) {
				member = new MemberBean();
				member.setMemberId(rs.getString("MEM_ID"));
				member.setTeamId(rs.getString("TEAM_ID"));
				member.setName(rs.getString("NAME"));
				member.setAge(rs.getString("AGE"));
				member.setRoll(rs.getString("ROLL"));
				member.setSsn(rs.getString("SSN"));
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public MemberBean findById(String id) {
		MemberBean member = null;
		try {
			ResultSet rs = DataBaseFactory.createDataBase(Vendor.ORACLE,
					DBConstant.USER_NAME,DBConstant.PASSWORD)
					.getConnection()
					.createStatement()
					.executeQuery(
							String.format(
									MemberQuery.FIND_BY_ID.toString(),
									id)
							);
			while(rs.next()) {
				member = new MemberBean();
				member.setMemberId(rs.getString("MEM_ID"));
				member.setTeamId(rs.getString("TEAM_ID"));
				member.setName(rs.getString("NAME"));
				member.setAge(rs.getString("AGE"));
				member.setRoll(rs.getString("ROLL"));
				member.setSsn(rs.getString("SSN"));
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
									+" PASSWORD "
									+" FROM MEMBER "
									+" WHERE MEM_ID LIKE '%s' "
									+" AND PASSWORD LIKE '%s' "
							,member.getMemberId(),member.getPass()));			
			while(rs.next()) {
				mem = new MemberBean();
				mem.setMemberId(rs.getString("MEMID"));
				mem.setTeamId(rs.getString("TEAMID"));
				mem.setName(rs.getString("NAME"));
				mem.setSsn(rs.getString("SSN"));
				mem.setRoll(rs.getString("ROLL"));
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
								"INSERT INTO MEMBER "
										+ "(MEM_ID, NAME, SSN, PASSWORD, AGE) "
										+ "VALUES "
										+ "('%s','%s','%s','%s','%d')", 
										member.getMemberId(),
										member.getName(),
										member.getSsn(),
										member.getPass(),
										(119-Integer.parseInt(member.getSsn().substring(0, 2)))
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

}








