package template;

import java.sql.ResultSet;

import enums.MemberQuery;
public class CountQuery extends QueryTemplate{

	@Override
	void initialize() {
		if(map.get("column")!=null) {
			map.put("sql", 
					String.format(
							MemberQuery.SEARCHED_COUNT.toString(),
							map.get("column").toString()
							)
					
					);
		}else {
			map.put("sql", MemberQuery.COUNT.toString());
		}
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
		number = 0;
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
