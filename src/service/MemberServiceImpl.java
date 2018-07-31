package service;

import java.util.List;
import domain.MemberBean;
import repository.MemberDAOImpl;

public class MemberServiceImpl implements MemberService{
	private static MemberService instance = new MemberServiceImpl();
	public static MemberService getInstance() {return instance;}

	

	@Override
	public List<MemberBean> memberList() {
		return MemberDAOImpl.getInstance().memberList();
	}

	@Override
	public List<MemberBean> findByTeamId(String teamId) {
		return MemberDAOImpl.getInstance().findByTeamId(teamId);
	}

	@Override
	public MemberBean findById(String id) {
		return MemberDAOImpl.getInstance().findById(id);
	}

	@Override
	public void updateMember(MemberBean member) {
		MemberDAOImpl.getInstance().updateMember(member);
	}

	@Override
	public void deleteMember(MemberBean member) {
		MemberDAOImpl.getInstance().deleteMember(member);
		
	}
	@Override
	public boolean login(MemberBean member) {
		return ((MemberDAOImpl.getInstance().login(member))!=null);
	}
	@Override
	public String createMember(MemberBean member) {
		return MemberDAOImpl.getInstance().insertMember(member);
		
	}
	@Override
	public boolean existId(String id) {
		return MemberDAOImpl.getInstance().existID(id);
	}
	@Override
	public int countMember() {
		return MemberDAOImpl.getInstance().countMember();
	}

}
