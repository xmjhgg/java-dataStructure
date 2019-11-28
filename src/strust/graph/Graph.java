package strust.graph;

public class Graph {
	//顶点数组
	Vertex[] vertexs;
	
	//顶点数组的下标
	int vcurrent;
	
	//邻接矩阵
	int[][] adjmt;
	
	//深度优先遍历时使用的栈
	Zhan stack=new Zhan();
	
	public Graph(int size){
		vertexs=new Vertex[size];
		adjmt=new int[size][size];
		
		//初始化邻接矩阵，每个点到自身都为1
		for (int i = 0; i < vertexs.length; i++) {
			adjmt[i][i]=1;
		}
	}
	
	//添加顶点到顶点数组
	public void addV(Vertex v){
		vertexs[vcurrent++]=v;
	}
	
	//添加路径
	public void addEdge(String v1,String v2){
		//v1的下标
		int index1=-1;
		//v2的下标
		int index2=-1;
		//找出v1和v2的下标
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
		//在邻接矩阵中设置v1到v2是连通的，因为是无向图，所以v2到v1也要设为连通
		adjmt[index1][index2]=1;
		adjmt[index2][index1]=1;
		
	}
	
	//深度优先遍历
	public void dfs(){
		
		//将第一个数的下标0压入栈中
		stack.push(0);
		//设置第一个数的为已经遍历过
		vertexs[0].issee=true;
		//输出当前节点
		System.out.println(vertexs[0].getV());
		//遍历的起点下标
		vcurrent=0;
		
		//如果栈不为空就说明还没遍历完成
		out:while(!stack.isnull()){
			
			//从0+1的位置开始遍历，如果在邻接矩阵中0和1之间有路径，并且1的issee为false就说明这个点还没有遍历过
			for (int i = vcurrent+1; i < vertexs.length; i++) {
				if (adjmt[vcurrent][i]==1&&vertexs[i].issee==false) {
					
					vertexs[i].issee=true;
					System.out.println(vertexs[i].getV());
					//遍历后把这个点的下标压入栈中
					stack.push(i);
					//跳出循环，返回out处，再从当前遍历的这个点作为起点开始遍历
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
