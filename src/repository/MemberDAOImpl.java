package repository;

import java.sql.ResultSet;
import java.util.*;


import domain.*;
import enums.*;
import factory.DataBaseFactory;
import pool.DBConstant;
import template.*;

public class MemberDAOImpl implements MemberDAO{
	private static MemberDAO instance = new MemberDAOImpl();
	public static MemberDAO getInstance() {return instance;}
	private MemberDAOImpl() {}
	
	@Override
	public MemberBean selectOne(String word) {
		
		return null;
	}

	@Override
	public void update(Map<?,?>param) {
		
	}

	@Override
	public void deleteMember(MemberBean member) {
	
	}
	
	@Override
	public MemberBean login(MemberBean member) {
		MemberBean mem = null;
		return mem;
	}
	@Override
	public String insert(MemberBean member) {
		String result = "";
		QueryTemplate q = new PstmtQuery();
		HashMap<String, Object>map = new HashMap<>();
		map.put("table", Domain.MEMBER);
		map.put("switch","insert");
		map.put("memid", member.getMemberId());
		map.put("name", member.getName());
		map.put("pass", member.getPass());
		map.put("ssn", member.getSsn());
		map.put("age", member.getAge());
		map.put("gender", member.getGender());
		map.put("roll", member.getRoll());
		map.put("teamid", member.getTeamId());
		q.play(map);
		return result;
		
	}
	@Override
	public boolean existID(String id) {
		boolean flag = false;
		return flag;
	}
	@Override
	public int count() {
		int count = 0;
		try {
			ResultSet rs = DataBaseFactory.createDataBase(
					Vendor.ORACLE,
					DBConstant.USER_NAME, 
					DBConstant.PASSWORD)
			.getConnection()
			.createStatement()
			.executeQuery(MemberQuery.COUNT.toString());
			while(rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	@Override
	public List<MemberBean> selectSome(Map<?, ?> param) {
		List<MemberBean> list = new ArrayList<>();
		QueryTemplate q = new PstmtQuery();
		HashMap<String, Object> map = new HashMap<>();
		map.put("table", Domain.MEMBER);
		map.put("value1", (String) param.get("beginRow"));
		map.put("value2", (String) param.get("endRow"));
		map.put("switch", "list");
		q.play(map);
		for(Object s : q.getList()) {
			list.add((MemberBean) s);
		}
		return list;
	}

}








