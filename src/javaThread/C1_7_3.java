package javaThread;

import java.util.logging.Logger;

public class C1_7_3 implements Runnable{
//	private static final Logger log;
	 static final byte[] flag=new byte[0];
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			System.out.println("befor flag.waait");
			flag.wait();
			System.out.println("after flag.wait");
			Thread.sleep(1000L);
			System.out.println("after Thread.wait");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
