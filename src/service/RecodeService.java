package service;

import java.util.List;

import domain.ExamBean;
import domain.RecodeBean;

public interface RecodeService {
	public void createRecode(ExamBean exam);
	public List<RecodeBean> list();
	public RecodeBean readOne(String word);
	public List<RecodeBean> readSome(String word);
	public void updateRecode(RecodeBean recode);
	public void deleteRecode(RecodeBean recode);
	public String computeAvg(String[] arr);
	public String computeGrade(String avg);
}
