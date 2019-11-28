package javaSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Servers1 implements Runnable{
	private final ExecutorService es=Executors.newCachedThreadPool();
	private ServerSocket serverSocket=null;
	
	public void start() throws IOException{
		serverSocket=new ServerSocket(9000);
		es.execute(this);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Socket socket=null;
		try {
			while ((socket=serverSocket.accept())!=null) {
				System.out.println("ServerSocket accpet:"+socket.getRemoteSocketAddress());
				es.execute(new Processor1(socket));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void close(){
		if (serverSocket!=null&&!serverSocket.isClosed()) { //�жϷ�����Socket�Ƿ�����
			try {
				serverSocket.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		es.shutdown();
	}
	
	public static void main(String[] args) throws IOException {
		Servers1 server=new Servers1();
		BufferedReader bReader=null;
		
		try {
			server.start();
			System.out.println("���� 'exit' �˳���������");
			bReader=new BufferedReader(new InputStreamReader(System.in)); //�������������ַ���
			String cmd=null;
			while ((cmd=bReader.readLine())!=null) {
				if ("exit".equalsIgnoreCase(cmd)) {
					break;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			bReader.close();
			server.close();
		}
	}

}
