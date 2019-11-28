package javaThread;

public class C1_7_1 implements Runnable{
	public static volatile boolean flag=true;
//	public static boolean flag=true;
	public static int value;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(flag){
			value++;
			value--;
			
			try {
				Thread.sleep(1000L);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				
			}
			
			System.out.println("value:"+value);
			
			
			
		}
		System.out.println("flag:"+flag);
		
		
	}
		
}
