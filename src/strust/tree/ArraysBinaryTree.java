package strust.tree;

public class ArraysBinaryTree {
	int data[];
	
	public ArraysBinaryTree(int[] data){
		this.data=data;
	}
	
	//�桤ǰ�����
	public void frontShow(){
		front(0);
	}
	
	
	//ǰ������
	public void front(int index){
		if(data==null||data.length==0){
			return;
		}
		
		System.out.print(data[index]+" ");
		
		//������ڵ㣬2*index+1����ÿ���ڵ����ڵ㣬index��������±�
		if (2*index+1<data.length) {
			front(2*index+1);
		}
		//�����ҽڵ㣬2*index+2����ÿ���ڵ���һ��ڵ�
		if (2*index+2<data.length) {
			front(2*index+2);
		}
	}
	
	
	
	
}
