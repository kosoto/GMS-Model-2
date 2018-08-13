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
		List<?> members = null;
		Map<String,Object>paramMap = new HashMap<>();
		String pageNum = request.getParameter("pageNum");
		PageProxy pxy = new PageProxy();
		Pagination page = null;
		String ar1,ar2;
		
		if(!(request.getParameter("option")==null)) {
			if(request.getParameter("option").equals("none")) {
				request.getSession().removeAttribute("option");
			}else {
				request.getSession().setAttribute("option", request.getParameter("option"));
				request.getSession().setAttribute("word", request.getParameter("word"));
			}
		}
		
		if(!(request.getSession().getAttribute("option")==null)) {
			String word = 
					request.getSession().getAttribute("option")+"/"
					+request.getSession().getAttribute("word");
			pxy.carryOut((pageNum==null)?
					"1/"+word:
					pageNum+"/"+word);
			page = pxy.getPagination();
			ar1 = "domain/beginRow/endRow/column/value";
			ar2 = 
				Domain.MEMBER.toString()+"/"
				+String.valueOf(page.getBeginRow())+"/"
				+String.valueOf(page.getEndRow())+"/"
				+(String) request.getSession().getAttribute("option")+"/"
				+(String) request.getSession().getAttribute("word");
		}else {
			pxy.carryOut((pageNum==null)?
					"1":
					pageNum);
			page = pxy.getPagination();
			ar1 = "domain/beginRow/endRow";
			ar2 = 
				Domain.MEMBER.toString()+"/"
				+String.valueOf(page.getBeginRow())+"/"
				+String.valueOf(page.getEndRow());
		}
		String[] arr1 = ar1.split("/"), 
				 arr2 = ar2.split("/");
		for(int i=0;i<arr1.length;i++) {
			paramMap.put(arr1[i], arr2[i]);
		}
		request.setAttribute("page", page);
		members = MemberServiceImpl.getInstance().search(paramMap);
		request.setAttribute("list", members);
		super.execute();
	}
}
