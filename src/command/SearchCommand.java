package command;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
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
		String pageNum = request.getParameter("pageNum");
		PageProxy pxy = new PageProxy();
		Pagination page = null;
		System.out.println("서치커맨드 if 밖 option req: "+request.getParameter("option"));
		System.out.println("서치커맨드 if 밖 option session: "+request.getSession().getAttribute("option"));
		if(!(request.getParameter("option")==null)) {
			System.out.println("서치커맨드 if 안 option : "+request.getParameter("option"));
			if(request.getParameter("option").equals("none")) {
				request.getSession().removeAttribute("option");
				request.getSession().removeAttribute("word");
				System.out.println("option = none : "+request.getSession().getAttribute("option"));
				
			}else {
				request.getSession().setAttribute("option", request.getParameter("option"));
				request.getSession().setAttribute("word", request.getParameter("word"));
			}
		}
		
		if(!(request.getSession().getAttribute("option")==null) && !request.getSession().getAttribute("option").equals("none")) {
			//검색리스트 코딩영역
			
			String word = 
					request.getSession().getAttribute("option")+"/"
					+request.getSession().getAttribute("word");
			pxy.carryOut((pageNum==null)?
					"1/"+word:
					pageNum+"/"+word);
			page = pxy.getPagination();
			String[] arr1 = {"domain","beginRow","endRow","column","value"};
			String[] arr2 = {
					Domain.MEMBER.toString(),
					String.valueOf(page.getBeginRow()),
					String.valueOf(page.getEndRow()),
					(String) request.getSession().getAttribute("option"),
					(String) request.getSession().getAttribute("word")
					};
			for(int i =0;i<arr1.length;i++) {
				paramMap.put(arr1[i], arr2[i]);
			}
			
		}else {//전체 리스트 코딩 영역
			pxy.carryOut((pageNum==null)?
					"1":
					pageNum);
			page = pxy.getPagination();
			String[] arr1 = {"domain","beginRow","endRow"};
			String[] arr2 = {
					Domain.MEMBER.toString(),
					String.valueOf(page.getBeginRow()),
					String.valueOf(page.getEndRow())
					};
			for(int i =0;i<arr1.length;i++) {
				paramMap.put(arr1[i], arr2[i]);
			}
		}
		//공통 코딩 영역
		request.setAttribute("page", page);
		members = MemberServiceImpl.getInstance().search(paramMap);
		request.setAttribute("list", members);
		super.execute();
	}
}
