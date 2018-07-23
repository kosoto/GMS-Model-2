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
		System.out.println("도메인 :"+getDomain());
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
		System.out.println("검색 커맨드 진입");
		System.out.println("팀 아이디 :"+request.getParameter("team_id"));
		List<MemberBean> members = new ArrayList<>();
		if(!(request.getParameter("team_id")==null)) {
			members = MemberServiceImpl.getInstance().findByTeamId(
					request.getParameter("team_id"));
			System.out.println("팀 검색 성공");
		}else {
			members = MemberServiceImpl.getInstance().memberList();
			System.out.println("전체 검색 성공");
		}
		System.out.println(members);
		request.setAttribute("list", members);
		super.execute();
	}
}
