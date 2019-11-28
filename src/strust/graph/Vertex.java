package strust.graph;

public class Vertex {
	
	//保存数据
	private String v;
	
	//记录是否被遍历过
	boolean issee;
	
	
	public Vertex(String v){
		this.v=v;
	}
	
	
	
	public String getV() {
		return v;
	}



	public void setV(String v) {
		this.v = v;
	}



	@Override
	public String toString() {
		return "Vertex [v=" + v + "]";
	}
}
