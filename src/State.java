import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class State.
 */
public class State {

	// prev state
	/** The current. */
	// current town
	private Town current;
	
	/** The prev state. */
	private State prevState;
	
	/** The jobs. */
	// jobs completed or jobs left???
	private ArrayList<Edge> jobs;
	
	/** The path. */
	private ArrayList<Edge> path;
	
	/** The visited nodes. */
	private ArrayList<Town> visitedNodes;
	
	// f(x)

	/** The cost. */
	private int cost;
	
	/**
	 * Instantiates a new state.
	 *
	 * @param jobs the jobs
	 * @param visitedNodes the visited nodes
	 * @param path the path
	 * @param curr the curr
	 * @param prevState the prev state
	 */
	public State(ArrayList<Edge> jobs, ArrayList<Town> visitedNodes, ArrayList<Edge> path,
		Town curr, State prevState){
		this.current = curr;
		this.jobs = jobs;
		this.visitedNodes = visitedNodes;
		this.path = path;
		
	}
	
	/**
	 * Calculate total cost.
	 *
	 * @return the int
	 */
	public int calculateTotalCost(){
		cost = 0;
		if (path != null){
			for (Edge edge:path){
				cost += edge.getCost();
			}
		}
		if (visitedNodes != null){
			//  change this to unloading cost
			for (Edge job:jobs){
				cost+= job.getEnd().getCost();
			}
		}
		return cost;
		
	}
	
	/**
	 * Calculate edge cost.
	 *
	 * @return the int
	 */
	public int calculateEdgeCost(){
		int cost = 0;
		if (path != null){
			for (Edge edge:path){
				cost += edge.getCost();
			}
		}
		return cost;
	}
	
	/**
	 * Gets the fx.
	 *
	 * @return the fx
	 */
	public int getfx(){
		
		int gx = calculateEdgeCost(); // distance so far
		//Heuristic 
		Heuristic h = new Heuristic(path, jobs);
		int hx = h.calculate();
		int fx = 0;
		fx = gx + hx;
		
		return fx;
	}
	
	/**
	 * Jobs left.
	 *
	 * @return the int
	 */
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
	
	/**
	 * Contains.
	 *
	 * @param path the path
	 * @param edge the edge
	 * @return true, if successful
	 */
	private boolean contains(ArrayList<Edge> path, Edge edge){
		for (Edge edge1:path){
			if (edge.equals(edge1)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Gets the current.
	 *
	 * @return the current
	 */
	public Town getCurrent(){
		return current;
	}
	
	/**
	 * Gets the visited.
	 *
	 * @return the visited
	 */
	public ArrayList<Town> getVisited(){
		return visitedNodes;
	}
	
	/**
	 * Gets the path.
	 *
	 * @return the path
	 */
	public ArrayList<Edge> getPath(){
		return path;
	}
	
	
}
