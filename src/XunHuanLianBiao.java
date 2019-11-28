
public class XunHuanLianBiao {
	
	int data;
	XunHuanLianBiao next=this;
	
	public XunHuanLianBiao(int data){
		this.data=data;
	}

	//删除下一个节点
	public void removeNext(){
		next=next.next;
	}
	
	//给当前节点插入一个节点
	public void addNode(XunHuanLianBiao node){
		XunHuanLianBiao nextNode=this.next;
		next=node;
		next.next=nextNode;
	}
}
