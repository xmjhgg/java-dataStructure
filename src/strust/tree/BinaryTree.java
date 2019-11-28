package strust.tree;

public class BinaryTree {
	
	//���ڵ�
	TreeNode root;
	
	//������ʱ����ǰ���ڵ�
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
	
	//�������
	public void fonrtshow(){
		if (root!=null) {
			root.frontShow();
		}
		
	}
	
	//���ҽڵ�
	public TreeNode frontSearch(int i){
		if (root!=null) {
			TreeNode target=root.frontSearch(i);
			return target;
		}
		return null;
		
	}
	
	//ɾ������
	public void deldet(int i){
		if (root.value==i) {
			root=null;
		}else{
			root.delete(i);
		}
		
	}
	
	//�������������������ȴ�����ڵ㣬�ٴ���ǰ�ڵ㣬�ٴ����ҽڵ㣩
	public void threadTree(){
		threadTree(root);
	}
	
	public void threadTree(TreeNode node){
		
		//�����ǰ�ڵ�Ϊ�գ��ݹ����return
		if (node==null) {
			return;
		}
		
		//�������ӽڵ�
		threadTree(node.leftNode);
		
		//����ǰ�ڵ㣬�����ǰ�ڵ�����ӽڵ�Ϊ�գ��ǾͰ����ӽڵ���Ϊһ��ָ�룬��ָ��ǰ���ڵ㣬ʹ�ڵ�ͽڵ���������
		if (node.leftNode==null) {
			node.leftNode=pre;
			node.leftType=1;
			
		}
		
		//��һ��������Ϊ��Ԥ����һ�δ���ʱ�׳��Ŀ�ָ���쳣
		//�����ǰ�ڵ��ǰ���ڵ�����ӽڵ�Ϊ�գ���ô�Ͱ�ǰ���ڵ�����ӽڵ���Ϊָ�룬ָ��ǰ�ڵ㣬ʹ��ǰ���ڵ�͵�ǰ�ڵ���������
		if (pre!=null&&pre.rightNode==null) {
			pre.rightNode=node;
			pre.rightType=1;
			
		}
		
		//��¼��ǰ�Ľڵ㣬��Ϊ�ݹ鷽���е�ǰ���ڵ�
		pre=node;
		
		//�������ӽڵ�
		threadTree(node.rightNode);
	}
	
	//�����������������
	public void threadTreeShow(){
		
		TreeNode node=root;
		
		//ѭ���ҵ����������
		while(node!=null){
			while(node.leftType==0){
				node=node.leftNode;
			}
		
		
		//��ӡ��ǰ�ڵ��ֵ
		System.out.println(node.value);
		
		//�����ǰ�ڵ�ĺ�̽ڵ㻹�к�̽ڵ㣬��ô��Щ��̽ڵ�Ҳ��Ҫ��ӡ
		while(node.rightType==1){
			node=node.rightNode;
			System.out.println(node.value);
		}
		
		//�����ѭ�������󣬽���ǰ�ڵ��Ѿ�������ߵ���Ҷ�Ӵ�������Ѿ�������ɣ�Ȼ��������Ҷ�ӵ���ָ��ѵ�ǰ�ڵ��ƶ������ڵ�
		node=node.rightNode;
		
	}
	}
}
