


public class Suanfa {
	public static void main(String[] args) {
		
//		System.out.println(fbonaqi(10));
		
		hanoi(5, 'A', 'B', 'C');
		
	}
	
	//쳲��������У�1 1 2 3 5 8 13 21 34 55
	public static int fbonaqi(int i){
		if(i==1||i==2){
			return 1;
		}else{
			return fbonaqi(i-1)+fbonaqi(i-2);
		}
	}
	
	//��ŵ������,�����������Ӵﵽ5ʱ�����
	public static void hanoi(int n,char one,char two,char three){
		//ֻ��һ������
		if(n==1){
			System.out.println("��(1)��"+one+"�ƶ���"+three);
		}
		//����һ�����ӵ������
		/*
		 * �����ж��ٸ����ӣ�����Ϊ�������ӣ�����µ����Ӻ�����µ���������ӣ������������������ƶ�
		 * */
		else{
			//�ƶ���������ӵ��м������
			hanoi(n-1,one,three,two);
			//�ƶ�������ľ��ƶ�����µ�����
			System.out.println("��"+n+"��"+one+"�ƶ���"+three);
			//������������ƶ���Ŀ������
			hanoi(n-1,two,one,three);
		}
	}
	

}
