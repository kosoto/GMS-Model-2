package command;

import javax.servlet.http.HttpServletRequest;
public class ParamMap {
	public static String getValues(HttpServletRequest request,String name) {
		String[] values = request.getParameterMap().get(name);
		StringBuffer buffer = new StringBuffer();
		for(String s : values) {
			buffer.append(s+","); //문자를 붙이는거 , 는 split용
		}
		return buffer.toString().substring(0,buffer.toString().length()-1);
	}
}
