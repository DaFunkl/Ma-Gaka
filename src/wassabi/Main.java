package wassabi;

public class Main {
	public static void main(String[] args) {
		Mat a  = new Mat(new int[]{1,0,2});
		System.out.println(a.toString());
		System.out.println(a.identity(3));
	}
}
