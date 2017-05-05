import java.util.ArrayList;
import java.util.Comparator;
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
		
		Comparator<State> comparator = new StateComparator();
		PriorityQueue<State> queue = new PriorityQueue<State>(1, comparator);
		
		// (ArrayList<Edge> jobs, ArrayList<Town> visitedNodes, ArrayList<Edge> path,
				//Town curr, State prevState, int cost)
		ArrayList<Town> visitedNodes = new ArrayList<Town>();
		visitedNodes.add(start);
		
		State state = new State(jobs,visitedNodes, null,start,null);
		queue.add(state);
		
		
		
		while (!queue.isEmpty()){
			
			
			State curr = queue.remove();
			//System.out.println(curr.calculateTotalCost());
			nodes += 1;
			//System.out.println(queue);
			
			for (Edge edge : curr.getCurrent().getConnected()){
				ArrayList<Edge> path;
				ArrayList<Town> visited;
				
				if (curr.getPath() == null){
					path = new ArrayList<Edge>();
				} else {
					path= new ArrayList<Edge> (curr.getPath());
				}
				
				if (curr.getVisited() == null){
					visited = new ArrayList<Town>();
				} else {
					visited = new ArrayList<Town>(curr.getVisited());
				}
				path.add(edge);
				Town end = edge.getEnd();   
				visited.add(end);
				//System.out.println("added"+end.getName());
				///for (State test:queue){
				//	System.out.print(test.getCurrent().getName()+" ");
				//}
				
				System.out.println("-----------------------------------------------------");
				//for (Town town:visited){
				//	System.out.println(town.getName());
				//}
			
				
				
				
				State newState = new State(jobs,visited ,path,end,curr);
				
				if (curr.jobsLeft()==0){
					System.out.println("finished");
					return curr;
				
				}

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
