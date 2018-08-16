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
		boolean nullCheck = request.getParameter("option")!=null;
		request.setAttribute("option", (nullCheck)?request.getParameter("option"):"none");
		request.setAttribute("word", (nullCheck)?request.getParameter("word"):"none");
		boolean noneCheck = request.getAttribute("option").equals("none");
		PageProxy pxy = new PageProxy();
		String pageNum = request.getParameter("pageNum"); 
		pxy.carryOut(
				((pageNum==null)?
						"1/"
						:pageNum+"/")
				+((noneCheck)?
						MemberServiceImpl.getInstance().count()
						:MemberServiceImpl.getInstance().count(
									request.getAttribute("option")+"/"
									+request.getAttribute("word"))
				 )
		);
		
		Pagination page = pxy.getPagination();
		String[] 
			keys = ("domain/beginRow/endRow"
					+((noneCheck)?
					  ""
					  :"/column/value")
					)
				.split("/"), 
			 values = (Domain.MEMBER.toString()+"/"
						+String.valueOf(page.getBeginRow())+"/"
						+String.valueOf(page.getEndRow())
						+((noneCheck)?
						""
						:"/"+((String) request.getAttribute("option"))
						+"/"+((String) request.getAttribute("word")))
					)
			 	.split("/");
		
		Map<String,Object>paramMap = new HashMap<>();
		for(int i=0;i<keys.length;i++) {
			paramMap.put(keys[i], values[i]);
		}
		
		request.setAttribute("page", page);
		request.setAttribute("list", MemberServiceImpl.getInstance().search(paramMap));
	}
}
