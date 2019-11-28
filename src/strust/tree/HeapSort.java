package strust.tree;

import java.util.Arrays;

//堆排序（个人测试，失败。）
public class HeapSort {
	
	public static void main(String[] args) {
		int[] arr={9,6,8,7,0,1,10,4,2};
		System.out.println(Arrays.toString(arr));
		heapSort(arr);
		System.out.println(Arrays.toString(arr));

	}
	
	public static void heapSort(int[] arr) {
		int start=(arr.length-1)/2;
		
		for (int i = start; i >=0; i--) {
			maxHeap(arr, arr.length, i);
		}
		
		for (int i = arr.length-1; i>=0; i--) {
			int temp=arr[i];
			arr[i]=arr[0];
			arr[0]=temp;
			maxHeap(arr, i, 0);
		}
	}
	
	
	/*
	  	大顶堆就是父节点一定会大于子节点的二叉树，利用这个特性我们可以用来排序，
		如果，在每次排完大顶堆后，我们只需要将大顶堆的根节点（因为根节点肯定是最大的值）移动到末尾就可以
		这样，将大顶堆的末尾移动后，再进行一次大顶堆的排序，那么就可以完成我们的排序算法。
		如果要降序排列，那就可以使用小顶堆，小顶堆的父节点一定小于子节点
		大顶堆的产生
	*/
	public static void maxHeap(int[] arr,int size,int index){
		
		//左子节点
		int left=2*index+1;
		//右子节点
		int right=2*index+2;
		
		//设置最大值的小标，最开始假设是开始排序位置的下标
		int max=index;
		
		//先和左子节点比较
		if(left<arr.length&&arr[left]>arr[max]){
			max=left;
		}
		//再比较右子节点
		if (right<arr.length&&arr[right]>arr[max]) {
			max=right;
		}
		
		if (max!=index) {
			int temp=arr[index];
			arr[index]=arr[max];
			arr[max]=temp;
			maxHeap(arr, size, max);
		}
		
		
		
	}
}


