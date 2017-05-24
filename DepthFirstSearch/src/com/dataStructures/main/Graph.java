package com.dataStructures.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * The Graph.
 * <p>
 * This class is responsible for being the graph 
 * data structure. It contains a set of nodes that 
 * make up the graph that can be searched using depth
 * first search.
 * <p>
 * <b>Warning: </b>None.
 * @author szeyick
 */
public class Graph {

	/**
	 * A collection that represents the graph. The key for this
	 * map is the node ID that is mapped to the node itself.
	 */
	private Map<Integer, Node> graph;

	/**
	 * Constructor.
	 */
	public Graph() {
		graph = new HashMap<>();
	}
	
	/**
	 * Connect two nodes together and add to the graph.
	 * @param sourceNodeId - The source node.
	 * @param destinatonNodeId - The node it is connected to.
	 */
	public void addNode(int sourceNodeId, int destinatonNodeId) {
		Node sourceNode = graph.get(sourceNodeId);
		Node destinationNode = graph.get(destinatonNodeId);
		if (sourceNode == null && destinationNode == null) {
			sourceNode = new Node(sourceNodeId);
			destinationNode = new Node(destinatonNodeId);
			updateGraph(sourceNode, destinationNode);
		}
		else if (sourceNode == null && destinationNode != null) {
			sourceNode = new Node(sourceNodeId);
			updateGraph(sourceNode, destinationNode);
		}
		else if (sourceNode != null && destinationNode == null) {
			destinationNode = new Node(destinatonNodeId);
			updateGraph(sourceNode, destinationNode);
		}
		else if (sourceNode != null && destinationNode != null && (alreadyConnected(sourceNode, destinationNode))) {
			updateGraph(sourceNode, destinationNode);
		}
	}
	
	/**
	 * @param sourceNode - The source node to update the graph with.
	 * @param destinationNode - The destination node to update the graph with.
	 */
	private void updateGraph(Node sourceNode, Node destinationNode) {
		sourceNode.adjacentNodes.add(destinationNode);
		destinationNode.adjacentNodes.add(sourceNode);
		
		graph.put(sourceNode.id, sourceNode);
		graph.put(destinationNode.id, destinationNode);
	}
	
	/**
	 * @param sourceNode - The source node.
	 * @param destinationNode - The destination node.
	 * @return <code>true</code> if the nodes are already connected, <code>false</code> otherwise.
	 */
	private boolean alreadyConnected(Node sourceNode, Node destinationNode) {
		return sourceNode.adjacentNodes.contains(destinationNode);
	}
	
	/**
	 * @param sourceNodeId - The source node id.
	 * @param destinationNodeId - The destination node id.
	 * @return <code>true</code> if there is a path from the source to destination, <code>false</code> otherwise.
	 */
	public boolean hasPathDFS(int sourceNodeId, int destinationNodeId) {
		boolean pathExists = false;
		Node sourceNode = graph.get(sourceNodeId);
		Node destinationNode = graph.get(destinationNodeId);
		Set<Node> visited = new HashSet<>();
		if (sourceNode != null && destinationNode != null) {
			pathExists = hasPathDFS(sourceNode, destinationNode, visited);
		}
		return pathExists;
	}
	
	/**
	 * @param sourceNode - The source node.
	 * @param destinationNode - The destination node.
	 * @param visited - A set of visited nodes.
	 * @return <code>true</code> if there is a path from the source to destination, <code>false</code> otherwise.
	 */
	private boolean hasPathDFS(Node sourceNode, Node destinationNode, Set<Node> visited) {
		Node currentNode = sourceNode;
		if (visited.contains(sourceNode)) {
			return false; // If we have already visited this node, then there is no path.
		}
		visited.add(currentNode); // Add the current node and mark it as visited
		if (currentNode.id == destinationNode.id) {
			return true; // If we have arrived at our destination, then there is a path.
		}
		for (Node adjacentNode : currentNode.adjacentNodes) {
			// Loop through its adjacent nodes and continue the search.
			if(hasPathDFS(adjacentNode, destinationNode, visited)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @param sourceNodeId - The source node.
	 * @param destinationNodeId - The destination node.
	 * @return <code>true</code> if there is path that exists between the two, <code>false</code> otherwise.
	 */
	public boolean hasPathBFS(int sourceNodeId, int destinationNodeId) {
		boolean pathExists = false;
		Node sourceNode = graph.get(sourceNodeId);
		Node destinationNode = graph.get(destinationNodeId);
		if (sourceNode != null && destinationNode != null) {
			pathExists = hasPathBFS(sourceNode, destinationNode);
		}
		return pathExists;
	}
	
	/**
	 * @param sourceNode - The source node.
	 * @param destinationNode - The destination node.
	 * @return <code>true</code> if there is a path that exists between the two, <code>false</code> otherwise.
	 */
	private boolean hasPathBFS(Node sourceNode, Node destinationNode) {
		LinkedList<Node> nodeQueue = new LinkedList<>();
		Set<Node> visited = new HashSet<>();
		
		nodeQueue.add(sourceNode);
		while(!nodeQueue.isEmpty()) {
			Node currentNode = nodeQueue.poll();
			if (currentNode == destinationNode) {
				return true;
			}
			if (visited.contains(currentNode)) {
				continue; // Process the next item immediately if we've already visited this node.
			}
			visited.add(currentNode);
			for (Node adjacentNodes : currentNode.adjacentNodes) {
				nodeQueue.add(adjacentNodes);
			}
		}
		return false; // If we loop through all the items and have not returned, then there is no path.
	}
	
	/**
	 * The Node.
	 * <p>
	 * This inner class represents a single node
	 * in a graph. It contains the id along with
	 * references to its neighbours (adjacent nodes)
	 * <p>
	 * <b>Warning: <b>None.
	 * <p>
	 * @author szeyick
	 */
	private class Node {
	
		/**
		 * The value contained by this node.
		 */
		private int id;
		
		/**
		 * A list of nodes that this node is connected to.
		 */
		private List<Node> adjacentNodes;
		
		/**
		 * Constructor.
		 * @param id - The value to store in this node.
		 */
		public Node(int id) {
			this.id = id;
			adjacentNodes = new ArrayList<>();
		}
	}
}
