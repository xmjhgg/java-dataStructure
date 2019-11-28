package strust.tree.huffman;

public class Node implements Comparable<Node>{
	
	//左右子节点
	Node left;
	Node right;
	//保存二进制文件
	Byte b;
	//权值，在哈夫曼压缩中代表二进制文件的出现次数
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
