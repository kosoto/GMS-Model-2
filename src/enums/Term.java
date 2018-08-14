package enums;

public enum Term {
	WEBPATH, MAIN, RESOURCES, CONTEXT,
	UPLOAD_PATH;
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
		case UPLOAD_PATH : 
			res = "C:/Users/1027/eclipse/jee-oxygen/eclipse/Workspace2/GMS-Model2/WebContent/resources/img/upload/";
			break;
		default :break;
		}
		return res;
	}
}
