package strust.tree.huffman;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//�úշ���������ѹ���ļ�
public class TestHummCode {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		String src="3.txt";
		String target="2.zip";
		zip(src, target);
		String target2="1.txt";
		unzip(target,target2);

	}
	
	
	//ѹ���ļ�
	public static void zip(String src,String target) throws IOException{
		
		//��ȡԴ�ļ�
		InputStream is=new FileInputStream(src);
		//����һ�����ڱ���������ļ���byte����
		byte[] b=new byte[is.available()];
		//��ȡԴ�ļ������ݵ�b��
		is.read(b);
		is.close();
		
		/* 1.�����շ�����
		 * 2.���ݺշ����������շ��������
		 * 3.����ѹ�����õ�ѹ�����byte
		 * 4.Ȼ��ѹ�����byte�ͱ������ΪĿ���ļ�����
		 */
		//�õ��շ�����
		Node huffmantree=creatHuffman(b);
		//�õ��շ��������
		Map<Byte,String> huffmanCode=getCode(huffmantree);
		//�õ�ѹ�����byte
		byte[] bzip=HuffmanZip(b, huffmanCode);
		
		OutputStream os=new FileOutputStream(target);
		ObjectOutputStream oos=new ObjectOutputStream(os);
		//д��ѹ�����byte���շ��������
		oos.writeObject(bzip);
		oos.writeObject(huffmanCode);
		oos.close();
		os.close();
		
	}
	
	//��ѹ���ļ�
	public static void unzip(String src,String target) throws IOException, ClassNotFoundException{
		
		//��������������ȡԴ�ļ�
		InputStream is=new FileInputStream(src);
		ObjectInputStream ois=new ObjectInputStream(is);
		//��Դ�ļ��ж�ȡ��ѹ�����byte�Լ��շ��������
		byte[] zipb=(byte[]) ois.readObject();
		Map<Byte, String> huffmanCode=(Map<Byte, String>) ois.readObject();
		//���ý�ѹ������
		byte[] b=unCode(zipb, huffmanCode);
		ois.close();
		is.close();
		//����Ŀ���ļ�
		OutputStream os=new FileOutputStream(target);
		os.write(b);
		os.close();
	}
	
	
	//1.�����շ�����
	public static Node creatHuffman(byte[] bytes){
		
		//��ͳ��ÿ���������ֳ��ֵĴ���
		Map<Byte, Integer> counts=new HashMap<>();
		for(byte b:bytes){
			//��byte��Ϊkey��ͳ��byte���ֵĴ���
			Integer count=counts.get(b);
			//��������ǵ�һ�γ��֣��Ǿͽ����Ӧ�ĳ��ִ�������Ϊ1
			if (count==null) {
				counts.put(b, 1);
			//����Ƕ�γ��֣���Ӧ��value+1
			}else{
				counts.put(b, count+1);
			}
		}
		
		//�������ÿһ����ֵ��ת���ɶ�Ӧ��һ����������ӵ���������
		List<Node> nodes=new ArrayList<>();
		for(Map.Entry<Byte, Integer> entry:counts.entrySet()){
			nodes.add(new Node(entry.getKey(),entry.getValue()));
		}
		
		//�������Ͻ������򣬲�ת���ɺշ�����
		while(nodes.size()>1){
			Collections.sort(nodes);
			Node left=nodes.get(nodes.size()-1);
			Node right=nodes.get(nodes.size()-2);
			Node newNode=new Node(null,right.weight+left.weight);
			newNode.left=left;
			newNode.right=right;
			nodes.add(newNode);
			nodes.remove(left);
			nodes.remove(right);		
		}
		

		return nodes.get(0);
		
	}
	
	
	//2.���ݺշ�������ȡ�շ��������
	public static Map<Byte, String> getCode(Node tree){
		if (tree==null) {
			return null;
		}
		//���Map���Ǻշ��������
		Map<Byte, String> huffmanCode=new HashMap<>();
		//�������ڴ洢����Ҷ�ӽڵ��·��
		StringBuilder sb=new StringBuilder();
		
		//�ݹ��������Ҷ�ӽڵ�
		getCode2(tree.left,"0",sb,huffmanCode);
		getCode2(tree.right,"1",sb,huffmanCode);
		
		
		return huffmanCode;
		
	}

	private static void getCode2(Node node, String code, StringBuilder sb,Map<Byte, String> huffmanCode) {
		//���浽��Ҷ�ӽڵ��·����������Ϊ0��������Ϊ1
		StringBuilder sb2=new StringBuilder(sb);
		//��û�дﵽҶ�ӽڵ�ǰ��Ҫ׷���� ��һ���߹���·��
		sb2.append(code);
		//���Ϊ�վ�˵������Ҷ�ӽڵ㣬û�д�����ݣ���������
		if (node.b==null) {
			getCode2(node.left, "0", sb2,huffmanCode);
			getCode2(node.right, "1", sb2,huffmanCode);
		}else{
			//����ڵ㣬���浽������ݺͶ�Ӧ���߹���·��
			huffmanCode.put(node.b, sb2.toString());
		}
		
	}

	//3.����ѹ��
	public static byte[] HuffmanZip(byte[] bytes,Map<Byte,String> huffmanCode){
		
		//����һ��sb,Ϊ���ܹ��Ժշ������������и�Ȳ���,�Լ�ת����һ��10������
		StringBuilder sb=new StringBuilder();
		
		//����Ҫѹ����byte����ת�����ַ�������
		for(Byte b:bytes){
			sb.append(huffmanCode.get(b));
		}
		
		//byte����ռ8λ�������иÿ����λ
		//�ȶ��峤�ȣ�Ϊ��Ԥ������Խ������⣬���sb����8��������
		int len;
		if (sb.length()%8==0) {
			len=sb.length()/8;
		}else{
			len=sb.length()/8+1;
		}
		
		//���ڱ���ѹ����ı�����
		byte[] by=new byte[len];
		//by���±�
		int index=0;
		
		//��sbÿ��8λ�����и���Ұ��и����ַ���ת��Ϊ���ر��浽by��
		for (int i = 0; i < sb.length(); i+=8) {
			String strByt;
			if (i+8>sb.length()) {
				strByt=sb.substring(i);
			}else{
				strByt=sb.substring(i, i+8);
			}
			//���ַ���ת����2����ֵ�ı���
			//parseInt�������ص���ʮ���Ƶ�����������Ҫǿת���ڶ�������������Ҫת��������ǰ�Ǽ�����
			byte b=(byte) Integer.parseInt(strByt, 2);
			by[index]=b;
			index++;

		}
		return by;
		
	}

	//4.���ݺշ����������н���
	public static byte[] unCode(byte[] bytes,Map<Byte, String> hufumanCode){
		
		//����һ��������������������ַ�������
		StringBuilder sb=new StringBuilder();
		
		//��byte����תΪ�����Ƶ��ַ�������
		for(int i=0;i<bytes.length;i++){
			System.out.println(bytes[i]);
			//�ж��Ƿ�Ϊ���һ��Ԫ�أ����ǵĻ�����Ҫ����0
			boolean flag=(i==bytes.length-1);
			String strb=toByte(!flag,bytes[i]);
			//�õ�ѹ���������Ķ���������
			sb.append(strb);
		}

		//���ݶ������������ҵ���Ӧ��ֵ
		//����һ���µ�map�����շ���������е�ֵ�ͼ�������ͨ��value����key��key����ԭ���ļ��Ķ����Ʊ�
		Map<String, Byte> map=new HashMap<>();
		for(Map.Entry<Byte,String> entry:hufumanCode.entrySet()){
			map.put(entry.getValue(), entry.getKey());
		}
		
		//������ʱ����õ���Byte���ݣ���Ϊ����֪������ĳ��ȣ�����ʹ��list����������
		List<Byte> list=new ArrayList<>();
		
		//����key���һ�ԭ���Ķ������ļ�
		for (int i = 0; i < sb.length();) {
			//�����и�sb���飬��0~1��0~2��ֱ���ҳ���Ӧ��key
			int count=1;
			//���ڼ�¼�Ƿ��ҳ���һ��key��
			boolean flag=true;
			//���ڱ����ҳ���ѹ��ǰ������
			Byte b = null;
			
			while(flag){
				//0~1��0~2��˳����ҳ�key���ҳ�key������ѭ��������һ��key
				String key=null;
				//ɨ����Ч��key
				key=sb.substring(i, i+count);
				//�����ҳ���key�õ�ԭ����byte����
				b=map.get(key);
				if (b==null) {
					count++;
				}else{
					flag=false;
				}
			}
			
			list.add(b);
			//�����տ�ʼɨ���λ��
			i+=count;
			count=1;
		}
		
		//��listת��Ϊbyte����
		byte[] by=new byte[list.size()];
		
		for (int i = 0; i < list.size(); i++) {
			by[i]=list.get(i);
		}
		
		return by;
		
	}
	
	//��32λ��intת����8λ��byte����Ϊint�����������ǰ���0����������Ҫ����0
	public static String toByte(boolean flag,byte b){
		int temp=b;
		
		//��Ϊ�Լ������˶����0�����ԭ���Ķ�������������һ�������������Ļ��Ǿͻ�õ������0
		//����������Ҫ�ж�һ���Ƿ������һ������,����ǾͲ���0��������ǾͲ�0
		if (flag) {
			//��|λ���㣬���߰�λ�Ƚϣ�������߶���0���Ǿ�ȡ0.�������������һ��1����1�Ǿ�ȡ1
			//�����Ϳ���������ǰ�油��0���Ը���û��Ӱ��
			temp=temp|256;
		}
		String byteString=Integer.toBinaryString(temp);
		if (flag) {
			//ת����ɺ�ȡ��8λ���õ�8λ�Ķ�������
			return byteString.substring(byteString.length()-8);
		}else{
			//���һλֱ�ӷ��أ������ȡ�Ļ������ܲ���8λ��
			return byteString;
		}
		
	} 
	
	
	
}
