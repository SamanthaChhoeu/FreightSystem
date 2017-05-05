import java.util.ArrayList;

public class State {

	// prev state
	// current town
	Town current;
	State prevState;
	
	// jobs completed or jobs left???
	private ArrayList<Edge> jobs;
	private ArrayList<Edge> path;
	private ArrayList<Town> visitedNodes;
	
	// f(x)

	private int cost;
	
	public State(ArrayList<Edge> jobs, ArrayList<Town> visitedNodes, ArrayList<Edge> path,
		Town curr, State prevState){
		this.current = curr;
		this.jobs = jobs;
		this.visitedNodes = visitedNodes;
		this.path = path;
		
	}
	
	public int calculateTotalCost(){
		
		if (path != null){
			for (Edge edge:path){
				cost += edge.getCost();
			}
		}
		if (visitedNodes != null){
			//  change this to unloading cost
		}
		return cost;
		
	}
	public int getfx(){
		
		int gx = jobsLeft(); // amount of jobs left
		int hx = 0;
		int fx = 0;
		fx = gx + hx;
		
		
		//if (fx == 2){
			//System.out.println(jobs);
			//System.out.println("fx"+fx);
		//}
		return fx;
	}
	
	public int jobsLeft(){
		int num = 0;
		int totalJobs = jobs.size();
		int jobsLeft;
		
		if (path != null){
			
			for (Edge edge:jobs){
				if (contains(path,edge)){
					num += 1;
				}
			}
		}
		
		
		jobsLeft = totalJobs - num;
		return jobsLeft;
	}
	
	private boolean contains(ArrayList<Edge> path, Edge edge){
		for (Edge edge1:path){
			if (edge.equals(edge1)){
				return true;
			}
		}
		return false;
	}
	
	public Town getCurrent(){
		return current;
	}
	public ArrayList<Town> getVisited(){
		return visitedNodes;
	}
	
	public ArrayList<Edge> getPath(){
		return path;
	}
	
	
}
