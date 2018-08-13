package template;

import java.sql.ResultSet;
import domain.MemberBean;
import enums.MemberQuery;

public class RetrieveQuery extends QueryTemplate{

	@Override
	void initialize() {
		map.put("sql", 
				String.format(
						MemberQuery.RETRIEVE.toString(),
						map.get("column"))
				);
	}

	@Override
	void startPlay() {
		try {
			pstmt.setString(1, (String) map.get("value"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	void endPlay() {
		try {
			MemberBean member = null;
			ResultSet rs = pstmt.executeQuery();
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
				o = member;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
