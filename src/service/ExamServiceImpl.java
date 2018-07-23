package service;

import java.util.*;
import domain.*;
import repository.*;

public class ExamServiceImpl implements ExamService{
	private static ExamService instance = new ExamServiceImpl();
	public static ExamService getInstance() {return instance;}
	private ExamServiceImpl() {}
	
	@Override
	public void createExam(ExamBean exam) {
		String[] arrScore = exam.getScore().split(",");	
		RecodeServiceImpl.getInstance().createRecode(exam);
	//	String[] arr = {"자바","SQL","HTML5","R","PYTHON"};
	//	List<SubjectBean> list = null;
		String recodeSeq = String.valueOf(
				(RecodeDAOImpl.getInstance().countRecode())
				);
		for(int i = 0;i<5;i++) {
			/*list = SubjectServiceImpl.getInstance().readSome(arr[i]);
			exam.setSubSeq(list.get(0).getSubSeq());*/
			exam.setSubSeq(String.valueOf(i+1));
			exam.setScore(arrScore[i]);
			exam.setRecodeSeq(recodeSeq);
			ExamDAOImpl.getInstance().insertExam(exam);	
			System.out.println("ExamService");
			System.out.println(exam);
		}
		/////////
		/*RecodeBean recode = new RecodeBean();
		RecodeDAOImpl.getInstance().insertRecode(recode);
		exam.setRecodeSeq(RecodeDAOImpl.getInstance().selectFirstRowNum());*/
		
				
	}
	@Override
	public List<ExamBean> list() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<ExamBean> readSome(String word) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ExamBean readOne(String word) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void updateExam(ExamBean exam) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deledteExam(ExamBean exam) {
		// TODO Auto-generated method stub
		
	}	


}
