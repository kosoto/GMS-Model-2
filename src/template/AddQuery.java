package template;
import enums.Domain;
import enums.ImageQuery;
import enums.MemberQuery;
public class AddQuery extends QueryTemplate{

	@Override
	void initialize() {
		switch((Domain) map.get("table")) {
		case MEMBER: 
			map.put("sql",MemberQuery.INSERT.toString());
			break;
		case IMAGE: 
			map.put("sql", ImageQuery.INSERT.toString());
			break;
		
		default:
			break;
		
		}
		
		
	}

	@Override
	void startPlay() {
		try {
			for(int i=1;i<((String)map.get("sql")).split("\\?").length;i++) {
				pstmt.setString(i, map.get("value"+i).toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	void endPlay() {
		try {
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
