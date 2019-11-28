package strust.tree.sorttree;

public class BinarySortTree {
	Node root;
	
	public void add(Node node){
		//������ڵ��ǿգ���ô�Ͱ�Ҫ��ӵĽڵ㸳�����ڵ㼴��
		if (root==null) {
			root=node;
		//��Ϊ�վ͵�����ӽڵ�ķ���
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
		//����ǽڵ�����ӽڵ�����ӽڵ㶼�ǿ���ô����ڵ����Ҷ�ӽڵ㣬��ôֱ���ø��ڵ�ĵ��ӽڵ�ָ��ռ���
		if (node.left==null&&node.right==null) {
			if (nodeParent.left.value==value) {
				nodeParent.left=null;
			}else{
				nodeParent.right=null;
			}
		}else{
			
			//�����ڵ㶼��Ϊ�յ�����£���ôҪɾ����ʱ��ֻ��Ҫ����̽ڵ��ֵ���ǵ�Ҫɾ���Ľڵ��ϣ�ͬʱɾ����̽ڵ�
			//����̽ڵ���ǵ�ǰ�ڵ��������������������С���Ǹ��ڵ㣨����������оͿ��Կ�������̽ڵ��Ǳȵ�ǰ�ڵ��һλ�Ľڵ㣩
			if (node.left!=null&&node.right!=null) {
				//�ҳ���̽ڵ�ɾ�����������غ�̽ڵ��ֵ
				int min=deleteMin(node.right);
				//��ֵ����ǰ�ڵ�
				node.value=min;
			}
			//һ���ڵ�Ϊ�յ��������Ҫ�жϵ�ǰ�ڵ��Ǹ��ڵ�����ӽڵ㻹�����ӽڵ�
			else{
				
				//�����ӽڵ�����
				if (node.left!=null) {
					//�����ǰ�ڵ��Ǹ��ڵ�����ӽڵ�
					if (nodeParent.left.value==value) {
						nodeParent.left=node.left;
					//�����ǰ�ڵ��Ǹ��ڵ�����ӽڵ�
					}else{
						nodeParent.right=node.left;
					}	
				}
				//�����ӽڵ�����
				else{
					//�����ǰ�ڵ��Ǹ��ڵ�����ӽڵ�
					if (nodeParent.left.value==value) {
						nodeParent.left=node.right;
					//�����ǰ�ڵ��Ǹ��ڵ�����ӽڵ�
					}else{
						nodeParent.right=node.right;
					}
					}
				}
		}
	}

	private int deleteMin(Node node) {
		Node target =node;
		
		//ѭ���ҳ�����������С�ڵ㣬��С�ڵ�һ��������ߣ�Ϊʲôһ������ߣ�����Ϊ��������ұߵĻ���ô��ǰ�ڵ��ֵ�ͻ������ӽڵ��ֵ�����������ӽڵ㣩
		while (target.left!=null) {
			target=target.left;
		}
		//ɾ������ڵ㣬�������ڵ㻹��һ�����ӽڵ㣬��ô��delete�����л��Զ��Ľ����ӽڵ㲹����ǰ�ڵ��λ���ϡ�
		delete(target.value);
		
		//���ص�ǰ�ڵ��ֵ�������滻Ҫɾ���Ľڵ�
		return target.value;
	}
	
	
}
