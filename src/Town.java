import java.util.ArrayList;
public class Town {
	private int cost;
	private String name;
	private ArrayList<Edge> connected;
	
	public Town(){
		this.name = "";
		this.cost = 0;
		this.connected = new ArrayList<Edge>();
	}
	public Town(String name,int cost){
		this.name = name;
		this.cost = cost;
		this.connected = new ArrayList<Edge>();
	}
	public void addEdge(Edge edge){
		connected.add(edge);
	}
	
	public String getName(){
		return name;
	}
	
	public int getCost(){
		return cost;
	}
	
	public ArrayList<Edge> getConnected(){
		return connected;
	}
}
