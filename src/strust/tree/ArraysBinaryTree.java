package strust.tree;

public class ArraysBinaryTree {
	int data[];
	
	public ArraysBinaryTree(int[] data){
		this.data=data;
	}
	
	//真·前序遍历
	public void frontShow(){
		front(0);
	}
	
	
	//前续遍历
	public void front(int index){
		if(data==null||data.length==0){
			return;
		}
		
		System.out.print(data[index]+" ");
		
		//遍历左节点，2*index+1就是每个节点的左节点，index是数组的下标
		if (2*index+1<data.length) {
			front(2*index+1);
		}
		//遍历右节点，2*index+2就是每个节点的右击节点
		if (2*index+2<data.length) {
			front(2*index+2);
		}
	}
	
	
	
	
}
