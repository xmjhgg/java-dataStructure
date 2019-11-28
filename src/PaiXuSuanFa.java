import java.util.Arrays;


public class PaiXuSuanFa {
	private static final Object[] DuiLie = null;

	public static void main(String[] args) {
		
		int[] arr={2,6,5,7,3,4,66,77,1,432,667,1,0};
		System.out.println(Arrays.toString(arr));
		raddixSortByQueue(arr);
		System.out.println(Arrays.toString(arr));


		
	}
	
	
	//ð�ݣ������е�Ԫ���������бȽϣ��������ƶ�
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
	
	//�������򣬸���һ����׼�������еݹ飬��С�ڱ�׼����Ԫ����ǰ�ƶ������ڱ�׼��������ƶ�
	public static void  qucikSort(int[] arr,int start,int end){
		if(start<end){
			//��׼��
			int standtard=arr[start];
			
			//��¼��ʼ��λ��
			int low=start;
			
			//��¼������λ��
			int hight=end;
			
			//ѭ�� ���ȱ�׼����ͱȱ�׼��С�������飬����ڱ�׼���ұߣ�С�������
			while(low<hight){
				
				//����ұߵ������ڱ�׼������ôֻ��Ҫ�±������Ƽ���
				while(low<hight&&arr[hight]>=standtard){
					hight--;
				}
				
				//С�ھͽ��ұߵ����ƶ�������
				arr[low]=arr[hight];
				//�����ߵ���С�ڱ�׼������ôֻ��Ҫ�±������Ƽ���
				while(low<hight&&arr[low]<=standtard){
					low++;
				}
				
				//������ڣ��ͽ���ߵ���������
				arr[hight]=arr[low];
				
				//ͬʱ���ڰѱ�׼������low��������׼���ʹ����м�
				arr[low]=standtard;
				
				//�ٶ���ߺ��ұ߷ֱ���п������򣬵ݹ�
				qucikSort(arr, start, low);
				qucikSort(arr, low+1, end);
				
			}
		}
	}
	
	//�������򣬽�С������ǰ�ƶ���ֱ���������������С����
	public static void insertSort(int[] arr){
		
		//���������е�����������Ϊ��һ�����ǿ���ʡ�Ա����ģ����Դ�1���λ�ÿ�ʼ�Աȴ�С
		for(int i=1;i<arr.length;i++){
			
			//���ǰһ�����Ⱥ�һ��������ô��˵����Ҫ�ƶ�����λ��
			if(arr[i]<arr[i-1]){
				//��ʱ��������¼��ǰ��Ҫ�ƶ�λ�õ�Ԫ��
				int temp=arr[i];
				//j�ǵ�ǰԪ��ǰ���Ԫ�ص��±꣬���ڽ���ǰԪ����ǰ�ƶ�
				int j;
				//����ѭ����������ǰԪ��֮ǰ������Ԫ�أ�ֱ��j��0С������ǰԪ������С��һ�������Ѿ��ƶ���������Ŀ�ͷλ��
				//���������˱ȵ�ǰԪ�ػ�С��������ôѭ���������ѵ�ǰλ�õ�Ԫ�ظ�Ϊ��ǰ��Ԫ��
				//���û�У���˵����ǰ��Ԫ�ر�ǰ���Ԫ��С����ô�ͽ�ǰһ��Ԫ�غͺ�һ��Ԫ�ؽ���λ��
				for (j = i-1;j>=0&&temp<arr[j]; j--) {
					arr[j+1]=arr[j];
				}
				/*�����˱ȵ�ǰԪ��С����������ѭ�����ѵ�ǰԪ�ص�ֵ����j+1
				 * ����Ϊѭ���н�����j--������ѭ��������λ����ʵ��j+1��
				��λ�ã�ԭ��j+1λ���ϵ�����ѭ�����Ѿ��ƶ�����j+2��λ����
				*/
				arr[j+1]=temp;
				
			}
		}
	}
	
	//ϣ���������˼���ǽ�������ݲ�����Ϊ����飬��֮�������Ԫ�ػ���Աȣ�С���ŵ�ǰ�棬����ŵ��棬����ķ�ʽ�ǲ��ò�������
	//��Ƚ�ֱ���ò�������ϣ������ĺô��ǿ�����һ��ʼ�ͽ�һЩ�Ƚϴ�����ŵ����棬С�����ŵ�ǰ�棬��ʡ�˱ȽϵĴ���
	public static void xierSort(int[] arr){
		int k=1;
		//���ж�η��飬��ȡ��ÿ�η���Ĳ�����ֱ����������0
		for(int d=arr.length/2;d>0;d/=2){
			
			//�������ѭ������ʵ�����ѭ��ֻѭ����һ�Σ���ϣ�������������Ԫ��
			for(int i=d;i<arr.length;i++){
				//��ȡ������
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
	
	//ѡ�����������е����������бȽϣ���¼��С�������±꣬�ȱ����������е�����Ԫ�غ��ٸ����±꽻��λ��
	public static void selectSort(int[] arr){
		//���������е�����Ԫ��
		for (int i = 0; i < arr.length; i++) {
			//��minIndex��¼��ǰ��Ԫ��
			int minIndex=i;
			//������ǰԪ�غ��������Ԫ�أ��ҳ���С��Ԫ��
			for (int j = i+1; j < arr.length; j++) {
				//��������Ԫ�رȵ�ǰ��Ԫ��С����ô��¼�Ǹ�С��Ԫ�ص��±�
				if(arr[j]<arr[minIndex]){
					minIndex=j;
				}
			}
			//���minIndex�Ѿ�����i�ˣ��Ǿ�˵��������Ԫ�رȵ�ǰԪ��С����������Ԫ�ص�λ��
			//�����Ͱ�ÿ��ѭ�����ҵ�����СԪ���ƶ�����ǰ����
			if(minIndex!=i){
				int temp=arr[i];
				arr[i]=arr[minIndex];
				arr[minIndex]=temp;
			}
			
		}
		
	}
	
	//�鲢����˼���ǽ������λ������飬���������֮����бȽϣ��Ƚ�����ֺϲ�Ϊһ�����飬
	//�ϲ�����ٽ��������ϲ��������ıȽϣ�ֱ���ϲ���һ������
	public static void mergeSort(int[]arr,int low,int high){
		
		if(low<high){
			int middle=(low+high)/2;
			mergeSort(arr,low,middle);
			mergeSort(arr, middle+1, high);
			merge(arr,low,middle,high);
		}
		
	}
	//�����ϲ�
	public static void merge(int[] arr,int low,int middle,int high){
		
		//����һ����ʱ�������������ź����Ԫ�أ���ʱ����ֻ��ԭ��δ���ָ�������һ�룩
		int temp[]=new int[high-low+1];
		//i���ǿ�ʼλ�õ��±꣬j����һ�����鿪ʼλ�õ��±�
		int i=low;
		int j=middle+1;
		
		//��ʱ���鱣��Ԫ�ص��±�
		int index=0;
		
		//��i��jû���ƶ�����������һ��Ԫ��ʱ�����������Ԫ�ؾͿ�ʼ�Ƚ�
		while(i<=middle&&j<=high){
			
			//�����һ������ȵڶ������Ԫ��С���Ͱ�С��Ԫ�ر��浽��ʱ�����У���������ƶ�i��index
			if(arr[i]<arr[j]){
				temp[index]=arr[i];
				i++;
				index++;
				//����ڶ�������ȵ�һ�����Ԫ��С���Ͱ�С��Ԫ�ر��浽��ʱ�����У���������ƶ�j��index
			}else{
				temp[index]=arr[j];
				j++;
				index++;
			}
			
		}
		
		//�����������ѭ����i����j֮����һ�����Ѿ������������е����һ����
		//��ʣ��������䵽��ʱ������
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
		//����ʱ�����е�ֵ����ԭ��������
		for (int k = 0; k < temp.length; k++) {
			arr[k+low]=temp[k];
		}
		
	}
	
	//�������򣬸��ݸ�λ����ʮλ������λ��...������,�Ƚ��ʺ����������д������С�������Ƚ϶࣬ƽ�������
	public static void raddixSort(int[] arr){
		
		//����������������������ҳ������
		int max=Integer.MIN_VALUE;
		for (int i = 0; i < arr.length-1; i++) {
			if(arr[i]>max){
				max=arr[i];
			}
		}
		//�ҳ��������λ��
		int maxlength=(max+"").length();
		//����һ����ʱ��ά�������ڱ���ÿ�θ���λ��������Ԫ��
		int[][] temp=new int[10][arr.length];
		//����һ��һλ�������ڼ�¼temp�е�ÿ��������Ԫ�ص�����
		int[] count=new int[10];
		
		//��ԭ�����е�Ԫ�ذ���λ�������浽temp��
		for (int i = 0,n=1; i < maxlength; i++,n*=10) {
			
			//ÿ��ѭ����Ҫ�����������飬�������λ���Ĵ�С
			for (int j = 0; j < arr.length; j++) {
				//�������
				int ys=arr[j]/n%10;
				//��Ԫ�ر��浽��ʱ��ά�����еĶ�Ӧλ����
				temp[ys][count[ys]]=arr[j];
				//������ɺ������+1����һ��������ͬ��������ʱ��Ԫ�ؾͻᱣ�浽temp����һ��λ����
				count[ys]++;
			}

			//��ʼȡ��Ԫ�ص�ԭ������
			//����һ���±꣬���ڼ�¼ԭ�����б���Ԫ�ص�λ��
			int index=0;
			//����count���ҳ�temp���б���Ԫ�ص�����
			for (int j = 0; j < count.length; j++) {
				//���count����Ԫ�ز�����0����˵����Ӧ��temp��������Ԫ�أ��Ǿ�Ҫ�����е�Ԫ��ȡ����
				if (count[j]!=0) {
					for (int j2 = 0; j2 < count[j]; j2++) {
						arr[index]=temp[j][j2];
						index++;
					}
				}
				//�����ڼ�¼������Ԫ�����������鶼��Ϊ0��������һ�ε�ѭ���Ƚ�
				count[j]=0;
			}
		}
	}
	
	//�ö�����ʵ�ֵĻ�������
	/*
	 ��������ʵ�ֵĻ�������,��Ϊ�Ӷ�ά�������ȷ�Ԫ�أ��ٰ��շŽ�ȥ��˳��ȡ��Ԫ�أ�
	��һ����Ͷ����Ƚ��ȳ��Ĳ�����һ���ģ�
	���Ի��������ǿ����ö�����ʵ�ֵģ��������࣬˼·������
	*/
	public static void raddixSortByQueue(int[] arr){
		//����������������������ҳ������
				int max=Integer.MIN_VALUE;
				for (int i = 0; i < arr.length-1; i++) {
					if(arr[i]>max){
						max=arr[i];
					}
				}
				//�ҳ��������λ��
				int maxlength=(max+"").length();
				//�������������水��λ�������Ԫ��
				DuiLie[] myDuiLie = new DuiLie[10];
				//��������ĳ�ʼ��
				for (int i = 0; i < myDuiLie.length; i++) {
					myDuiLie[i]=new DuiLie();
				}
				
				//��ԭ�����е�Ԫ�ذ���λ�������浽������
				for (int i = 0,n=1; i < maxlength; i++,n*=10) {
					
					//ÿ��ѭ����Ҫ�����������飬�������λ���Ĵ�С
					for (int j = 0; j < arr.length; j++) {
						//�������
						int ys=arr[j]/n%10;
						//��Ԫ�ر��浽��Ӧ������
						myDuiLie[ys].add(arr[j]);
					}

					//��ʼȡ��Ԫ�ص�ԭ������
					//�����±�������ԭ�����б�����Ԫ�ص�λ��
					int index=0;
					for (int j = 0; j < myDuiLie.length; j++) {
						//��������в�Ϊ�գ���ô��˵����������Ԫ����Ҫȡ����
						while (!myDuiLie[j].isEmply()) {
							arr[index]=myDuiLie[j].poll();
							index++;
						}
						
					}
				}
			}
	
}
