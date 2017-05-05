
// TODO: Auto-generated Javadoc
/**
 * The Class Edge.
 */
public class Edge {
	
	/** The town 1. */
	private Town town1;
	
	/** The town 2. */
	private Town town2;
	
	/** The cost. */
	private int cost;
	
	/**
	 * Instantiates a new edge.
	 *
	 * @param town1 the town 1
	 * @param town2 the town 2
	 * @param cost the cost
	 */
	public Edge (Town town1,Town town2, int cost){
		this.town1 = town1;
		this.town2 = town2;
		this.cost = cost;
	}
	
	
	
	/**
	 * Gets the start.
	 *
	 * @return the start
	 */
	public Town getStart(){
		return town1;
		
	}
	
	/**
	 * Gets the end.
	 *
	 * @return the end
	 */
	public Town getEnd(){
		return town2;
	}
	
	/**
	 * Gets the cost.
	 *
	 * @return the cost
	 */
	public int getCost(){
		return cost;
	}
	
}
