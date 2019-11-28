
public class DanLianBiao {
	
	int data;
	DanLianBiao next;
	
	public DanLianBiao(int data){
		this.data=data;
	}
	
	//追加节点
	public DanLianBiao append(DanLianBiao node){
		DanLianBiao currentNode=this;
		while(true){
			if(currentNode.next==null){
				currentNode.next=node;
				break;
			}
			currentNode=currentNode.next;
		}
		return this;
	}
	
	//显示所有节点
	public void show(){
		DanLianBiao currentNode=this;
		while(true){
			if (currentNode.next ==null) {
				System.out.println(currentNode.data);
				break;
			}
			System.out.print(currentNode.data+" ");
			currentNode=currentNode.next;
		}
	}
	
	//删除下一个节点
	public void removeNext(){
		if(isEnd()){
			throw new RuntimeException("已经是最后一个节点");
		}
		next=next.next;
	}
	
	//给当前节点插入一个节点
	public void addNode(DanLianBiao node){
		DanLianBiao nextNode=this.next;
		next=node;
		next.next=nextNode;
	}
	
	//判断是否为最后一个节点
	public boolean isEnd(){
		return this.next==null;
	}
	
	
}
