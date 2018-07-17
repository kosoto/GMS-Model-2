package service;

import java.util.List;
import domain.MemberBean;
import repository.MemberDAOImpl;

public class MemberServiceImpl implements MemberService{
	private static MemberService instance = new MemberServiceImpl();
	private MemberBean session;
	private MemberServiceImpl() {session = new MemberBean();}
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
		String pass = member.getPass().split("/")[0];
		String newPass = member.getPass().split("/")[1];
		if(!pass.equals(newPass)) {
			member.setPass(newPass);
			MemberDAOImpl.getInstance().updateMember(member);
		}
		//이전 비번= 새로운 비번일때 메시지 처리
	}

	@Override
	public void deleteMember(MemberBean member) {
		MemberDAOImpl.getInstance().deleteMember(member);
		
	}
	@Override
	public boolean login(MemberBean member) {
		session =MemberDAOImpl.getInstance().login(member); 
		return (session!=null);
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
