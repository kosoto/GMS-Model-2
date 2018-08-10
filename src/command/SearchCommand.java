package command;

import java.util.*;
import javax.servlet.http.HttpServletRequest;

import enums.Action;
import enums.Domain;
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
		List<?> members = null;
		Map<String,Object>paramMap = new HashMap<>();
		if(!(request.getParameter("option")==null)) {
			//검색리스트 코딩영역
		/*	members = MemberServiceImpl.getInstance().findSome(
					request.getParameter("table")+"/"+
					request.getParameter("option")+"/"+
					request.getParameter("word")); */
		}else {//전체 리스트 코딩 영역
			
			String pageNum = request.getParameter("pageNum");
			PageProxy pxy = new PageProxy();
			pxy.carryOut((pageNum==null)?
					1:
					Integer.parseInt(pageNum));
			Pagination page = pxy.getPagination();
			String[] arr1 = {"domain","beginRow","endRow"};
			String[] arr2 = {
					Domain.MEMBER.toString(),
					String.valueOf(page.getBeginRow()),
					String.valueOf(page.getEndRow())
					};
			String a = "a";
			a.toString();
			for(int i =0;i<arr1.length;i++) {
				paramMap.put(arr1[i], arr2[i]);
			}
			/*paramMap.put("domain", Domain.MEMBER);
			paramMap.put("beginRow", String.valueOf(page.getBeginRow()));
			paramMap.put("endRow", String.valueOf(page.getEndRow()));*/
			request.setAttribute("page", page);
			members = MemberServiceImpl.getInstance().search(paramMap);
		}
		//공통 코딩 영역
		request.setAttribute("list", members);
		super.execute();
	}
}
