package strust.tree;

public class TreeNode {
	
	int value;
	TreeNode leftNode;
	TreeNode rightNode;
	
	//如果leftType等于1，就说明左子节点指向前驱节点
	int leftType;
	//如果leftType等于1，就说明左子节点指向前驱节点
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
	
	//中序遍历
	public void frontShow(){
		//先遍历左子节点，直到所有的左子节点都遍历完
		if(leftNode!=null){
			leftNode.frontShow();
		}
		//打印当前节点
		System.out.print(this.value+"  ");
		//最后遍历右子节点
		if(rightNode!=null){
			rightNode.frontShow();
		}
	}
	
	//中序遍历的查找
	public TreeNode frontSearch(int i){
		//当前节点
		TreeNode target=null;
		//先遍历左子节点
		if(leftNode!=null){
			//让当前节点变成左子节点，继续进行递归查找
			target=leftNode.frontSearch(i);
		}
		//如果target不为空，那么就代表找到了目标
		if (target!=null) {
			return target;
		}
		else{
			//查找的结果与值相同，当前节点就是目标节点
			if(this.value==i){
				return this;
			}
			//最后查找右子节点
			if(rightNode!=null){
				target=rightNode.frontSearch(i);
			}
		}
		//在此处返回，就代表没有找到目标节点
		return target;
	}
	
	//删除子树
	public void delete(int i){
		//删除子树的思想就是先查找，找到后再进行删除（将节点的值置为空），删除将会删除左子节点以下的树
		
		//先定义父节点，从根节点开始
		TreeNode parent=this;
		
		//如果当前节点的左子节点是目标节点，那么删除左子节点
		if(parent.leftNode!=null&&parent.leftNode.value==i){
			parent.leftNode=null;
			return;
		}
		//如果当前节点的右子节点是目标节点，那么删除右子节点
		if(parent.rightNode!=null&&parent.rightNode.value==i){
			parent.rightNode=null;
			return;
		}
		
		//左子节点不是目标节点，将父节点更改为左子节点，再对左子节点的左右子节点进行删除查找，递归处理
		parent=leftNode;
		if(parent!=null){
			parent.delete(i);
		}
		
		//右子节点不是目标节点，将父节点更改为右子节点，再对右子节点的左右子节点进行删除查找，递归处理
		parent=rightNode;
		if(parent!=null){
			parent.delete(i);
		}
		
		
	}
	
}
