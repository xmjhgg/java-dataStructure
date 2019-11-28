package shejimoshi.qiaojie;

public class test {
	public static void main(String[] args) {
		Shape redShape=new Cirecle(new RedCircle(), 5, 100, 100);
		Shape gShape=new Cirecle(new GreenCircle(), 3, 200, 200);
		
		redShape.draw();
		gShape.draw();
	}
}
