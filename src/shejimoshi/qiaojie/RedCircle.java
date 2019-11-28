package shejimoshi.qiaojie;

public class RedCircle implements DrawAPI{

	@Override
	public void drawCircle(int r, int x, int y) {
		System.out.printf("画了一个园：半径+"+r+"坐标："+x+","+y,"颜色红");
		System.out.println();
		
	}
	
}
