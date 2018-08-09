package template;

import java.sql.ResultSet;
import domain.MemberBean;
import enums.MemberQuery;
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
			map.put("sql", MemberQuery.LIST.toString());
			break;
		case "insert": 
			map.put("sql", String.format(
					 "INSERT INTO %s "
					+ "(MEM_ID, NAME, SSN, PASSWORD, AGE, "
					+ "GENDER, ROLL, TEAM_ID) "
					+ "VALUES "
					+ "('%s','%s','%s','%s','%s', "
					+ "'%s', '%s', '%s')",
					map.get("domain"),
					map.get("memid"),
					map.get("name"),
					map.get("pass"),
					map.get("ssn"),
					map.get("age"),
					map.get("gender"),
					map.get("roll"),
					map.get("teamid")
					)
					);
			break;
		}
	}

	@Override
	void startPlay() {
		try {
			pstmt = DataBaseFactory.createDataBase2(map).getConnection()
					.prepareStatement((String) map.get("sql"));
			/*int temp = ((String) map.get("sql")).indexOf("?");
			if(temp != -1) {
				pstmt.setString(1, //index 는 1부터
						"%"+map.get("value").toString()+"%");
			}*/
			int size = (((String)map.get("sql")).split("\\?")).length;
			for(int i = 1;i<size;i++) {
				pstmt.setString(i, map.get("value"+i).toString());
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
