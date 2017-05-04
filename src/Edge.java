
public class Edge {
	private Town town1;
	private Town town2;
	private int cost;
	
	public Edge (Town town1,Town town2, int cost){
		this.town1 = town1;
		this.town2 = town2;
		this.cost = cost;
	}
	
	
	
	public Town getStart(){
		return town1;
		
	}
	public Town getEnd(){
		return town2;
	}
	
	public int getCost(){
		return cost;
	}
	
}
