import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Heuristic.
 */
public class Heuristic {
	
	/** The jobs. */
	private ArrayList<Edge> jobs;
	
	/** The path. */
	private ArrayList<Edge> path;
	
	/**
	 * Instantiates a new heuristic.
	 *
	 * @param path the path
	 * @param jobs the jobs
	 */
	public Heuristic(ArrayList<Edge> path, ArrayList<Edge> jobs){
		this.path = path;
		this.jobs = new ArrayList<Edge>(jobs);
	}
	
	/**
	 * Calculate.
	 *
	 * @return the int
	 */
	//add the path distance and unload cost for the jobs you have left
	public int calculate(){
		int h = 0;
		if (path != null){
			for (Edge edge:path){
				if (contains(path,edge)){
					jobs.remove(edge);
				}
			}
		}
		
		for (Edge job:jobs){
			h += job.getCost();
			h += job.getEnd().getCost();
		}
		return h;
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
}
