package oop.exercises.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public class OrientedGraph<N> extends AbstractGraph<N> {

	public Set<N> linkedNodes(N node) {
		if(node == null) {
			throw new IllegalArgumentException(AbstractGraph.NULL_EXCEPTION_MESSAGE);
		}
		
		if(!isPresent(node)) {
			throw new NoSuchElementException();
		}
		
		Set<N> linkedNodes = new HashSet<>();
		
		for(Edge<N> e : this.edgeSet()) {
			if(e.getSource().equals(node)) {
				linkedNodes.add(e.getTarget());
			}
		}
		
		return linkedNodes;
	}
	
	

	@Override
	public String toString() {
		String str = "OrientedGraph {";
		
		for(Edge e : this.edgeSet()) {
			str += "\n\t" + e.getSource() + " --> " + e.getTarget();
		}
		
		str += "\n}";
		
		return str;
	}

}
