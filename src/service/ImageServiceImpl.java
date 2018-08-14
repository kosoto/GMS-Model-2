package service;

import domain.ImageBean;
import repository.ImageDAOImpl;

public class ImageServiceImpl implements ImageService{
	private static ImageService instance = new ImageServiceImpl();
	public static ImageService getInstance() {return instance;}
	private ImageServiceImpl() {}
	
	@Override
	public void add(ImageBean img) {
		ImageDAOImpl.getInstance().insert(img);
	}
	@Override
	public String retrieve(String word) {
		return ImageDAOImpl.getInstance().selectOne(word);
	}

}
