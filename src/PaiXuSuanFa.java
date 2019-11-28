import java.util.Arrays;


public class PaiXuSuanFa {
	private static final Object[] DuiLie = null;

	public static void main(String[] args) {
		
		int[] arr={2,6,5,7,3,4,66,77,1,432,667,1,0};
		System.out.println(Arrays.toString(arr));
		raddixSortByQueue(arr);
		System.out.println(Arrays.toString(arr));


		
	}
	
	
	//冒泡，数组中的元素两两进行比较，大的向后移动
	public static void maoPao(int[] arr){
		for (int i = 0; i < arr.length-1; i++) {
			int k=0;
			for (int j = 0; j < arr.length-1-k; j++) {
				if(arr[j]>arr[j+1]){
					int tmep=arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=tmep;
				}
			}
			k++;
		}
	}
	
	//快速排序，根据一个标准数，进行递归，将小于标准数的元素向前移动，大于标准数的向后移动
	public static void  qucikSort(int[] arr,int start,int end){
		if(start<end){
			//标准数
			int standtard=arr[start];
			
			//记录开始的位置
			int low=start;
			
			//记录结束的位置
			int hight=end;
			
			//循环 将比标准数大和比标准数小的数分组，大的在标准数右边，小的在左边
			while(low<hight){
				
				//如果右边的数大于标准数，那么只需要下标向左移即可
				while(low<hight&&arr[hight]>=standtard){
					hight--;
				}
				
				//小于就将右边的数移动到左右
				arr[low]=arr[hight];
				//如果左边的数小于标准数，那么只需要下标向右移即可
				while(low<hight&&arr[low]<=standtard){
					low++;
				}
				
				//如果大于，就将左边的数向右移
				arr[hight]=arr[low];
				
				//同时，在把标准数赋给low，这样标准数就处于中间
				arr[low]=standtard;
				
				//再对左边和右边分别进行快速排序，递归
				qucikSort(arr, start, low);
				qucikSort(arr, low+1, end);
				
			}
		}
	}
	
	//插入排序，将小的数向前移动，直到碰到比这个数还小的数
	public static void insertSort(int[] arr){
		
		//遍历数组中的所有数，因为第一个数是可以省略遍历的，所以从1这个位置开始对比大小
		for(int i=1;i<arr.length;i++){
			
			//如果前一个数比后一个数大，那么就说明需要移动数的位置
			if(arr[i]<arr[i-1]){
				//临时变量，记录当前需要移动位置的元素
				int temp=arr[i];
				//j是当前元素前面的元素的下标，用于将当前元素向前移动
				int j;
				//进行循环，遍历当前元素之前的所有元素，直到j比0小，即当前元素是最小的一个数，已经移动到了数组的开头位置
				//或者遇到了比当前元素还小的数，那么循环结束，把当前位置的元素改为当前的元素
				//如果没有，就说明当前的元素比前面的元素小，那么就将前一个元素和后一个元素交换位置
				for (j = i-1;j>=0&&temp<arr[j]; j--) {
					arr[j+1]=arr[j];
				}
				/*遇到了比当前元素小的数，跳出循环，把当前元素的值赋给j+1
				 * （因为循环中进行了j--，所以循环结束的位置其实是j+1）
				的位置，原来j+1位置上的数在循环中已经移动到了j+2的位置上
				*/
				arr[j+1]=temp;
				
			}
		}
	}
	
	//希尔排序，这个思想是将数组根据步长分为多个组，组之间的两个元素互相对比，小的排到前面，大的排到面，排序的方式是采用插入排序
	//相比较直接用插入排序，希尔排序的好处是可以再一开始就将一些比较大的数排到后面，小的数排到前面，节省了比较的次数
	public static void xierSort(int[] arr){
		int k=1;
		//进行多次分组，获取到每次分组的步长，直到步长等于0
		for(int d=arr.length/2;d>0;d/=2){
			
			//与下面的循环（其实下面的循环只循环了一次）配合，遍历所有数组元素
			for(int i=d;i<arr.length;i++){
				//获取到两组
				for(int j=i-d;j>=0;j-=d){
					
					if(arr[j]>arr[j+d]){
						int temp=arr[j+d];
						arr[j+d]=arr[j];
						arr[j]=temp;
					}
				}
			}

		}
		
	}
	
	//选择排序，数组中的数两两进行比较，记录下小的数的下标，比遍历完数组中的所有元素后再根据下标交换位置
	public static void selectSort(int[] arr){
		//遍历数组中的所有元素
		for (int i = 0; i < arr.length; i++) {
			//用minIndex记录当前的元素
			int minIndex=i;
			//遍历当前元素后面的所有元素，找出最小的元素
			for (int j = i+1; j < arr.length; j++) {
				//如果后面的元素比当前的元素小，那么记录那个小的元素的下标
				if(arr[j]<arr[minIndex]){
					minIndex=j;
				}
			}
			//如果minIndex已经不是i了，那就说明后面有元素比当前元素小，交换两个元素的位置
			//这样就把每次循环中找到的最小元素移动到最前面了
			if(minIndex!=i){
				int temp=arr[i];
				arr[i]=arr[minIndex];
				arr[minIndex]=temp;
			}
			
		}
		
	}
	
	//归并排序，思想是将数组分位多个数组，数组和数组之间进行比较，比较完后又合并为一个数组，
	//合并完后再进行两个合并完的数组的比较，直到合并成一个数组
	public static void mergeSort(int[]arr,int low,int high){
		
		if(low<high){
			int middle=(low+high)/2;
			mergeSort(arr,low,middle);
			mergeSort(arr, middle+1, high);
			merge(arr,low,middle,high);
		}
		
	}
	//拆分与合并
	public static void merge(int[] arr,int low,int middle,int high){
		
		//创建一个临时数组用来保存排好序的元素（临时数组只是原来未被分割的数组的一半）
		int temp[]=new int[high-low+1];
		//i就是开始位置的下标，j是另一边数组开始位置的下标
		int i=low;
		int j=middle+1;
		
		//临时数组保存元素的下标
		int index=0;
		
		//当i和j没有移动完数组的最后一个元素时，两个数组的元素就开始比较
		while(i<=middle&&j<=high){
			
			//如果第一个数组比第二数组的元素小，就把小的元素保存到临时数组中，保存完后移动i和index
			if(arr[i]<arr[j]){
				temp[index]=arr[i];
				i++;
				index++;
				//如果第二个数组比第一数组的元素小，就把小的元素保存到临时数组中，保存完后移动j和index
			}else{
				temp[index]=arr[j];
				j++;
				index++;
			}
			
		}
		
		//经过了上面的循环，i或者j之中有一个数已经到达了数组中的最后一个数
		//将剩余的数补充到临时数组中
		while(i<=middle){
			temp[index]=arr[i];
			index++;
			i++;
		}
		while(j<=high){
			temp[index]=arr[j];
			index++;
			j++;
		}
		//将临时数组中的值传给原来的数组
		for (int k = 0; k < temp.length; k++) {
			arr[k+low]=temp[k];
		}
		
	}
	
	//基数排序，根据个位数，十位数，百位数...来排序,比较适合用于数组中大的数和小的数都比较多，平均的情况
	public static void raddixSort(int[] arr){
		
		//设置最大数，并从数组中找出最大数
		int max=Integer.MIN_VALUE;
		for (int i = 0; i < arr.length-1; i++) {
			if(arr[i]>max){
				max=arr[i];
			}
		}
		//找出最大数的位数
		int maxlength=(max+"").length();
		//设置一个临时二维数组用于保存每次根据位数排序后的元素
		int[][] temp=new int[10][arr.length];
		//设置一个一位数组用于记录temp中的每个数组中元素的数量
		int[] count=new int[10];
		
		//将原数组中的元素按照位数，保存到temp中
		for (int i = 0,n=1; i < maxlength; i++,n*=10) {
			
			//每次循环都要遍历整个数组，求出按照位数的大小
			for (int j = 0; j < arr.length; j++) {
				//求出余数
				int ys=arr[j]/n%10;
				//将元素保存到临时二维数组中的对应位置上
				temp[ys][count[ys]]=arr[j];
				//保存完成后计数器+1，下一次又遇到同样的余数时，元素就会保存到temp的下一个位置上
				count[ys]++;
			}

			//开始取出元素到原数组中
			//设置一个下标，用于记录原数组中保存元素的位置
			int index=0;
			//遍历count，找出temp中有保存元素的数组
			for (int j = 0; j < count.length; j++) {
				//如果count中有元素不等于0，就说明对应的temp数组中有元素，那就要将其中的元素取出来
				if (count[j]!=0) {
					for (int j2 = 0; j2 < count[j]; j2++) {
						arr[index]=temp[j][j2];
						index++;
					}
				}
				//将用于记录数组中元素数量的数组都置为0，用于下一次的循环比较
				count[j]=0;
			}
		}
	}
	
	//用队列来实现的基数排序
	/*
	 依靠队列实现的基数排序,因为从二维数组中先放元素，再按照放进去的顺序取出元素，
	这一步骤和队列先进先出的操作是一样的，
	所以基数排序是可以用队列来实现的，代码更简洁，思路更清晰
	*/
	public static void raddixSortByQueue(int[] arr){
		//设置最大数，并从数组中找出最大数
				int max=Integer.MIN_VALUE;
				for (int i = 0; i < arr.length-1; i++) {
					if(arr[i]>max){
						max=arr[i];
					}
				}
				//找出最大数的位数
				int maxlength=(max+"").length();
				//创建队列来保存按照位数放入的元素
				DuiLie[] myDuiLie = new DuiLie[10];
				//队列数组的初始化
				for (int i = 0; i < myDuiLie.length; i++) {
					myDuiLie[i]=new DuiLie();
				}
				
				//将原数组中的元素按照位数，保存到队列中
				for (int i = 0,n=1; i < maxlength; i++,n*=10) {
					
					//每次循环都要遍历整个数组，求出按照位数的大小
					for (int j = 0; j < arr.length; j++) {
						//求出余数
						int ys=arr[j]/n%10;
						//将元素保存到对应队列中
						myDuiLie[ys].add(arr[j]);
					}

					//开始取出元素到原数组中
					//设置下标来保存原数组中保存了元素的位置
					int index=0;
					for (int j = 0; j < myDuiLie.length; j++) {
						//如果队列中不为空，那么就说明队列中有元素需要取出来
						while (!myDuiLie[j].isEmply()) {
							arr[index]=myDuiLie[j].poll();
							index++;
						}
						
					}
				}
			}
	
}
