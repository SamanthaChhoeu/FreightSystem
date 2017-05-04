import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Search {
 // search states	A*
	//ArrayList<State> states;
	Queue<State> queue; 
	int cost;
	ArrayList<Edge> jobs;

	public Search (ArrayList<Edge> jobs, Town start){
		ArrayList<Town> visitedNodes = new ArrayList<Town>();
		visitedNodes.add(start);
		// (ArrayList<Edge> jobs, ArrayList<Town> visitedNodes, ArrayList<Edge> path,
		//Town curr, State prevState, int cost)

		State state = new State(jobs,visitedNodes, null,start,null,cost);
		this.queue = new LinkedList<State>(); // change this to priority queue
		this.jobs = jobs;
		queue.add(state);
		Astar();
		
	}
	
	public void Astar(){
		// A*
		
		
		while (!queue.isEmpty()){
	
			State curr = queue.element();		
	
			for (Edge edge : curr.getCurrent().getConnected()){
				ArrayList<Edge> path = curr.getPath();
				if (path == null){
					path = new ArrayList<Edge>();
				}
				path.add(edge);
				
				ArrayList<Town> visited = curr.getVisited();
				
				Town end = edge.getEnd();
				
				if (visited == null){
					visited = new ArrayList<Town>();
				}
				visited.add(end);
				
				System.out.print(queue);
				
				State newState = new State(jobs,visited ,path,end,curr,cost);
				
				queue.add(newState);
				
			}
	
		
			
			
			
		}
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
		
	}
}
