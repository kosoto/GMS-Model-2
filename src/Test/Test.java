package Test;

public class Test {
	public static void main(String[] args) {
		String query = "UPDATE MEMBER "
				  + "SET %s = ?, "
				  + "WHERE MEM_ID LIKE ? ";
		int a =(query.split("\\?")).length;
		System.out.println(a);
	}

}
















