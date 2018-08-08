package command;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import proxy.PageProxy;
import proxy.Pagination;
import service.MemberServiceImpl;

public class SearchCommand extends Command{
	public SearchCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, 
				request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
		List<?> members;
		if(!(request.getParameter("option")==null)) {
			//검색리스트 코딩영역
			members = MemberServiceImpl.getInstance().findSome(
					request.getParameter("table")+"/"+
					request.getParameter("option")+"/"+
					request.getParameter("word")); 
		}else {//전체 리스트 코딩 영역
			Map<String,Object>paramMap = new HashMap<>();
			String pageNum = request.getParameter("pageNum");
			PageProxy pxy = new PageProxy();
			pxy.carryOut((pageNum==null)?1:Integer.parseInt(pageNum));
			Pagination page = pxy.getPagination();
			paramMap.put("beginRow", String.valueOf(page.getBeginRow()));
			paramMap.put("endRow", String.valueOf(page.getEndRow()));
			request.setAttribute("page", page);
			members = MemberServiceImpl.getInstance().getList(paramMap);
		}
		//공통 코딩 영역
		request.setAttribute("list", members);
		super.execute();
	}
}
