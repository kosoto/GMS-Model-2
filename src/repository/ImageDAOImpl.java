package repository;

import java.util.HashMap;
import java.util.Map;

import domain.ImageBean;
import enums.Domain;
import template.AddQuery;
import template.QueryTemplate;
import template.RetrieveQuery;

public class ImageDAOImpl implements ImageDAO{
	private QueryTemplate q;
	private static ImageDAO instance = new ImageDAOImpl();
	public static ImageDAO getInstance() {return instance;}
	private ImageDAOImpl() {}

	@Override
	public void insert(ImageBean image) {
		q = new AddQuery();
		Map<String,Object> map = new HashMap<>();
		map.put("table", Domain.IMAGE);
		map.put("value1", image.getImgName());
		map.put("value2", image.getExtension());
		map.put("value3", image.getMemberId());
		q.play(map);
		
		
	}

	@Override
	public String selectOne(String word) {
		q = new RetrieveQuery();
		Map<String,Object> map = new HashMap<>();
		map.put("table", Domain.IMAGE);
		map.put("column", "MEM_ID");
		map.put("value", word);
		q.play(map);
		ImageBean img = ((ImageBean)q.getO());
		return (img != null)?img.getImgName()+"."+img.getExtension():"default.jpg";
	}

	

}
