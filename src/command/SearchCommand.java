package command;

import java.util.*;
import javax.servlet.http.HttpServletRequest;

import proxy.PageProxy;
import proxy.Proxy;
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
			int pageNum = (request.getParameter("pageNum")==null)?
					1:Integer.parseInt(request.getParameter("pageNum")),
				count = MemberServiceImpl.getInstance().countMember(), 
				pageSize = 5, blockSize = 5, 
				beginPage = Math.floorDiv(pageNum-1, pageSize)*pageSize+1, 
				endPage = (count>(beginPage+(blockSize-1))*pageSize)?
						beginPage+(blockSize-1):(int)(Math.ceil(count/(double)pageSize)), 
				beginRow = (pageNum-1)*pageSize+1, 
				endRow = (count>pageNum*pageSize)?pageNum*pageSize:count;
			Map<String,Object>param = new HashMap<>();
			param.put("beginRow", String.valueOf(beginRow));
			param.put("endRow", String.valueOf(endRow));
			members = MemberServiceImpl.getInstance().getList(param);
			boolean existPrev = (beginPage>1)?true:false, exisNext = (count >endPage*5 )?true:false;
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("count", count);
			request.setAttribute("beginPage", beginPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("existPrev", existPrev);
			request.setAttribute("exisNext", exisNext);
		}
		//공통 코딩 영역
		request.setAttribute("list", members);
		super.execute();
	}
}
