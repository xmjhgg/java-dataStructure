
public class SXunHuanLianBiao {
	int data;
	SXunHuanLianBiao pre=this;
	SXunHuanLianBiao next=this;
	
	public SXunHuanLianBiao(int data){
		this.data=data;
	}
	
	//����һ���ڵ�
	public void addNext(SXunHuanLianBiao node){
		SXunHuanLianBiao nextNext=this.next;
		node.next=nextNext;
		node.pre=this;
		this.next=node;
		nextNext.pre=node;
	}
	
	//ɾ���ڵ�
	public void removeNext(){
		next.next.pre=this;
		this.next=next.next;
	}
}
