package template;
import java.sql.ResultSet;

import domain.MemberBean;
import enums.MemberQuery;

public class LoginQuery extends QueryTemplate{

	@Override
	void initialize() {
		map.put("sql", MemberQuery.LOGIN.toString());
		
	}

	@Override
	void startPlay() {
		try {
			pstmt.setString(1, (String) map.get("memid"));
			pstmt.setString(2, (String) map.get("pass"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	void endPlay() {
		try {
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberBean member = new MemberBean();
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
