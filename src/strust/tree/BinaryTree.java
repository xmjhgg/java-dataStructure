package strust.tree;

public class BinaryTree {
	
	//根节点
	TreeNode root;
	
	//用于临时保存前驱节点
	TreeNode pre;
	
	public void setRoot(TreeNode root) {
		this.root = root;
	}
	
	public void setLNode(TreeNode node){
		root.setLeftNode(node);
	}
	
	public void setRNode(TreeNode node){
		root.setRightNode(node);
	}
	
	//中序遍历
	public void fonrtshow(){
		if (root!=null) {
			root.frontShow();
		}
		
	}
	
	//查找节点
	public TreeNode frontSearch(int i){
		if (root!=null) {
			TreeNode target=root.frontSearch(i);
			return target;
		}
		return null;
		
	}
	
	//删除子树
	public void deldet(int i){
		if (root.value==i) {
			root=null;
		}else{
			root.delete(i);
		}
		
	}
	
	//中序线索化二叉树（先处理左节点，再处理当前节点，再处理右节点）
	public void threadTree(){
		threadTree(root);
	}
	
	public void threadTree(TreeNode node){
		
		//如果当前节点为空，递归结束return
		if (node==null) {
			return;
		}
		
		//处理左子节点
		threadTree(node.leftNode);
		
		//处理当前节点，如果当前节点的左子节点为空，那就把左子节点视为一个指针，并指向前驱节点，使节点和节点连接起来
		if (node.leftNode==null) {
			node.leftNode=pre;
			node.leftType=1;
			
		}
		
		//第一个条件是为了预防第一次传入时抛出的空指针异常
		//如果当前节点的前驱节点的右子节点为空，那么就把前驱节点的右子节点视为指针，指向当前节点，使得前驱节点和当前节点连接起来
		if (pre!=null&&pre.rightNode==null) {
			pre.rightNode=node;
			pre.rightType=1;
			
		}
		
		//记录当前的节点，作为递归方法中的前驱节点
		pre=node;
		
		//处理右子节点
		threadTree(node.rightNode);
	}
	
	//中序遍历线索二叉树
	public void threadTreeShow(){
		
		TreeNode node=root;
		
		//循环找到遍历的起点
		while(node!=null){
			while(node.leftType==0){
				node=node.leftNode;
			}
		
		
		//打印当前节点的值
		System.out.println(node.value);
		
		//如果当前节点的后继节点还有后继节点，那么这些后继节点也需要打印
		while(node.rightType==1){
			node=node.rightNode;
			System.out.println(node.value);
		}
		
		//上面的循环结束后，将当前节点已经处于左边的右叶子处，左边已经遍历完成，然后依靠右叶子的右指针把当前节点移动到根节点
		node=node.rightNode;
		
	}
	}
}
