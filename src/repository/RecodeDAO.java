package repository;
import java.util.List;
import domain.RecodeBean;

public interface RecodeDAO {
	public void insertRecode(RecodeBean recode);
	public List<RecodeBean> list();
	public List<RecodeBean> readSome(String word);
	public RecodeBean readOne(String word);
	public int countRecode();
	public void updateRecode(RecodeBean recode);
	public void deleteRecode(RecodeBean recode);
}
