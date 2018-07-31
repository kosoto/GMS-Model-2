package repository;

import java.util.List;

import domain.MemberBean;

public interface MemberDAO {
	public String insertMember(MemberBean member);
	public List<MemberBean> memberList();
	public List<MemberBean> findByTeamId(String word);
	public MemberBean findById(String word);
	public int countMember();
	public void updateMember(MemberBean member);
	public void deleteMember(MemberBean member);
	public MemberBean login(MemberBean member);
	public boolean existID(String id);
}
