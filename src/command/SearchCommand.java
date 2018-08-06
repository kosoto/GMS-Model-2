package command;

import java.util.*;
import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
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
		List<?> members ;
		if(!(request.getParameter("option")==null)) {
			members = MemberServiceImpl.getInstance().findSome(
					request.getParameter("table")+"/"+
					request.getParameter("option")+"/"+
					request.getParameter("word"));
		}else {
			//members = MemberServiceImpl.getInstance().memberList();
		
			request.setAttribute("count", MemberServiceImpl.getInstance().countMember());
			
			int count = (int) request.getAttribute("count");
			int beginPage = 1;
			int endPage = 0;
			if(request.getAttribute("beginPage")==null) {
				request.setAttribute("beginPage", beginPage);
			}else {
				//request.setAttribute("beginPage", request.getAttribute("page"));
				//page로 뷰에서 받아오는 로직 짜기
			}
			
			if(request.getAttribute("endPage")==null) {
				if(MemberServiceImpl.getInstance().countMember()>25){
					request.setAttribute("endPage", "5");
				}else {
					endPage = ((count%5==0)?count/5:count/5+1);
					request.setAttribute("endPage", endPage);
				}
			}else {
				//request.setAttribute("endPage", "");
			}
			Map<String,Object>param = new HashMap<>();
			int beginRow = 1;
			/*endPage = 5;
			int endRow= (count>endPage*5)?endPage*5:count;*/
			int endRow = 5;
			param.put("beginRow", String.valueOf(beginRow));
			param.put("endRow", String.valueOf(endRow));
			members = MemberServiceImpl.getInstance().getList(param);
		}
		
		request.setAttribute("list", members);
		super.execute();
	}
}
