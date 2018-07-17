package service;

import java.util.List;

import domain.SubjectBean;

public class SubjectServiceImpl implements SubjectService{
	private static SubjectService instance = new SubjectServiceImpl();
	public static SubjectService getInstance() {return instance;}
	private SubjectServiceImpl() {}

	@Override
	public void createSubject(SubjectBean Subject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SubjectBean> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubjectBean> readSome(String word) {
		
		return null;
	}

	@Override
	public SubjectBean readOne(String word) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateSubject(SubjectBean Subject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deledteSubject(SubjectBean Subject) {
		// TODO Auto-generated method stub
		
	}

}
