package repository;

import domain.ImageBean;

public interface ImageDAO {
	public void insert(ImageBean img);
	public String selectOne(String word);
}
