package template;

import java.sql.ResultSet;

import enums.MemberQuery;
public class CountQuery extends QueryTemplate{

	@Override
	void initialize() {
		map.put("sql", 
				(map.get("column")!=null)?
				String.format(
				MemberQuery.SEARCHED_COUNT.toString(),
				map.get("column").toString())
				:MemberQuery.COUNT.toString());
	}

	@Override
	void startPlay() {
		if(map.get("column")!=null) {
			try {
				pstmt.setString(1, 
						"%"+(String) map.get("value")+"%");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	void endPlay() {
		try {
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				number = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
