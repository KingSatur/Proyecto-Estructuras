package graph.Directed;

import java.util.Comparator;

public class EdgeCompare implements Comparator<Edge>{

	@Override
	public int compare(Edge o1, Edge o2) {
		if(o1.getWeightKey() < o2.getWeightKey()) {
			return -1;
		}
		else {
			return 1;
		}		
	}

}
