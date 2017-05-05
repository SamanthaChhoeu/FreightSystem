import java.util.ArrayList;
// TODO: Auto-generated Javadoc

/**
 * The Class Town.
 */
public class Town {
	
	/** The cost. */
	private int cost;
	
	/** The name. */
	private String name;
	
	/** The connected. */
	private ArrayList<Edge> connected;
	
	/**
	 * Instantiates a new town.
	 */
	public Town(){
		this.name = "";
		this.cost = 0;
		this.connected = new ArrayList<Edge>();
	}
	
	/**
	 * Instantiates a new town.
	 *
	 * @param name the name
	 * @param cost the cost
	 */
	public Town(String name,int cost){
		this.name = name;
		this.cost = cost;
		this.connected = new ArrayList<Edge>();
	}
	
	/**
	 * Adds the edge.
	 *
	 * @param edge the edge
	 */
	public void addEdge(Edge edge){
		connected.add(edge);
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Gets the cost.
	 *
	 * @return the cost
	 */
	public int getCost(){
		return cost;
	}
	
	/**
	 * Gets the connected.
	 *
	 * @return the connected
	 */
	public ArrayList<Edge> getConnected(){
		return connected;
	}
}
