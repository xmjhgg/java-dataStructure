package strust.tree.huffman;


import java.util.ArrayList;
import java.util.List;



public class Huffman {
	
	
	
//	public static void main(String[] args) {
//		
//		int[] arr={1,1,1,2};
//		Node Huffman=creatHuffman(arr);
//		System.out.println(Huffman);
//		System.out.println(Huffman.left);
//		System.out.println(Huffman.right);
//		
//	}
//	
//	public static Node creatHuffman(int[] arr){
//		
//		//先创建一个所有树的树的集合（这个集合中的树只有一个节点）
//		List<Node> nodes=new ArrayList<>();
//		for (int i = 0; i < arr.length; i++) {
//			nodes.add(new Node(arr[i]));
//		}
//		while(nodes.size()>1){
//			//排序
//			for (int i = 0; i < nodes.size(); i++) {
//				for (int j = 0; j < nodes.size()-1; j++) {
//					if(nodes.get(j).value>nodes.get(j+1).value){
//						Node temp=nodes.get(j);
//						nodes.set(j, nodes.get(j+1));
//						nodes.set(j+1, temp);
//					}
//				}
//			}
//			
//			//取出前面两个最小的树
//			Node left=nodes.get(0);
//			Node right=nodes.get(1);
//			
//			//合并成新的树
//			Node node =new Node(left.value+right.value);
//			
//			//删除数组集合中取出的数，并吧新的树添加进去
//			nodes.remove(left);
//			nodes.remove(right);
//			nodes.add(node);
//		}
//		
//		return nodes.get(0);
//		
//	}
	
}
