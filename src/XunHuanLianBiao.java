
public class XunHuanLianBiao {
	
	int data;
	XunHuanLianBiao next=this;
	
	public XunHuanLianBiao(int data){
		this.data=data;
	}

	//ɾ����һ���ڵ�
	public void removeNext(){
		next=next.next;
	}
	
	//����ǰ�ڵ����һ���ڵ�
	public void addNode(XunHuanLianBiao node){
		XunHuanLianBiao nextNode=this.next;
		next=node;
		next.next=nextNode;
	}
}
