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
//		//�ȴ���һ�������������ļ��ϣ���������е���ֻ��һ���ڵ㣩
//		List<Node> nodes=new ArrayList<>();
//		for (int i = 0; i < arr.length; i++) {
//			nodes.add(new Node(arr[i]));
//		}
//		while(nodes.size()>1){
//			//����
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
//			//ȡ��ǰ��������С����
//			Node left=nodes.get(0);
//			Node right=nodes.get(1);
//			
//			//�ϲ����µ���
//			Node node =new Node(left.value+right.value);
//			
//			//ɾ�����鼯����ȡ�������������µ�����ӽ�ȥ
//			nodes.remove(left);
//			nodes.remove(right);
//			nodes.add(node);
//		}
//		
//		return nodes.get(0);
//		
//	}
	
}
