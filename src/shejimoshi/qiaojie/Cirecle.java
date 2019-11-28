package shejimoshi.qiaojie;

public class Cirecle extends Shape{
	
	int r,x,y;
	
	

	protected Cirecle(DrawAPI drawAPI, int r, int x, int y) {
		super(drawAPI);
		this.r = r;
		this.x = x;
		this.y = y;
	}



	@Override
	public void draw() {
		
		drawAPI.drawCircle(r, x, y);
		
	}
	
}
