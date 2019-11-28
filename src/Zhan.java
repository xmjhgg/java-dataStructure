import java.util.Arrays;


public class Zhan {
	//初始化栈
	private int[] zhan;
	public Zhan(){
		zhan=new int[0];
	}
	//压元素入栈
	public void push(int num){
		int[] newzhan=new int[zhan.length+1];
		for (int i = 0; i < zhan.length; i++) {
			newzhan[i]=zhan[i];
		}
		newzhan[newzhan.length-1]=num;
		zhan=newzhan;
	}
	//从栈顶取出元素
	public int pop(){
		int element=zhan[zhan.length-1];
		int[] newzhan=new int[zhan.length-1];
		for (int i = 0; i < newzhan.length; i++) {
			newzhan[i]=zhan[i];
		}
		zhan=newzhan;
		return element;
	}
	//查看栈顶元素
	public int peek(){
		return zhan[zhan.length-1];
	}
	//判断栈是否为空
	public boolean isnull(){
		return zhan.length==0;
	}

	@Override
	public String toString() {
		return "Myzhan：" + Arrays.toString(zhan) ;
	}
	
	
}
