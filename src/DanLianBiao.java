
public class DanLianBiao {
	
	int data;
	DanLianBiao next;
	
	public DanLianBiao(int data){
		this.data=data;
	}
	
	//׷�ӽڵ�
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
	
	//��ʾ���нڵ�
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
	
	//ɾ����һ���ڵ�
	public void removeNext(){
		if(isEnd()){
			throw new RuntimeException("�Ѿ������һ���ڵ�");
		}
		next=next.next;
	}
	
	//����ǰ�ڵ����һ���ڵ�
	public void addNode(DanLianBiao node){
		DanLianBiao nextNode=this.next;
		next=node;
		next.next=nextNode;
	}
	
	//�ж��Ƿ�Ϊ���һ���ڵ�
	public boolean isEnd(){
		return this.next==null;
	}
	
	
}
