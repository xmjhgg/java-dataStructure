package javaSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Logger;

public class Client1 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader iReader=null;
		BufferedReader sReader=null;
		
		String cmd=null;
		PrintWriter pWriter=null;
		Socket socket=null;
		try {
			socket =new Socket("127.0.0.1", 9000);
			sReader=new BufferedReader(new InputStreamReader(socket.getInputStream())); //��ȡ�����ַ���
			pWriter=new PrintWriter(socket.getOutputStream(),true); //��������ַ���
			System.out.println("Say 'bye' to exit");
			iReader= new BufferedReader(new InputStreamReader(System.in)); //��ȡ���̵����룬��ͨ��socket����
			while((cmd=iReader.readLine())!=null){
				pWriter.print(cmd); //������������ַ����ͳ�ȥ
				String s =sReader.readLine(); //��ȡ��������Ӧ������
				System.out.println(String.format("Servers say:%s", s));
				if ("bye".equalsIgnoreCase(s)) {
					break;
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			iReader.close();
			sReader.close();
			iReader.close();
			System.out.println("bye");
		}
	}
	

}
