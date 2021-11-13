package oop.exercises.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class AbstractGraph<N> implements Graph<N> {

	public static String NULL_EXCEPTION_MESSAGE = "node can't be null";
	
	private Set<N> nodes;
	private Set<Edge<N>> edges;
	
	public AbstractGraph() {
		this.nodes = new HashSet<N>();
		this.edges = new HashSet<Edge<N>>();
	}
	
	public void addNode(N node) {
		if (node == null) {
			throw new IllegalArgumentException(NULL_EXCEPTION_MESSAGE);
		}
		
		nodes.add(node);
	}
	
	public void addEdge(N source, N target) {
		if (source == null || target == null) {
			throw new IllegalArgumentException(NULL_EXCEPTION_MESSAGE);
		}
		
		this.edges.add(new Edge(source, target));
	}
	
	public Set<N> nodeSet() {
		return this.nodes;
	}
	
	public Set<Edge<N>> edgeSet() {
		return this.edges;
	}
	
	protected boolean isPresent(N node) {
		for(N n : this.nodes) {
			if(n.equals(node)) {
				return true;
			}
		}
		 return false;
	}
	
private List<N> recursivePathFinder(N node, N target, List<N> path) {
		
		if(node.equals(target)) {
			path.add(node);
			return path;
		}
		
		if(linkedNodes(node).isEmpty()) {
			return path;
		}
		
		path.add(node);		
		
		for(N adjNode : linkedNodes(node)) {
			path = recursivePathFinder(adjNode, target, path);
			
			if(path.get(path.size() - 1).equals(target)) {
				return path;
			}
		}
		
		return path;
	}

	@Override
	public List<N> getPath(N source, N target) {
		List<N> path = new ArrayList<N>();
		
		path.add(source);
		
		for(N node : linkedNodes(source)) {
			path = recursivePathFinder(node, target, path);
			
			if(path.get(path.size() - 1).equals(target)) {
				return path;
			}
		}
		
		
		return path;
	}
	
	public abstract String toString();
	
}
