package javaThread;

public class KeJianXing1_3 {
	
	private static boolean flag=true;
	private static int x;
	
	private static class MyThread extends Thread{
		public void run(){
			while (flag) {
				try {
					System.out.println(x);
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new MyThread().start();
		x=10;
//		flag=false;
	}

}
