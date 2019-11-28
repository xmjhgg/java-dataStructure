package strust.tree;

public class TreeNode {
	
	int value;
	TreeNode leftNode;
	TreeNode rightNode;
	
	//���leftType����1����˵�����ӽڵ�ָ��ǰ���ڵ�
	int leftType;
	//���leftType����1����˵�����ӽڵ�ָ��ǰ���ڵ�
	int rightType;
	
	protected TreeNode(int value) {
		this.value = value;
	}
	
	public TreeNode getLeftNode() {
		return leftNode;
	}
	
	public void setLeftNode(TreeNode leftNode) {
		this.leftNode = leftNode;
	}
	public TreeNode getRightNode() {
		return rightNode;
	}
	public void setRightNode(TreeNode rightNode) {
		this.rightNode = rightNode;
	}
	
	//�������
	public void frontShow(){
		//�ȱ������ӽڵ㣬ֱ�����е����ӽڵ㶼������
		if(leftNode!=null){
			leftNode.frontShow();
		}
		//��ӡ��ǰ�ڵ�
		System.out.print(this.value+"  ");
		//���������ӽڵ�
		if(rightNode!=null){
			rightNode.frontShow();
		}
	}
	
	//��������Ĳ���
	public TreeNode frontSearch(int i){
		//��ǰ�ڵ�
		TreeNode target=null;
		//�ȱ������ӽڵ�
		if(leftNode!=null){
			//�õ�ǰ�ڵ������ӽڵ㣬�������еݹ����
			target=leftNode.frontSearch(i);
		}
		//���target��Ϊ�գ���ô�ʹ����ҵ���Ŀ��
		if (target!=null) {
			return target;
		}
		else{
			//���ҵĽ����ֵ��ͬ����ǰ�ڵ����Ŀ��ڵ�
			if(this.value==i){
				return this;
			}
			//���������ӽڵ�
			if(rightNode!=null){
				target=rightNode.frontSearch(i);
			}
		}
		//�ڴ˴����أ��ʹ���û���ҵ�Ŀ��ڵ�
		return target;
	}
	
	//ɾ������
	public void delete(int i){
		//ɾ��������˼������Ȳ��ң��ҵ����ٽ���ɾ�������ڵ��ֵ��Ϊ�գ���ɾ������ɾ�����ӽڵ����µ���
		
		//�ȶ��常�ڵ㣬�Ӹ��ڵ㿪ʼ
		TreeNode parent=this;
		
		//�����ǰ�ڵ�����ӽڵ���Ŀ��ڵ㣬��ôɾ�����ӽڵ�
		if(parent.leftNode!=null&&parent.leftNode.value==i){
			parent.leftNode=null;
			return;
		}
		//�����ǰ�ڵ�����ӽڵ���Ŀ��ڵ㣬��ôɾ�����ӽڵ�
		if(parent.rightNode!=null&&parent.rightNode.value==i){
			parent.rightNode=null;
			return;
		}
		
		//���ӽڵ㲻��Ŀ��ڵ㣬�����ڵ����Ϊ���ӽڵ㣬�ٶ����ӽڵ�������ӽڵ����ɾ�����ң��ݹ鴦��
		parent=leftNode;
		if(parent!=null){
			parent.delete(i);
		}
		
		//���ӽڵ㲻��Ŀ��ڵ㣬�����ڵ����Ϊ���ӽڵ㣬�ٶ����ӽڵ�������ӽڵ����ɾ�����ң��ݹ鴦��
		parent=rightNode;
		if(parent!=null){
			parent.delete(i);
		}
		
		
	}
	
}
