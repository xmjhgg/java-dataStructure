package strust.graph;

public class Vertex {
	
	//��������
	private String v;
	
	//��¼�Ƿ񱻱�����
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
