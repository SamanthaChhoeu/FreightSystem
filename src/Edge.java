
public class Edge {
	private String town1;
	private String town2;
	private int cost;
	
	public Edge (String town1,String town2, int cost){
		this.town1 = town1;
		this.town2 = town2;
		this.cost = cost;
	}
	
	public String getStart(){
		return town1;
		
	}
	public String getEnd(){
		return town2;
	}
	
	public int getCost(){
		return cost;
	}
	
}
