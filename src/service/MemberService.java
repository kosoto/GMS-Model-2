package service;

import java.util.List;
import java.util.Map;
import domain.MemberBean;

public interface MemberService {
	public String add(MemberBean member);
	public List<MemberBean> search(Map<?,?>param);
	public MemberBean retrieve(String id);
	public int count();
	public void modify(Map<?,?>param);
	public void remove(MemberBean member);
	public boolean login(MemberBean member);
	public boolean existId(String id);
}
