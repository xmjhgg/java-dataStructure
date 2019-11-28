package strust.tree.huffman;

public class Node implements Comparable<Node>{
	
	//�����ӽڵ�
	Node left;
	Node right;
	//����������ļ�
	Byte b;
	//Ȩֵ���ڹ�����ѹ���д���������ļ��ĳ��ִ���
	Integer weight;
	
	public Node(Byte b,Integer weight) {
		this.b=b;
		this.weight=weight;
	}
	@Override
	public String toString() {
		return "Node [byte=" + b + ", weight=" + weight + "]";
	}
	@Override
	public int compareTo(Node o) {
		return o.weight-this.weight;
	}
	
	
	
	
}
