package javaThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class KeJianXing1_2 {
	
	public static void main(String[] args) throws InterruptedException {

		ExecutorService es=Executors.newCachedThreadPool();
		es.execute(new KeJianXing1_1());
		es.execute(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				KeJianXing1_1.x=10;
				
				System.out.println("�޸�xֵΪ10");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				KeJianXing1_1.flag=false;
				System.out.println("�޸�flagΪflase");
				
			}
		});
		
		es.shutdown();
		es.awaitTermination(10L, TimeUnit.SECONDS);
		System.out.println("���߳̽���");
		
	}

}
