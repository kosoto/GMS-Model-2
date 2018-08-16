package Test;

import service.MemberServiceImpl;

public class Test {
	public static void main(String[] args) {
		int a = MemberServiceImpl.getInstance().count();
		System.out.println(a);
		int b = MemberServiceImpl.getInstance().count();
		System.out.println(b);
		
	}

}
















