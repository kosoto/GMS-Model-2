package command;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import enums.Domain;
import proxy.*;
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
		super.execute();
		request.setAttribute("option", request.getParameter("option"));
		request.setAttribute("word", request.getParameter("word"));
		
		Map<String,Object>paramMap = new HashMap<>();
		paramMap.put("column", request.getAttribute("option"));
		paramMap.put("value", request.getAttribute("word"));
		paramMap.put("pageNum", request.getParameter("pageNum"));
		paramMap.put("count", 
				(request.getParameter("option")==null)?
				MemberServiceImpl.getInstance().count():
				MemberServiceImpl.getInstance().count(paramMap));
		PageProxy pxy = new PageProxy();
		pxy.carryOut(paramMap);
		
		Pagination page = pxy.getPagination();
		request.setAttribute("page", page);
		
		String[] 
			 keys = {"domain","beginRow","endRow"},
			 values = {Domain.MEMBER.toString(),
					   String.valueOf(page.getBeginRow()),
					   String.valueOf(page.getEndRow())
					};
		for(int i=0;i<keys.length;i++) {
			paramMap.put(keys[i], values[i]);
		}
		
		request.setAttribute("list", MemberServiceImpl.getInstance().search(paramMap));
	}
}
