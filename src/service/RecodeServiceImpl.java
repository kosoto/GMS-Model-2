package service;

import java.util.List;

import domain.ExamBean;
import domain.RecodeBean;
import repository.RecodeDAOImpl;

public class RecodeServiceImpl implements RecodeService{
	private static RecodeService instance = new RecodeServiceImpl();
	public static RecodeService getInstance() {return instance;}
	private RecodeServiceImpl() {}
	
	@Override
	public void createRecode(ExamBean exam) {
		String avg = computeAvg(exam.getScore().split(","));
		RecodeBean recode = new RecodeBean();
		recode.setAvg(avg);
		recode.setGrade(computeGrade(avg));
		/*String recodeSeq = String.valueOf(
				(RecodeDAOImpl.getInstance().countRecode())+1);
		recode.setRecodeSeq(recodeSeq);*/		
		RecodeDAOImpl.getInstance().insertRecode(recode);
	}
	@Override
	public List<RecodeBean> list() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public RecodeBean readOne(String word) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<RecodeBean> readSome(String word) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void updateRecode(RecodeBean recode) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteRecode(RecodeBean recode) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String computeAvg(String[] arr) {
		int temp = 0;
		for(int i =0;i<5;i++) {
			temp += Integer.parseInt(arr[i]);
		}		
		return String.valueOf(temp /= 5);
	}
	@Override
	public String computeGrade(String avg) {
		String res = "";
		switch(avg) {
		case "10" :	case "9" : res = "A"; break;
		case "8" : res = "B"; break;
		case "7" : res = "C"; break;
		case "6" : res = "D"; break;
		case "5" : res = "E"; break;
		default : res = "F"; break;		
		}
		return res;
	}
	
	

	
	
}
