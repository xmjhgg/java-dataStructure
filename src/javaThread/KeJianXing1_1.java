package javaThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class KeJianXing1_1 implements Runnable{
	
	public static int x;
	public static boolean flag =true;
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (flag) {
			try {
				System.out.println("xµÄÖµÎª£º"+x);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) throws InterruptedException {
		ExecutorService es =Executors.newCachedThreadPool();
		es.execute(new KeJianXing1_1());
		x=10;
		flag=false;
		System.out.println(flag);
	}

}
