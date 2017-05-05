import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Search {
 // search states	A*
	//ArrayList<State> states;
	private ArrayList<Edge> jobs;
	private Town start;
	private int nodes;


	public Search (ArrayList<Edge> jobs, Town start){
	
		this.jobs = jobs;
		this.start = start;
		this.nodes = 0;

		
	}
	
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
				System.out.println("finished");
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
				System.out.println(newState.getfx());


				queue.add(newState);
		
			}

			
			
		}
		System.out.println("hello");
		
		//while the open list is not empty
		    //find the node with the least f on the open list, call it "q"
		    //pop q off the open list
		    //generate q's 8 successors and set their parents to q
		    //for each successor
		    	//if successor is the goal, stop the search
		        //successor.g = q.g + distance between successor and q
		        //successor.h = distance from goal to successor
		        //successor.f = successor.g + successor.h
		        //if a node with the same position as successor is in the OPEN list \
		        //    which has a lower f than successor, skip this successor
		        //if a node with the same position as successor is in the CLOSED list \ 
		        //    which has a lower f than successor, skip this successor
		        //otherwise, add the node to the open list
		    //end
		    //push q on the closed list
		//end
		
		return state;
		
	}
	public int getNodesExpanded(){
		return nodes;
	}
}
