
public class t {
	public static void main(String[] args) {
		
		int max=9999999;
		
		int[] arr=new int[max];
		for (int i = 1; i <=arr.length; i++) {
			arr[i-1]=i;
		}
		
		int taget=99999999;
		
		int begin=0;
		int end=arr.length-1;
		int mid=(begin+end)/2;
		
		long a= System.currentTimeMillis();//��ȡ��ǰϵͳʱ��(����)
		int f=1;
		while(true){
			if(begin>=end){
				if(arr[mid]==taget){
					System.out.println("���ҵ�������"+mid);
					break;
					}
				else{
					System.out.println("û�������");
					break;
					}
			}else{
				if(arr[mid]>taget){
					end=mid-1;
				}else{
					begin=mid+1;
				}
				mid=(begin+end)/2;
				System.out.println("������"+f+++"��");
			}
			
		}
		
		System.out.print("����ִ��ʱ��Ϊ��");
		System.out.println(System.currentTimeMillis()-a+"����");
		
		a= System.currentTimeMillis();
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==taget){
				System.out.println("���ҵ�������"+i);
				break;
			}
		}
		System.out.print("����ִ��ʱ��Ϊ��");
		System.out.println(System.currentTimeMillis()-a+"����");
		
	}

}


