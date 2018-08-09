package enums;

public enum Term {
	WEBPATH, MAIN, RESOURCES,CONTEXT;
	@Override
	public String toString() {
		String res = "";
		switch(this) {
		case CONTEXT : 
			res = "context";
			break;
		case WEBPATH: 
			res = "/WEB-INF/view/";
			break;
		case MAIN: 
			res = "/main.jsp";
			break;
		case RESOURCES: 
			res = "/resources/";
			break;
		default :break;
		}
		return res;
	}
}
