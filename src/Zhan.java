import java.util.Arrays;


public class Zhan {
	//��ʼ��ջ
	private int[] zhan;
	public Zhan(){
		zhan=new int[0];
	}
	//ѹԪ����ջ
	public void push(int num){
		int[] newzhan=new int[zhan.length+1];
		for (int i = 0; i < zhan.length; i++) {
			newzhan[i]=zhan[i];
		}
		newzhan[newzhan.length-1]=num;
		zhan=newzhan;
	}
	//��ջ��ȡ��Ԫ��
	public int pop(){
		int element=zhan[zhan.length-1];
		int[] newzhan=new int[zhan.length-1];
		for (int i = 0; i < newzhan.length; i++) {
			newzhan[i]=zhan[i];
		}
		zhan=newzhan;
		return element;
	}
	//�鿴ջ��Ԫ��
	public int peek(){
		return zhan[zhan.length-1];
	}
	//�ж�ջ�Ƿ�Ϊ��
	public boolean isnull(){
		return zhan.length==0;
	}

	@Override
	public String toString() {
		return "Myzhan��" + Arrays.toString(zhan) ;
	}
	
	
}
