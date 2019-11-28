
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
		
		long a= System.currentTimeMillis();//获取当前系统时间(毫秒)
		int f=1;
		while(true){
			if(begin>=end){
				if(arr[mid]==taget){
					System.out.println("查找的数字在"+mid);
					break;
					}
				else{
					System.out.println("没有这个数");
					break;
					}
			}else{
				if(arr[mid]>taget){
					end=mid-1;
				}else{
					begin=mid+1;
				}
				mid=(begin+end)/2;
				System.out.println("查找了"+f+++"次");
			}
			
		}
		
		System.out.print("程序执行时间为：");
		System.out.println(System.currentTimeMillis()-a+"毫秒");
		
		a= System.currentTimeMillis();
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==taget){
				System.out.println("查找的数字在"+i);
				break;
			}
		}
		System.out.print("程序执行时间为：");
		System.out.println(System.currentTimeMillis()-a+"毫秒");
		
	}

}


