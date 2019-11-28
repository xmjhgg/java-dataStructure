package strust.tree.sorttree;

public class Node {
	int value;
	Node left;
	Node right;
	public Node(int value){
		this.value=value;
	}
	
	//获取节点树高度
	public int getHight(){
		//取左子树和右子树中高度最大的值，进行递归，每递归到存在一个左节点或右节点，那么高度就+1，知道左子节点和右子节点都为空
		return Math.max(left==null?0:left.getHight(), right==null?0:right.getHight())+1;
	}
	
	
	//获取左子树的高度
	public int getLeftHight(){
		if (left==null) {
			return 0;
		}
		return left.getHight();
	}
	
	//获取右子树的高度
	public int getRightHight(){
		if (right==null) {
			return 0;
		}
		return right.getHight();
	}
	
	
	//添加节点
	public void add(Node node) {
		//如果node是空那么直接返回
		if (node==null) {
			return;
		}
		//如果当前节点大于要添加的节点，那么就要添加的节点放到左子节点
		if (this.value>node.value) {
			//如果左子节点为空，那就直接赋值
			if (this.left==null) {
				this.left=node;
				//如果不为空，那么继续递归左子节点，直到找到最后一个为空的左子节点，或者右子节点
			}else{
				this.left.add(node);
			}
			//如果小于，同理上面
		}else{
			if (this.right==null) {
				this.right=node;				
			}else{
				this.right.add(node);
			}
		}
		
		//平衡二叉树的高度控制
		//如果左子树的高度大于右子树的高度超过1，就需要进行右旋转，降低左子树的高度
		if (getLeftHight()-getRightHight()>1) {
			
			//再进行一次判断，如果左子树的左子树的高度小于右子树，那么就需要先对左子树进行一次左旋转，
			//降低右子树的高度，否则只光靠右旋转也无法达到平衡二叉树，这称为双旋转
			//双旋转
			if (left!=null&&left.getLeftHight()<left.getRightHight()) {
				leftRotate(left);
				rightRotate(this);
			//单旋转
			}else{
				rightRotate(this);
			}
		}
		//如果右子树的高度大于左子树的高度超过1，就需要进行左旋转，降低右子树的高度
		//如果右子树的右子树的高度小于左子树，那么就需要对右子树先进行一次右旋转，再对当前节点进行左旋转
		if (right!=null&&getRightHight()-getLeftHight()>1) {
			if (right.getRightHight()<right.getLeftHight()) {
				rightRotate(right);
				rightRotate(this);
			}else{
				leftRotate(this);
			}
		}
	}
	
	
	/**
	 * 平衡二叉排序树树是为了防止二叉排序树过高，二叉排序树的一个升级版
	 * 比如每个节点的值都会大于前驱节点，那么这些节点都会处于前驱节点的右子树，让整颗树的高度变高，极大的降低了二叉排序树的查找效率
	 * 平衡二叉排序树控制每个节点的左子树和右子树的高度差不会超过1。防止了类似上面的这种情况。
	 **/
	
	/**
	 * 构建平衡二叉排序树，右旋转，右旋转就是将当前节点和他的右子树转换到当前节点的左子树的右子树处，
	 * 如果当前节点的左子树有右子树，那么就需要将这颗右子树转换到当前节点的左子树处（因为左子树的值一定会小于当前节点）
	 * 步骤：
	 * 1.判断节点插入后，root节点的左子树的高度是否大于右子树的高度超过1，
	 * 如果大于就需要进行右旋转，降低左子树的高度（随着旋转，root也会发生改变，所以可以 一直以root作为基准来判断）
	 * 2.右旋转的步骤：
	 * 1.创建一个新的节点，值等于当前的节点
	 * 2.将当前节点的右子树赋给新的节点
	 * 3.如果当前节点的左子节点有右子节点，那么将这个右子节点赋给新建节点的左子树
	 * (因为我们要将当前节点更改为当前节点的左子节点，不能让这个左子节点的右子树平白消失)
	 * 4.将当前节点的值改为当前节点的左子节点的值
	 * 5.将新建节点赋给当前节点的右子节点
	 * 6.删除当前节点的左子节点（因为在3中，已经将左子节点的值赋给当前节点了），就是将当前节点的左子节点的左子节点赋给当前节点的左子节点
	 **/
	//右旋转
	public  void  rightRotate(Node node){
		//1
		Node newRight=new Node(node.value);
		//2
		newRight.right=node.right;
		//3
		if (node.left.right!=null) {
			newRight.left=node.left.right;
		}
		//4
		node.value=node.left.value;
		//5
		node.right=newRight;
		//6
		node.left=node.left.left;
	}
	
	//左旋转,右子树的高度大于左子树超过1,与右旋转左右调换即可，将当前节点的左子树赋给当前节点的右子树的左子树
	public void leftRotate(Node node){
		//创建一个新的左子节点
		Node newLeft=new Node(this.value);
		//新建的左子树=当前节点的左子树
		newLeft.left=node.left;
		//如果当前节点的右子树还存在左子树，那就将这棵树赋给新建节点的右子树（因为新建的节点要作为当前节点的右子树的左子树，右子树是一定大于左子树的 ）
		if (node.right.left!=null) {
			newLeft.right=node.right.left;
		}
		//将当前节点的值改为右子树的值
		node.value=node.right.value;
		//将当前节点的左子树赋为新建的左子节点
		node.left=newLeft;
		//删除当前节点右子树
		node.right=node.right.right;
		
	}
	
	
	
	//中序遍历
	public void midShow(){
		if (this.left!=null) {
			this.left.midShow();
		}
		System.out.print(this.value+" ");
		if (this.right!=null) {
			this.right.midShow();
		}

	}


	//查找节点
	public Node search(int value) {
		
		//如果当前节点的值等于要查找的值那么返回这个节点
		if (this.value==value) {
			return this;
		}
		
		//如果当前节点大于要查找的值，那么就从左边节点开始遍历
		if (this.value>value) {
			if (this.left!=null) {
				return this.left.search(value);
			}
			//反之从右边开始遍历
		}else{
			if (this.right!=null) {
				return this.right.search(value);
			}
		}
		
		return null;
		//如果是当前值和目标值相同就返回
//		if (this.value==value) {
//			return this;
//		}
		//经过上的if，没又返回，就说明目标节点不是当前节点，从左子节点再次开始遍历
//		if (this.left!=null) {
//			return this.left.search(value);
//		}
//		
//		if (this.right!=null) {
//			return this.right.search(value);
//		}
//		经过上面的三个if还是没有找到就说明整棵树中没有目标节点，返回null;
//		 return null;
//		出错原因：
//		个人猜想，因为上面是先遍历左边，如果要查找的值在右边 那么就会
//		因为左边先返回了null而把真实的数据覆盖了，而且没有使用二叉排序树的思想

	}
	
	//查找父节点（为删除节点做准备）
	public Node searchParent(int value){
		
		//如果当前节点的左右子节点都不为空，并且要查找的值有与当前节点的左右子节点相等，那么就返回这个父节点
		if (this.left!=null&&this.left.value==value||this.right!=null&&this.right.value==value) {
			return this;
		//如果没有，那么根据要查找的值的大小来选择从左边开始遍历还是从右边
		}else{
			if (this.value>value&&this.left!=null) {
				return this.left.searchParent(value);
			}else{
				if (this.value<value&&this.right!=null) {
					return this.right.searchParent(value);
				}
			}
		}
		
		return null;
	}

	
}
