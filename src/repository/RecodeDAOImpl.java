package repository;

import java.util.List;

import domain.RecodeBean;

public class RecodeDAOImpl implements RecodeDAO{
	private static RecodeDAOImpl instance = new RecodeDAOImpl();
	public static RecodeDAOImpl getInstance() {return instance;}
	private RecodeDAOImpl() {}

	@Override
	public void insertRecode(RecodeBean recode) {
		System.out.println("레코드 DAO");
		System.out.println(recode);
		
	}

	@Override
	public List<RecodeBean> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RecodeBean> readSome(String word) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RecodeBean readOne(String word) {
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
	public int countRecode() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
