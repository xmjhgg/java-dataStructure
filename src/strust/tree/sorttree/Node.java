package strust.tree.sorttree;

public class Node {
	int value;
	Node left;
	Node right;
	public Node(int value){
		this.value=value;
	}
	
	//��ȡ�ڵ����߶�
	public int getHight(){
		//ȡ���������������и߶�����ֵ�����еݹ飬ÿ�ݹ鵽����һ����ڵ���ҽڵ㣬��ô�߶Ⱦ�+1��֪�����ӽڵ�����ӽڵ㶼Ϊ��
		return Math.max(left==null?0:left.getHight(), right==null?0:right.getHight())+1;
	}
	
	
	//��ȡ�������ĸ߶�
	public int getLeftHight(){
		if (left==null) {
			return 0;
		}
		return left.getHight();
	}
	
	//��ȡ�������ĸ߶�
	public int getRightHight(){
		if (right==null) {
			return 0;
		}
		return right.getHight();
	}
	
	
	//��ӽڵ�
	public void add(Node node) {
		//���node�ǿ���ôֱ�ӷ���
		if (node==null) {
			return;
		}
		//�����ǰ�ڵ����Ҫ��ӵĽڵ㣬��ô��Ҫ��ӵĽڵ�ŵ����ӽڵ�
		if (this.value>node.value) {
			//������ӽڵ�Ϊ�գ��Ǿ�ֱ�Ӹ�ֵ
			if (this.left==null) {
				this.left=node;
				//�����Ϊ�գ���ô�����ݹ����ӽڵ㣬ֱ���ҵ����һ��Ϊ�յ����ӽڵ㣬�������ӽڵ�
			}else{
				this.left.add(node);
			}
			//���С�ڣ�ͬ������
		}else{
			if (this.right==null) {
				this.right=node;				
			}else{
				this.right.add(node);
			}
		}
		
		//ƽ��������ĸ߶ȿ���
		//����������ĸ߶ȴ����������ĸ߶ȳ���1������Ҫ��������ת�������������ĸ߶�
		if (getLeftHight()-getRightHight()>1) {
			
			//�ٽ���һ���жϣ�������������������ĸ߶�С������������ô����Ҫ�ȶ�����������һ������ת��
			//�����������ĸ߶ȣ�����ֻ�⿿����תҲ�޷��ﵽƽ������������Ϊ˫��ת
			//˫��ת
			if (left!=null&&left.getLeftHight()<left.getRightHight()) {
				leftRotate(left);
				rightRotate(this);
			//����ת
			}else{
				rightRotate(this);
			}
		}
		//����������ĸ߶ȴ����������ĸ߶ȳ���1������Ҫ��������ת�������������ĸ߶�
		//������������������ĸ߶�С������������ô����Ҫ���������Ƚ���һ������ת���ٶԵ�ǰ�ڵ��������ת
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
	 * ƽ���������������Ϊ�˷�ֹ�������������ߣ�������������һ��������
	 * ����ÿ���ڵ��ֵ�������ǰ���ڵ㣬��ô��Щ�ڵ㶼�ᴦ��ǰ���ڵ�������������������ĸ߶ȱ�ߣ�����Ľ����˶����������Ĳ���Ч��
	 * ƽ���������������ÿ���ڵ�����������������ĸ߶Ȳ�ᳬ��1����ֹ��������������������
	 **/
	
	/**
	 * ����ƽ�����������������ת������ת���ǽ���ǰ�ڵ������������ת������ǰ�ڵ��������������������
	 * �����ǰ�ڵ��������������������ô����Ҫ�����������ת������ǰ�ڵ��������������Ϊ��������ֵһ����С�ڵ�ǰ�ڵ㣩
	 * ���裺
	 * 1.�жϽڵ�����root�ڵ���������ĸ߶��Ƿ�����������ĸ߶ȳ���1��
	 * ������ھ���Ҫ��������ת�������������ĸ߶ȣ�������ת��rootҲ�ᷢ���ı䣬���Կ��� һֱ��root��Ϊ��׼���жϣ�
	 * 2.����ת�Ĳ��裺
	 * 1.����һ���µĽڵ㣬ֵ���ڵ�ǰ�Ľڵ�
	 * 2.����ǰ�ڵ�������������µĽڵ�
	 * 3.�����ǰ�ڵ�����ӽڵ������ӽڵ㣬��ô��������ӽڵ㸳���½��ڵ��������
	 * (��Ϊ����Ҫ����ǰ�ڵ����Ϊ��ǰ�ڵ�����ӽڵ㣬������������ӽڵ��������ƽ����ʧ)
	 * 4.����ǰ�ڵ��ֵ��Ϊ��ǰ�ڵ�����ӽڵ��ֵ
	 * 5.���½��ڵ㸳����ǰ�ڵ�����ӽڵ�
	 * 6.ɾ����ǰ�ڵ�����ӽڵ㣨��Ϊ��3�У��Ѿ������ӽڵ��ֵ������ǰ�ڵ��ˣ������ǽ���ǰ�ڵ�����ӽڵ�����ӽڵ㸳����ǰ�ڵ�����ӽڵ�
	 **/
	//����ת
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
	
	//����ת,�������ĸ߶ȴ�������������1,������ת���ҵ������ɣ�����ǰ�ڵ��������������ǰ�ڵ����������������
	public void leftRotate(Node node){
		//����һ���µ����ӽڵ�
		Node newLeft=new Node(this.value);
		//�½���������=��ǰ�ڵ��������
		newLeft.left=node.left;
		//�����ǰ�ڵ�����������������������Ǿͽ�����������½��ڵ������������Ϊ�½��Ľڵ�Ҫ��Ϊ��ǰ�ڵ��������������������������һ�������������� ��
		if (node.right.left!=null) {
			newLeft.right=node.right.left;
		}
		//����ǰ�ڵ��ֵ��Ϊ��������ֵ
		node.value=node.right.value;
		//����ǰ�ڵ����������Ϊ�½������ӽڵ�
		node.left=newLeft;
		//ɾ����ǰ�ڵ�������
		node.right=node.right.right;
		
	}
	
	
	
	//�������
	public void midShow(){
		if (this.left!=null) {
			this.left.midShow();
		}
		System.out.print(this.value+" ");
		if (this.right!=null) {
			this.right.midShow();
		}

	}


	//���ҽڵ�
	public Node search(int value) {
		
		//�����ǰ�ڵ��ֵ����Ҫ���ҵ�ֵ��ô��������ڵ�
		if (this.value==value) {
			return this;
		}
		
		//�����ǰ�ڵ����Ҫ���ҵ�ֵ����ô�ʹ���߽ڵ㿪ʼ����
		if (this.value>value) {
			if (this.left!=null) {
				return this.left.search(value);
			}
			//��֮���ұ߿�ʼ����
		}else{
			if (this.right!=null) {
				return this.right.search(value);
			}
		}
		
		return null;
		//����ǵ�ǰֵ��Ŀ��ֵ��ͬ�ͷ���
//		if (this.value==value) {
//			return this;
//		}
		//�����ϵ�if��û�ַ��أ���˵��Ŀ��ڵ㲻�ǵ�ǰ�ڵ㣬�����ӽڵ��ٴο�ʼ����
//		if (this.left!=null) {
//			return this.left.search(value);
//		}
//		
//		if (this.right!=null) {
//			return this.right.search(value);
//		}
//		�������������if����û���ҵ���˵����������û��Ŀ��ڵ㣬����null;
//		 return null;
//		����ԭ��
//		���˲��룬��Ϊ�������ȱ�����ߣ����Ҫ���ҵ�ֵ���ұ� ��ô�ͻ�
//		��Ϊ����ȷ�����null������ʵ�����ݸ����ˣ�����û��ʹ�ö�����������˼��

	}
	
	//���Ҹ��ڵ㣨Ϊɾ���ڵ���׼����
	public Node searchParent(int value){
		
		//�����ǰ�ڵ�������ӽڵ㶼��Ϊ�գ�����Ҫ���ҵ�ֵ���뵱ǰ�ڵ�������ӽڵ���ȣ���ô�ͷ���������ڵ�
		if (this.left!=null&&this.left.value==value||this.right!=null&&this.right.value==value) {
			return this;
		//���û�У���ô����Ҫ���ҵ�ֵ�Ĵ�С��ѡ�����߿�ʼ�������Ǵ��ұ�
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
