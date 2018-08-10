package template;

import java.sql.ResultSet;
import enums.MemberQuery;
import factory.DataBaseFactory;

public class CountQuery extends QueryTemplate{

	@Override
	void initialize() {
		map.put("sql", MemberQuery.COUNT.toString());
	}

	@Override
	void startPlay() {
		
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
