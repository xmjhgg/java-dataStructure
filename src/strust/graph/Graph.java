package strust.graph;

public class Graph {
	//��������
	Vertex[] vertexs;
	
	//����������±�
	int vcurrent;
	
	//�ڽӾ���
	int[][] adjmt;
	
	//������ȱ���ʱʹ�õ�ջ
	Zhan stack=new Zhan();
	
	public Graph(int size){
		vertexs=new Vertex[size];
		adjmt=new int[size][size];
		
		//��ʼ���ڽӾ���ÿ���㵽����Ϊ1
		for (int i = 0; i < vertexs.length; i++) {
			adjmt[i][i]=1;
		}
	}
	
	//��Ӷ��㵽��������
	public void addV(Vertex v){
		vertexs[vcurrent++]=v;
	}
	
	//���·��
	public void addEdge(String v1,String v2){
		//v1���±�
		int index1=-1;
		//v2���±�
		int index2=-1;
		//�ҳ�v1��v2���±�
		for (int i = 0; i < vertexs.length; i++) {
			if (vertexs[i].getV()==v1) {
				index1=i;
				break;
			}
		}
		for (int i = 0; i < vertexs.length; i++) {
			if (vertexs[i].getV()==v2) {
				index2=i;
				break;
			}
		}
		//���ڽӾ���������v1��v2����ͨ�ģ���Ϊ������ͼ������v2��v1ҲҪ��Ϊ��ͨ
		adjmt[index1][index2]=1;
		adjmt[index2][index1]=1;
		
	}
	
	//������ȱ���
	public void dfs(){
		
		//����һ�������±�0ѹ��ջ��
		stack.push(0);
		//���õ�һ������Ϊ�Ѿ�������
		vertexs[0].issee=true;
		//�����ǰ�ڵ�
		System.out.println(vertexs[0].getV());
		//����������±�
		vcurrent=0;
		
		//���ջ��Ϊ�վ�˵����û�������
		out:while(!stack.isnull()){
			
			//��0+1��λ�ÿ�ʼ������������ڽӾ�����0��1֮����·��������1��isseeΪfalse��˵������㻹û�б�����
			for (int i = vcurrent+1; i < vertexs.length; i++) {
				if (adjmt[vcurrent][i]==1&&vertexs[i].issee==false) {
					
					vertexs[i].issee=true;
					System.out.println(vertexs[i].getV());
					//��������������±�ѹ��ջ��
					stack.push(i);
					//����ѭ��������out�����ٴӵ�ǰ�������������Ϊ��㿪ʼ����
					continue out;
				}
				
			}
			//
			stack.pop();
			if (!stack.isnull()) {
				vcurrent=stack.peek();
			}
		}
	}
	
	
	
	
}	
