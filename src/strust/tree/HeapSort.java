package strust.tree;

import java.util.Arrays;

//�����򣨸��˲��ԣ�ʧ�ܡ���
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
	  	�󶥶Ѿ��Ǹ��ڵ�һ��������ӽڵ�Ķ���������������������ǿ�����������
		�������ÿ������󶥶Ѻ�����ֻ��Ҫ���󶥶ѵĸ��ڵ㣨��Ϊ���ڵ�϶�������ֵ���ƶ���ĩβ�Ϳ���
		���������󶥶ѵ�ĩβ�ƶ����ٽ���һ�δ󶥶ѵ�������ô�Ϳ���������ǵ������㷨��
		���Ҫ�������У��ǾͿ���ʹ��С���ѣ�С���ѵĸ��ڵ�һ��С���ӽڵ�
		�󶥶ѵĲ���
	*/
	public static void maxHeap(int[] arr,int size,int index){
		
		//���ӽڵ�
		int left=2*index+1;
		//���ӽڵ�
		int right=2*index+2;
		
		//�������ֵ��С�꣬�ʼ�����ǿ�ʼ����λ�õ��±�
		int max=index;
		
		//�Ⱥ����ӽڵ�Ƚ�
		if(left<arr.length&&arr[left]>arr[max]){
			max=left;
		}
		//�ٱȽ����ӽڵ�
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


