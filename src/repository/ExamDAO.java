package repository;

import domain.ExamBean;
import java.util.List;

public interface ExamDAO {
	public void insertExam(ExamBean exam);
	public List<ExamBean> selectAllExam();
	public List<ExamBean> selectSomeExam();
	public ExamBean selectOneExam();
	public int countExam();
	public void updateExam(ExamBean exam);
	public void deledtExam(ExamBean exam);
}
