package service;

import java.util.List;
import java.util.Map;
import domain.MemberBean;

public interface MemberService {
	public String add(MemberBean member);
	public List<MemberBean> search(Map<?,?>param);
	public MemberBean retrieve(String word);
	public int count();
	public int count(Map<String, Object> paramMap);
	public void modify(Map<?,?>param);
	public void remove(MemberBean member);
	public MemberBean login(MemberBean member);
	public boolean existId(String id);
}
