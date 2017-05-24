package com.dataStructures.main;

/**
 * The GraphSearchMain.
 * <p>
 * This class is responsible for providing a demo
 * of the graph searching (DFS and BFS).
 * <p>
 * <b>Warning: </b>None.
 * @author szeyick
 */
public class GraphSearchMain {

	/**
	 * The program main.
	 * @param args - Command line arguments.
	 */
	public static void main(String[] args) {
		Graph graph = new Graph();
		buildGraph(graph);
		
		System.out.println("Depth First Search:");
		System.out.println("Is there a path between 1 and 7 - " + graph.hasPathDFS(1, 7));
		System.out.println("Is there a path between 1 and 10 - " + graph.hasPathDFS(1, 10));
		System.out.println("Is there a path between 9 and 10 - " + graph.hasPathDFS(9, 10));
		
		System.out.println();
		
		System.out.println("Breadth First Search:");
		System.out.println("Is there a path between 1 and 7 - " + graph.hasPathBFS(1, 7));
		System.out.println("Is there a path between 1 and 10 - " + graph.hasPathBFS(1, 10));
		System.out.println("Is there a path between 9 and 10 - " + graph.hasPathBFS(9, 10));
	}
	
	/**
	 * @param graph - The graph.
	 */
	private static void buildGraph(Graph graph) {
		graph.addNode(1, 2);
		graph.addNode(1, 3);
		graph.addNode(1, 4);
		graph.addNode(1, 6);
		graph.addNode(2, 3);
		graph.addNode(3, 6);
		graph.addNode(6, 8);
		graph.addNode(8, 7);
		graph.addNode(5, 6);
		graph.addNode(9, 10);
	}

}
