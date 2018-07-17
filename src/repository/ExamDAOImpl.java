package repository;

import java.util.List;

import domain.ExamBean;

public class ExamDAOImpl implements ExamDAO{
	private static ExamDAOImpl instance = new ExamDAOImpl();	
	public static ExamDAOImpl getInstance() {return instance;}
	private ExamDAOImpl() {}
	
	@Override
	public void insertExam(ExamBean exam) {
		/*System.out.println("examDAO");
		System.out.println(exam);*/
	}
	@Override
	public List<ExamBean> selectAllExam() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<ExamBean> selectSomeExam() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ExamBean selectOneExam() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int countExam() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void updateExam(ExamBean exam) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deledtExam(ExamBean exam) {
		// TODO Auto-generated method stub
		
	}

}
