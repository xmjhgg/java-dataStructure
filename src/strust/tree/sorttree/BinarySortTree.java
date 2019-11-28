package strust.tree.sorttree;

public class BinarySortTree {
	Node root;
	
	public void add(Node node){
		//如果根节点是空，那么就把要添加的节点赋给根节点即可
		if (root==null) {
			root=node;
		//不为空就调用添加节点的方法
		}else{
			root.add(node);
		}
	}
	
	public void midShow(){
		if (root==null) {
			return;
		}
		root.midShow();
	}
	
	public Node search(int value){
		Node node=root.search(value);
		return node;
	}
	
	public Node searchParent(int value){
		if (root.value==value) {
			return root;
		}
		
		Node node=root.searchParent(value);
		return node;
	}
	
	public void delete(int value){
		Node node=search(value);
		Node nodeParent=searchParent(value);
		//如果是节点的左子节点和右子节点都是空那么这个节点就是叶子节点，那么直接让父节点的的子节点指向空即可
		if (node.left==null&&node.right==null) {
			if (nodeParent.left.value==value) {
				nodeParent.left=null;
			}else{
				nodeParent.right=null;
			}
		}else{
			
			//两个节点都不为空的情况下，那么要删除的时候只需要将后继节点的值覆盖到要删除的节点上，同时删除后继节点
			//而后继节点就是当前节点的右子树的左子树中最小的那个节点（从中序遍历中就可以看出，后继节点是比当前节点大一位的节点）
			if (node.left!=null&&node.right!=null) {
				//找出后继节点删除他，并返回后继节点的值
				int min=deleteMin(node.right);
				//赋值给当前节点
				node.value=min;
			}
			//一个节点为空的情况，还要判断当前节点是父节点的左子节点还是右子节点
			else{
				
				//有左子节点的情况
				if (node.left!=null) {
					//如果当前节点是父节点的左子节点
					if (nodeParent.left.value==value) {
						nodeParent.left=node.left;
					//如果当前节点是父节点的右子节点
					}else{
						nodeParent.right=node.left;
					}	
				}
				//有右子节点的情况
				else{
					//如果当前节点是父节点的左子节点
					if (nodeParent.left.value==value) {
						nodeParent.left=node.right;
					//如果当前节点是父节点的右子节点
					}else{
						nodeParent.right=node.right;
					}
					}
				}
		}
	}

	private int deleteMin(Node node) {
		Node target =node;
		
		//循环找出右子树的最小节点，最小节点一定会在左边（为什么一定在左边，是因为如果是在右边的话那么当前节点的值就会是右子节点的值，而不是左子节点）
		while (target.left!=null) {
			target=target.left;
		}
		//删除这个节点，如果这个节点还有一个右子节点，那么在delete方法中会自动的将右子节点补到当前节点的位置上。
		delete(target.value);
		
		//返回当前节点的值，用于替换要删除的节点
		return target.value;
	}
	
	
}
