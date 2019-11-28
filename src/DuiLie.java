
public class DuiLie {
	
	private int[] myqueue=new int[0];
	
	//���
	public void add(int num){
		int[] newq=new int[myqueue.length+1];
		for (int i = 0; i < myqueue.length; i++) {
			newq[i]=myqueue[i];
		}
		newq[newq.length-1]=num;
		myqueue=newq;
	}
	
	//����
	public int poll(){
		int element=myqueue[0];
		int[] newq=new int[myqueue.length-1];
		for (int i = 0; i < newq.length; i++) {
			newq[i]=myqueue[i+1];
		}
		myqueue=newq;
		return element;
	}
	
	//�п�
	public boolean isEmply(){
		return myqueue.length==0;
	}
}
