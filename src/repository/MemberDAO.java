package repository;

import java.util.List;
import java.util.Map;

import domain.MemberBean;

public interface MemberDAO {
	public String insert(MemberBean member);
	public List<MemberBean> selectSome(Map<?,?>param);
	public MemberBean selectOne(String word);
	public int count();
	public int count(String word);
	public void update(Map<?,?>param);
	public void delete(MemberBean member);
	public MemberBean login(MemberBean member);
	public boolean existID(String id);
}
