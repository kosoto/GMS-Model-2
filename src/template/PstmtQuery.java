package template;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.MemberBean;
import enums.Domain;
import factory.DataBaseFactory;

public class PstmtQuery extends QueryTemplate{

	@Override
	void initialize() {
		map.put("sql",String.format(
				" SELECT "
				+ ColumnFinder.find(Domain.MEMBER)
				+ " FROM %s "
				+ " WHERE %s "
				+ " LIKE ? ",
				map.get("table"),
				map.get("column"))
				);
	}

	@Override
	void startPlay() {
		System.out.println(map.get("table"));
		System.out.println(map.get("column"));
		try {
			pstmt = DataBaseFactory
					.createDataBase2(map)
					.getConnection()
					.prepareStatement((String) map.get("sql"));
			pstmt.setString(1, //index 는 1부터
					"%"+map.get("value").toString()+"%s");
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
