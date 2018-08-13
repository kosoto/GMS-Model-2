package controller;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import command.Carrier;
import command.Receiver;
import enums.Action;

@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Receiver.init(request);
		switch(Action.valueOf(Receiver.cmd.getAction().toUpperCase())) {
		case ADD :
			Carrier.redirect(request, response,
					"/member.do?action=move&page=login");
			break;
		case SEARCH :
			Carrier.forward(request, response);
			break;
		case RETRIEVE :
			Carrier.forward(request, response);
			break;
		case COUNT :
			Carrier.redirect(request, response, "");
			break;
		case MODIFY : 
			Carrier.forward(request, response);
			break;
		case REMOVE :
			Carrier.redirect(request, response,"");
			break;
		case FILEUPLOAD : 
			System.out.println("1. 멤버컨트롤러 파일업로드 케이스 진입");
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
				items = upload.parseRequest((RequestContext) request);
				System.out.println("4. items 생성");
				Iterator<FileItem>iter = items.iterator();
				while(iter.hasNext()) {
					System.out.println("5. while 진입");
					FileItem item = (FileItem) iter.next();
					if(!item.isFormField()) {
						System.out.println("6. if 진입");
						String fieldName = item.getFieldName();
						String fileName = item.getName();
						boolean isINMemory = item.isInMemory();
						long sizeInBytes = item.getSize();
						file = new File(fileName);
						item.write(file);
						System.out.println("7. 파일 업로드 성공");
					}else {
						System.out.println("8. 파일 업로드 실패");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("10. 캐리어 떠나기 전");
			Carrier.redirect(request, response, "/member.do?action=retirieve&page=main");
			break;
		case MOVE : 
			Carrier.forward(request, response);
			break;
		case LOGIN :
			if(request.getAttribute("match").equals("TRUE")) {
				Carrier.forward(request, response);
			}else {
				Carrier.redirect(request, response, 
						"/member.do?action=move&page=login");
			}
			break;
		default:break;
		}
	}

}
