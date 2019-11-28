package javaSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Processor1 implements Runnable{
	private Socket socket;
	
	public  Processor1(Socket socket) {
		this.socket=socket;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		BufferedReader bReader=null;
		PrintWriter pWriter=null;
		try {
			bReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pWriter=new PrintWriter(socket.getOutputStream(),true);
			while (!Thread.interrupted()) {
				String s=bReader.readLine();
				System.out.println(String.format("%s say: %s", socket.getRemoteSocketAddress(),s));
				System.out.println(12);
				pWriter.println(s);
				if ("bye".equals(s)) {
					break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			try {
				bReader.close();
				pWriter.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	

}
