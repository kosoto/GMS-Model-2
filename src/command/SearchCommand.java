package command;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
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
			if(request.getParameter("pageNum")==null) {
				request.setAttribute("pageNum", "1");
			}else {
				request.setAttribute("pageNum", request.getParameter("pageNum"));
			}
			int pageNum = Integer.parseInt(((String) request.getAttribute("pageNum"))), count = MemberServiceImpl.getInstance().countMember();
			request.setAttribute("count", count);
			int pageSize = 5,blockSize = 5, beginPage = ((int)((Integer.parseInt((String) request.getAttribute("pageNum"))-1)/pageSize))*pageSize+1;
			request.setAttribute("beginPage", beginPage);
			//int endPage = (count>(beginPage+(blockSize-1))*pageSize)?beginPage+(blockSize-1):(((count%pageSize==0)?count/pageSize:count/pageSize+1));
			int endPage = (count>(beginPage+(blockSize-1))*pageSize)?beginPage+(blockSize-1):(int)(Math.ceil(count/(double)pageSize));
			request.setAttribute("endPage", endPage);
			Map<String,Object>param = new HashMap<>();
			int beginRow = (pageNum-1)*pageSize+1,endRow= (count>pageNum*pageSize)?pageNum*pageSize:count;
			param.put("beginRow", String.valueOf(beginRow));
			param.put("endRow", String.valueOf(endRow));
			members = MemberServiceImpl.getInstance().getList(param);
			boolean existPrev = (beginPage>1)?true:false;
			request.setAttribute("existPrev", existPrev);
			boolean exisNext = (count >endPage*5 )?true:false;
			request.setAttribute("exisNext", exisNext);
		}
		//공통 코딩 영역
		request.setAttribute("list", members);
		super.execute();
	}
}
