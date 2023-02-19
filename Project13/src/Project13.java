import java.util.*;

//Class of the Node for the graph
class GraphNode {
	int pointNum;
	ArrayList<Integer> connectedNodes; // Vector to hold the adjacent nodes
	
	GraphNode (int pNum) {
		this.pointNum = pNum;
		connectedNodes = new ArrayList<Integer>();
	}
}

//Class of the Graph 
class Graph {
	public int Vert; //Number of vertices
	public ArrayList<Integer> V[]; // Storing the adjacent nodes
	
	Graph (int totalVert) {
		Vert = totalVert;
	}
	
	// Function to add the nodes and adjacent nodes
	ArrayList<Integer>[] addGraphNode(ArrayList<Integer> adj[], 
								 int node, int adjNode) {
		V = adj;
		V[node].add(adjNode);
		return V;
		}
	
		// Recursive function for the topologicalSort
		void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack) {
		
		// Mark the current node as visited.
		visited[v] = true;
		Integer i;

		// Recursive for all the vertices adjacent to this vertex
		Iterator<Integer> it = V[v].iterator();
		while (it.hasNext()) {
			i = it.next();
			if (!visited[i])
				topologicalSortUtil(i, visited, stack);
		}
		
		// Push current vertex to stack to store result
		stack.push(new Integer(v));
		}
		
		// Function for the toplogicalSort using topologicalSortUtil
		void topologicalSort() {
		Stack<Integer> stack = new Stack<Integer>();

		// Mark all the vertices as not visited
		boolean visited[] = new boolean[Vert];
		for (int i = 0; i < Vert; i++)
			visited[i] = false;

		//  Recursive helper function to store Topological Sort starting from 
		//  all vertices one by one
		for (int i = 0; i < Vert; i++)
			if (visited[i] == false)
				topologicalSortUtil(i, visited, stack);

		// Display the contents of stack
		while (stack.empty()==false)
			System.out.print(stack.pop() + " ");
		}
}
public class Project13 {

	public static void main(String[] args) {
		// 2D array to the store the connection information
        ArrayList<Integer> adj[]
            = new ArrayList[4];
        
        for (int i = 0; i < 4; i++)
            adj[i] = new ArrayList();

	
		Graph graph = new Graph(4);
		graph.addGraphNode(adj,0, 1);
		graph.addGraphNode(adj, 0, 2);
		graph.addGraphNode(adj, 1, 2);
		graph.addGraphNode(adj, 2, 3);

		System.out.println("A Topological Sort of the Graph");
		System.out.println();
		graph.topologicalSort();
	}

}
