package javaThread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.xml.crypto.Data;

public class MyTest {
	public static void main(String[] args) throws InterruptedException {
		
//		ExecutorService es=Executors.newCachedThreadPool();
		long l =System.currentTimeMillis();
		/*es.execute(new C1_7_1());
		es.execute(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(1000L);
				} catch (Exception e) {
				e.printStackTrace();
					// TODO: handle exception
				}
				
				C1_7_1.flag=false;
				System.out.println("set flag="+C1_7_1.flag);
				
			}
		});
		es.shutdown();
		es.awaitTermination(10L, TimeUnit.SECONDS);*/
		
		/*es.execute(new C1_7_3());
		es.execute(new C1_7_3());
		es.execute(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(1000L);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
				synchronized(C1_7_3.flag){
					System.out.println("flag.notifyAll");
					C1_7_3.flag.notifyAll();
				}
				
			}
		});
		es.shutdown();*/
		
		final CountDownLatch countDownLatch=new CountDownLatch(200);
		ExecutorService es=Executors.newFixedThreadPool(5);
		for (int i = 0; i < 200; i++) {
			es.execute(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						
						
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}finally{
							countDownLatch.countDown();
							System.out.println(countDownLatch.getCount());
						
					}
					
					
				}
			});
		}
		try {
			countDownLatch.await(10L, TimeUnit.SECONDS);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		es.shutdown();
		System.out.println(countDownLatch.getCount());
		
		
		System.out.print("time:");
		System.out.print(System.currentTimeMillis()-l);
		
	}

}
