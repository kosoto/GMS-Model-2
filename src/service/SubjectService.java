package service;

import java.util.List;
import domain.SubjectBean;

public interface SubjectService {
	public void createSubject(SubjectBean Subject);
	public List<SubjectBean> list();
	public List<SubjectBean> readSome(String word);
	public SubjectBean readOne(String word);
	public void updateSubject(SubjectBean Subject);
	public void deledteSubject(SubjectBean Subject);
}
