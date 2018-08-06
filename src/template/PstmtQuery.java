package template;

import java.sql.ResultSet;

import domain.MemberBean;
import enums.Domain;
import factory.DataBaseFactory;

public class PstmtQuery extends QueryTemplate{

	@Override
	void initialize() {
		switch((String) map.get("switch")) {
		case "find":
			map.put("sql",String.format(
					" SELECT "
					+ "*" 
					//+ ColumnFinder.find(Domain.MEMBER)
					+ " FROM %s "
					+ " WHERE %s "
					+ " LIKE ? ",
					map.get("table"),
					map.get("column"))
					); 
			break;
		case "list": 
			map.put("sql", String.format(
					"SELECT T.* "
					+"FROM (SELECT ROWNUM SEQ, M.* "
					+"FROM %s M "
					+"ORDER BY SEQ DESC) T "
					+"WHERE T.SEQ BETWEEN %s AND %s ", 
					map.get("table"),
					map.get("beginRow"),
					map.get("endRow")));
			break;
		}
		
	}

	@Override
	void startPlay() {
		try {
			pstmt = DataBaseFactory.createDataBase2(map).getConnection()
					.prepareStatement((String) map.get("sql"));
			int temp = ((String) map.get("sql")).indexOf("?");
			System.out.println("템플릿 "+temp);
			if(temp != -1) {
				pstmt.setString(1, //index 는 1부터
						"%"+map.get("value").toString()+"%");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	void endPlay() {
		try {
			ResultSet rs = pstmt.executeQuery();
			MemberBean member = null;
			while(rs.next()) {
				member = new MemberBean();
				member.setMemberId(rs.getString("MEM_ID"));
				member.setPass(rs.getString("PASSWORD"));
				member.setTeamId(rs.getString("TEAM_ID"));
				member.setName(rs.getString("NAME"));
				member.setGender(rs.getString("GENDER"));
				member.setAge(rs.getString("AGE"));
				member.setRoll(rs.getString("ROLL"));
				member.setSsn(rs.getString("SSN"));
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
