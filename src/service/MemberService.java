package service;

import java.util.List;
import java.util.Map;

import domain.MemberBean;

public interface MemberService {
	public String createMember(MemberBean member);
	public List<MemberBean> memberList();
	public List<MemberBean> getList(Map<?,?>param);
	public List<MemberBean> findSome(String word);
	public MemberBean findById(String id);
	public int countMember();
	public void updateMember(MemberBean member);
	public void deleteMember(MemberBean member);
	public boolean login(MemberBean member);
	public boolean existId(String id);
}
