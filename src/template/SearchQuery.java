package template;


import java.sql.ResultSet;
import domain.MemberBean;
import enums.MemberQuery;

public class SearchQuery extends QueryTemplate{

	@Override
	void initialize() {
		map.put("sql", 
				(map.get("column")==null)?
					String.format(
							MemberQuery.LIST.toString(), 
							((String)map.get("domain")))
					:
					String.format(
							MemberQuery.SEARCH.toString(),
							((String)map.get("domain")),
							((String)map.get("column")).toUpperCase())
					
				);
	}

	@Override
	void startPlay() {
		try {
			int j = 0;
			if(map.get("column")!=null) {
				j++;
				pstmt.setString(j, 
					"%"+((String)map.get("value"))+"%");
			}
			j++;
			pstmt.setString(j, 
					(String)map.get("beginRow"));
			j++;
			pstmt.setString(j, (String)map.get("endRow"));
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
