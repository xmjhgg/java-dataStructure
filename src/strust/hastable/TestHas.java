package strust.hastable;

public class TestHas {
	public static void main(String[] args) {
		
		StudentInfo s1=new StudentInfo(4, 9);
		StudentInfo s2=new StudentInfo(2, 17);
		StudentInfo s3=new StudentInfo(3, 18);
		StudentInfo s4=new StudentInfo(14, 19);
		StudentInfo s5=new StudentInfo(14, 29);
		
		Hastable has=new Hastable();
		has.put(s5);
		has.put(s4);
		has.put(s3);
		has.put(s2);
		has.put(s1);
		
		System.out.println(has);
		
	}
}
