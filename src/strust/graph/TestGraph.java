package strust.graph;

import java.util.Arrays;

public class TestGraph {
	public static void main(String[] args) {
		Vertex v1=new Vertex("A");
		Vertex v2=new Vertex("B");
		Vertex v3=new Vertex("C");
		Vertex v4=new Vertex("D");
		Vertex v5=new Vertex("E");
		
		Graph g=new Graph(5);
		
		g.addV(v1);
		g.addV(v2);
		g.addV(v3);
		g.addV(v4);
		g.addV(v5);
		
//		System.out.println(Arrays.toString(g.vertexs));
		System.out.println("A"=="A");
		
		g.addEdge("A", "B");
		g.addEdge("B", "C");
		g.addEdge("A", "C");
		g.addEdge("D", "B");
		g.addEdge("E", "B");
		
		for (int[] a:g.adjmt) {
			System.out.println(Arrays.toString(a));
		}
		
		g.dfs();
		
		
	}
}
