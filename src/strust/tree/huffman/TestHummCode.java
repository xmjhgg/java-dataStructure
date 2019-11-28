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


//用赫夫曼编码来压缩文件
public class TestHummCode {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		String src="3.txt";
		String target="2.zip";
		zip(src, target);
		String target2="1.txt";
		unzip(target,target2);

	}
	
	
	//压缩文件
	public static void zip(String src,String target) throws IOException{
		
		//获取源文件
		InputStream is=new FileInputStream(src);
		//创建一个用于保存二进制文件的byte数组
		byte[] b=new byte[is.available()];
		//读取源文件的内容到b中
		is.read(b);
		is.close();
		
		/* 1.创建赫夫曼树
		 * 2.根据赫夫曼树创建赫夫曼编码表
		 * 3.进行压缩，得到压缩后的byte
		 * 4.然后将压缩后的byte和编码表作为目标文件返回
		 */
		//得到赫夫曼树
		Node huffmantree=creatHuffman(b);
		//得到赫夫曼编码表
		Map<Byte,String> huffmanCode=getCode(huffmantree);
		//得到压缩后的byte
		byte[] bzip=HuffmanZip(b, huffmanCode);
		
		OutputStream os=new FileOutputStream(target);
		ObjectOutputStream oos=new ObjectOutputStream(os);
		//写入压缩后的byte，赫夫曼编码表
		oos.writeObject(bzip);
		oos.writeObject(huffmanCode);
		oos.close();
		os.close();
		
	}
	
	//解压缩文件
	public static void unzip(String src,String target) throws IOException, ClassNotFoundException{
		
		//创建输入流，读取源文件
		InputStream is=new FileInputStream(src);
		ObjectInputStream ois=new ObjectInputStream(is);
		//从源文件中读取到压缩后的byte以及赫夫曼编码表
		byte[] zipb=(byte[]) ois.readObject();
		Map<Byte, String> huffmanCode=(Map<Byte, String>) ois.readObject();
		//调用解压缩方法
		byte[] b=unCode(zipb, huffmanCode);
		ois.close();
		is.close();
		//创建目标文件
		OutputStream os=new FileOutputStream(target);
		os.write(b);
		os.close();
	}
	
	
	//1.创建赫夫曼树
	public static Node creatHuffman(byte[] bytes){
		
		//先统计每个比特数字出现的次数
		Map<Byte, Integer> counts=new HashMap<>();
		for(byte b:bytes){
			//将byte作为key，统计byte出现的次数
			Integer count=counts.get(b);
			//如果比特是第一次出现，那就将其对应的出现次数设置为1
			if (count==null) {
				counts.put(b, 1);
			//如果是多次出现，对应的value+1
			}else{
				counts.put(b, count+1);
			}
		}
		
		//将上面的每一个键值对转换成对应的一颗树，并添加到树集合中
		List<Node> nodes=new ArrayList<>();
		for(Map.Entry<Byte, Integer> entry:counts.entrySet()){
			nodes.add(new Node(entry.getKey(),entry.getValue()));
		}
		
		//对树集合进行排序，并转换成赫夫曼树
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
	
	
	//2.根据赫夫曼树获取赫夫曼编码表
	public static Map<Byte, String> getCode(Node tree){
		if (tree==null) {
			return null;
		}
		//这个Map就是赫夫曼编码表
		Map<Byte, String> huffmanCode=new HashMap<>();
		//创建用于存储到达叶子节点的路径
		StringBuilder sb=new StringBuilder();
		
		//递归遍历所有叶子节点
		getCode2(tree.left,"0",sb,huffmanCode);
		getCode2(tree.right,"1",sb,huffmanCode);
		
		
		return huffmanCode;
		
	}

	private static void getCode2(Node node, String code, StringBuilder sb,Map<Byte, String> huffmanCode) {
		//保存到达叶子节点的路径，向左走为0，向右走为1
		StringBuilder sb2=new StringBuilder(sb);
		//再没有达到叶子节点前都要追加上 上一次走过的路径
		sb2.append(code);
		//如果为空就说明不是叶子节点，没有存放数据，继续遍历
		if (node.b==null) {
			getCode2(node.left, "0", sb2,huffmanCode);
			getCode2(node.right, "1", sb2,huffmanCode);
		}else{
			//到达节点，保存到达的数据和对应的走过的路径
			huffmanCode.put(node.b, sb2.toString());
		}
		
	}

	//3.进行压缩
	public static byte[] HuffmanZip(byte[] bytes,Map<Byte,String> huffmanCode){
		
		//创建一个sb,为了能够对赫夫曼编码表进行切割等操作,以及转换成一个10进制数
		StringBuilder sb=new StringBuilder();
		
		//将需要压缩的byte数组转换成字符串数组
		for(Byte b:bytes){
			sb.append(huffmanCode.get(b));
		}
		
		//byte类型占8位，进行切割，每隔八位
		//先定义长度，为了预防数组越界的问题，如果sb不是8的整数倍
		int len;
		if (sb.length()%8==0) {
			len=sb.length()/8;
		}else{
			len=sb.length()/8+1;
		}
		
		//用于保存压缩后的比特流
		byte[] by=new byte[len];
		//by的下标
		int index=0;
		
		//将sb每隔8位进行切割，并且把切割后的字符串转换为比特保存到by中
		for (int i = 0; i < sb.length(); i+=8) {
			String strByt;
			if (i+8>sb.length()) {
				strByt=sb.substring(i);
			}else{
				strByt=sb.substring(i, i+8);
			}
			//将字符串转换成2进制值的比特
			//parseInt方法返回的是十进制的数，所以需要强转，第二参数表明的是要转换的数当前是几进制
			byte b=(byte) Integer.parseInt(strByt, 2);
			by[index]=b;
			index++;

		}
		return by;
		
	}

	//4.根据赫夫曼编码表进行解码
	public static byte[] unCode(byte[] bytes,Map<Byte, String> hufumanCode){
		
		//创建一个用来保存二进制数的字符串数组
		StringBuilder sb=new StringBuilder();
		
		//将byte数组转为二进制的字符串数组
		for(int i=0;i<bytes.length;i++){
			System.out.println(bytes[i]);
			//判断是否为最后一个元素，不是的话就需要补充0
			boolean flag=(i==bytes.length-1);
			String strb=toByte(!flag,bytes[i]);
			//得到压缩后完整的二进制数组
			sb.append(strb);
		}

		//根据二进制数组来找到对应的值
		//创建一个新的map，将赫夫曼编码表中的值和键调换，通过value来找key（key才是原来文件的二进制表达）
		Map<String, Byte> map=new HashMap<>();
		for(Map.Entry<Byte,String> entry:hufumanCode.entrySet()){
			map.put(entry.getValue(), entry.getKey());
		}
		
		//用于临时保存得到的Byte数据，因为并不知道数组的长度，所以使用list来保存数据
		List<Byte> list=new ArrayList<>();
		
		//根据key来找回原来的二进制文件
		for (int i = 0; i < sb.length();) {
			//用于切割sb数组，从0~1、0~2，直到找出对应的key
			int count=1;
			//用于记录是否找出了一个key，
			boolean flag=true;
			//用于保存找出的压缩前的数据
			Byte b = null;
			
			while(flag){
				//0~1、0~2的顺序查找出key，找出key后跳出循环，找下一个key
				String key=null;
				//扫描有效的key
				key=sb.substring(i, i+count);
				//根据找出的key得到原来的byte数据
				b=map.get(key);
				if (b==null) {
					count++;
				}else{
					flag=false;
				}
			}
			
			list.add(b);
			//调整刚开始扫描的位置
			i+=count;
			count=1;
		}
		
		//将list转换为byte数组
		byte[] by=new byte[list.size()];
		
		for (int i = 0; i < list.size(); i++) {
			by[i]=list.get(i);
		}
		
		return by;
		
	}
	
	//将32位的int转换成8位的byte，因为int的正数会忽略前面的0所以正数需要补充0
	public static String toByte(boolean flag,byte b){
		int temp=b;
		
		//因为自己补充了多余的0，如果原来的二进制数组的最后一个比特是正数的话那就会得到多余的0
		//所以这里需要判断一下是否是最后一个比特,如果是就不补0，如果不是就补0
		if (flag) {
			//用|位运算，两者按位比较，如果两者都是0，那就取0.如果两者其中有一个1或都是1那就取1
			//这样就可以在正数前面补充0，对负数没有影响
			temp=temp|256;
		}
		String byteString=Integer.toBinaryString(temp);
		if (flag) {
			//转换完成后取后8位，得到8位的二进制数
			return byteString.substring(byteString.length()-8);
		}else{
			//最后一位直接返回，如果截取的话，可能不够8位。
			return byteString;
		}
		
	} 
	
	
	
}
