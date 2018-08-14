package template;

import java.sql.ResultSet;

import domain.ImageBean;
import domain.MemberBean;
import enums.Domain;
import enums.ImageQuery;
import enums.MemberQuery;

public class RetrieveQuery extends QueryTemplate{

	@Override
	void initialize() {
		switch((Domain)map.get("table")) {
		case MEMBER: 
			map.put("sql", 
					String.format(
							MemberQuery.RETRIEVE.toString(),
							map.get("column"))
					);
			break;
		case IMAGE: 
			map.put("sql", 
					String.format(ImageQuery.RETRIEVE.toString(), 
							map.get("column"))
					);
			break;
		default:
			break;
		}
		
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
			ResultSet rs = pstmt.executeQuery();
			switch((Domain)map.get("table")) {
			case MEMBER:
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
					o = member;
				}
				break;
			case IMAGE:
				ImageBean img = null;
				while(rs.next()) {
					img = new ImageBean();
					img.setExtension(rs.getString("EXTENSION"));
					img.setImgName(rs.getString("IMG_NAME"));
					img.setMemberId(rs.getString("MEM_ID"));
					o = img;
				}
				break;
			default:
				break;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
