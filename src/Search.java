import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

// TODO: Auto-generated Javadoc
/**
 * The Class Search.
 */
public class Search {
	/** The jobs. */
	private ArrayList<Edge> jobs;
	
	/** The start. */
	private Town start;
	
	/** The nodes. */
	private int nodes;


	/**
	 * Instantiates a new search.
	 *
	 * @param jobs the jobs
	 * @param start the start
	 */
	public Search (ArrayList<Edge> jobs, Town start){
	
		this.jobs = jobs;
		this.start = start;
		this.nodes = 0;

		
	}
	
	/**
	 * Astar.
	 *
	 * @return the state
	 */
	public State Astar(){
		// A*
		HashMap<State, Boolean> visited = new HashMap<State, Boolean>();
		Comparator<State> comparator = new StateComparator();
		PriorityQueue<State> queue = new PriorityQueue<State>(1,comparator);
		
		// (ArrayList<Edge> jobs, ArrayList<Town> visitedNodes, ArrayList<Edge> path,
				//Town curr, State prevState, int cost)
		ArrayList<Town> visitedNodes = new ArrayList<Town>();
		visitedNodes.add(start);
		
		State state = new State(jobs,visitedNodes, null,start,null);
		queue.add(state);
		
		
		
		while (!queue.isEmpty()){
			
			
			State curr = queue.poll();
			//System.out.println(curr.calculateTotalCost());
			nodes ++;
			//System.out.println(queue);
			
			// Goal state
			if (curr.jobsLeft()==0){
				return curr;
			
			}
			// check if state has been visited already
			if (visited.get(curr) == null) {
				visited.put(curr, true);
			} else {
				continue;
			}
			
			for (Edge edge : curr.getCurrent().getConnected()){
				ArrayList<Edge> path;
				ArrayList<Town> visitedTowns;
				
				if (curr.getPath() == null){
					path = new ArrayList<Edge>();
				} else {
					path= new ArrayList<Edge> (curr.getPath());
				}
				
				if (curr.getVisited() == null){
					visitedTowns = new ArrayList<Town>();
				} else {
					visitedTowns = new ArrayList<Town>(curr.getVisited());
				}
				path.add(edge);
				Town end = edge.getEnd();   
				visitedTowns.add(end);
				
				
				State newState = new State(jobs,visitedTowns ,path,end,curr);
				

				queue.add(newState);
		
			}

			
			
		}


		
		return state;
		
	}
	
	
	/**
	 * Gets the nodes expanded.
	 *
	 * @return the nodes expanded
	 */
	public int getNodesExpanded(){
		return nodes;
	}
}
