package service;

import java.util.List;
import java.util.Map;

import domain.MemberBean;
import repository.MemberDAOImpl;

public class MemberServiceImpl implements MemberService{
	private static MemberService instance = new MemberServiceImpl();
	public static MemberService getInstance() {return instance;}
	private MemberServiceImpl() {}
	
	@Override
	public String add(MemberBean member) {
		return MemberDAOImpl.getInstance().insert(member);
	}
	@Override
	public List<MemberBean> search(Map<?, ?> param) {
		return MemberDAOImpl.getInstance().selectSome(param);
	}
	@Override
	public MemberBean retrieve(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int count() {
		return MemberDAOImpl.getInstance().count();
	}
	@Override
	public void modify(Map<?, ?> param) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void remove(MemberBean member) {
		
	}
	@Override
	public boolean login(MemberBean member) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean existId(String id) {
		// TODO Auto-generated method stub
		return false;
	}


}
