package command;

import java.io.File;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import org.apache.tomcat.util.http.fileupload.*;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import domain.ImageBean;
import enums.Term;
import service.ImageServiceImpl;

public class FileCommand extends Command {

	public FileCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, 
				request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
		System.out.println("1. 파일 커맨드 진입");
		if(!ServletFileUpload.isMultipartContent(request)) {
			System.out.println("업로드파일이 업습니다.");
			return;
		}
		System.out.println("2. 업로드 파일 존재함");
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setFileSizeMax(1024 * 1024 * 40);  //40MB
		upload.setSizeMax(1024 * 1024 * 50); //50MB
		List<FileItem> items = null;
		try {
			System.out.println("3. try 내부로 진입");
			File file = null;
			items = upload.parseRequest(new ServletRequestContext(request));
			System.out.println("4. items 생성");
			Iterator<FileItem>iter = items.iterator();
			while(iter.hasNext()) {
				System.out.println("5. while 진입");
				FileItem item = (FileItem) iter.next();
				if(!item.isFormField()) {
					System.out.println("6. if 진입");
					String fileName = item.getName();
					file = new File(Term.UPLOAD_PATH+fileName);
					item.write(file);
					System.out.println("7. 파일 업로드 성공");
					ImageBean img = new ImageBean();
					System.out.println("fileName : "+fileName);
					System.out.println(fileName.split("\\.")[0]);
					System.out.println(fileName.split("\\.")[1]);
					img.setImgName(fileName.split("\\.")[0]);
					img.setExtension(fileName.split("\\.")[1]);
					System.out.println("request.getParameter(userid) : "+request.getParameter("userid"));
					img.setMemberId(request.getParameter("userid"));
					ImageServiceImpl.getInstance().add(img);
				}else {
					System.out.println("8. 파일 업로드 실패");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("10. 캐리어 떠나기 전");
		super.execute();
	}
	
}
