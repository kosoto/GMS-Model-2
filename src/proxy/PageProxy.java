package proxy;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import lombok.Data;
@Data
public class PageProxy implements Proxy{
	private Pagination pagination;
	private HttpServletRequest request;
	
	@Override
	public Map<?, ?> carryOut(Map<?, ?> param) {
		Map<String,Object> map = new HashMap<>();
		request = (HttpServletRequest) param.get("request");
		/*request.setAttribute("count", count);
		request.setAttribute("existPrev", existPrev);
		request.setAttribute("exisNext", exisNext);
		request.setAttribute("beginPage", beginPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("page", page);*/
		map.put("request", request);
		
		return map;
	}


}
