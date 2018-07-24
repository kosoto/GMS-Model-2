package enums;

public enum Domain {
	MEMBER,EXAM,PROJECTTEAM,RECODE,SUBJECT,CONTEXT;
	@Override
	public String toString() {
		String res = "";
		switch(this) {
		case CONTEXT : 
			res = "context";
			break;
		default:
			break;
		}
		return res;
	}
}
