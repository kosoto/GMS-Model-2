package service;

import java.util.List;
import domain.ExamBean;

public interface ExamService {
	public void createExam(ExamBean exam);
	public List<ExamBean> list();
	public List<ExamBean> readSome(String word);
	public ExamBean readOne(String word);
	public void updateExam(ExamBean exam);
	public void deledteExam(ExamBean exam);
}
