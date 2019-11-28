package javaThread;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class C1_6_1 implements Runnable{
	private static final Set<Integer> data=new HashSet<>();
	private static int count;
	protected int page;
	
	private static final Lock LOCK=new ReentrantLock();
	
	public C1_6_1 (int page) {
		this.page=page;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		int v=page*100000;
		System.out.println(v);
		for (int i = 0; i < 1000000; i++) {
			synchronized (data) {
				data.add(v++);
				
			}
			
			/*LOCK.lock();
			try {
				data.add(v++);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally{
				LOCK.unlock();
			}*/
			
		}
		count++;
		Thread.yield();
	}
	
	
public static void main(String[] args) throws InterruptedException {
		
		ExecutorService es=Executors.newCachedThreadPool();
		long l =System.currentTimeMillis();
		
		for (int i = 0; i < 20; i++) {
			es.execute(new C1_6_1(i));
		}
		es.shutdown();
		
		try {
			es.awaitTermination(10L, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("size:"+data.size());
		
		System.out.println("count="+count);
		
		System.out.print("time:");
		System.out.print(System.currentTimeMillis()-l);
	
	
	}
}
