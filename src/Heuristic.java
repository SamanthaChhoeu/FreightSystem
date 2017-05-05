import java.util.ArrayList;

public class Heuristic {
	private ArrayList<Edge> jobs;
	private ArrayList<Edge> path;
	
	public Heuristic(ArrayList<Edge> path, ArrayList<Edge> jobs){
		this.path = path;
		this.jobs = new ArrayList<Edge>(jobs);
	}
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
	
	private boolean contains(ArrayList<Edge> path, Edge edge){
		for (Edge edge1:path){
			if (edge.equals(edge1)){
				return true;
			}
		}
		return false;
	}
}
