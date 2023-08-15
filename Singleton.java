package day0814;

public class Singleton {
	private static Singleton SINGLE;
	private Singleton () {
		System.out.println("생성자");
	}
	
	public static Singleton getInstance() {
		if(SINGLE==null) {
			SINGLE=new Singleton();
		}
		return SINGLE;
	}
}	
