import java.util.ArrayList;

public class State {

	private ArrayList<Edge> path;
	// prev state
	// current town
	Town current;
	State prevState;
	
	// jobs completed or jobs left???
	ArrayList<Edge> jobs;
	
	ArrayList<Town> visited;
	
	// f(x)
	private int fx;
	
	
	public State(ArrayList<Edge> jobs, ArrayList<Town> visitedNodes, ArrayList<Edge> path,
		Town curr, State prevState, int cost){
		this.current = curr;
	}
	
	public Town getCurrent(){
		return current;
	}
	public ArrayList<Town> getVisited(){
		return visited;
	}
	
	public ArrayList<Edge> getPath(){
		return path;
	}
	
	
}
