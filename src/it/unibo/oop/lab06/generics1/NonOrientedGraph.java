package oop.exercises.graph;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public class NonOrientedGraph<N> extends AbstractGraph<N> {

	@Override
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
			
			if(e.getTarget().equals(node)) {
				linkedNodes.add(e.getSource());
			}
		}
		
		return linkedNodes;
	}


	@Override
	public String toString() {
		String str = "NonOrientedGraph {";
		
		for(Edge e : this.edgeSet()) {
			str += "\n\t" + e.getSource() + " --- " + e.getTarget();
		}
		
		str += "\n}";
		
		return str;
	}

}
