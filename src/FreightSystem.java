import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class FreightSystem.
 */
public class FreightSystem {
	
	/** The towns. */
	private ArrayList<Town> towns;
	
	/** The jobs. */
	private ArrayList<Edge> jobs;
	
	/** The start. */
	private Town start = new Town(); // STARTING TOWN
	

	/**
	 * Instantiates a new freight system.
	 */
	public FreightSystem(){
		this.towns = new ArrayList<Town>();
		this.jobs = new ArrayList<Edge>();
		
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	// only main is static
	public static void main(String[] args){
		FreightSystem system = new FreightSystem();
	    Scanner sc = null;
	    try
	    {
	    	
	        sc = new Scanner(new FileReader(args[0]));    // args[0] is the first command line argument
		    while(sc.hasNextLine() && sc.hasNext()){
		    	system.Request(sc);
		    	
		    	
		    } 
		    system.Search();
		    
	    }
	    catch (FileNotFoundException e) {}
	    finally
	    {
	        if (sc != null) sc.close();
	    }
	}

	/**
	 * Search.
	 */
	private void Search(){
		Search search = new Search(jobs, start);
		State best = search.Astar();
		
		System.out.println(search.getNodesExpanded()+" nodes expanded");
		System.out.println("cost = "+best.calculateTotalCost());
		for (Edge edge: best.getPath()){
			if (jobs.contains(edge)){
				System.out.println("Job "+edge.getStart().getName()+" to "+edge.getEnd().getName());
			}else{
				System.out.println("Empty "+edge.getStart().getName()+" to "+edge.getEnd().getName());
			}
			
			
		}
	}
	
	/**
	 * Request.
	 *
	 * @param sc the sc
	 */
	private void Request(Scanner sc){
		String command;
    	
    	command = sc.next();   	

    	if(command.contains("#")){
    		command = sc.nextLine();
    	}
    	// Unloading <cost> <town>
    	else if(command.equals("Unloading")){
    		int cost = sc.nextInt();
    		String town = sc.next();
    		//System.out.println(cost+town);
    		updateUnload(town,cost);
    	}
    	// Cost <cost> <town1> <town2>
    	else if(command.equals("Cost")){
    		int cost = sc.nextInt();
    		String town1 = sc.next();
    		String town2 = sc.next();
    		//System.out.println(cost+town1+town2);
    		updateConnected(town1,town2,cost);
    	}
    	// Job <town1> <town2>
    	else if(command.equals("Job")){
    		String town1 = sc.next();
    		String town2 = sc.next();
    		job(town1,town2);
    		//System.out.println(town1+town2);

    		
    	}
    	
	}
	
	/**
	 * Update unload.
	 *
	 * @param name the name
	 * @param cost the cost
	 */
	private void updateUnload(String name,int cost){
		Town town = new Town(name,cost);
		towns.add(town);
		// initialise start town
		if (start.getName().equals("")){
			start = town;
			
		}
		
	}
	
	/**
	 * Update connected.
	 *
	 * @param town1name the town 1 name
	 * @param town2name the town 2 name
	 * @param cost the cost
	 */
	private void updateConnected(String town1name, String town2name, int cost){
		Town town1 = getTown(town1name);
		Town town2 = getTown(town2name);
		
		Edge edge1 = new Edge(town1,town2,cost);
		Edge edge2 = new Edge(town2,town1,cost);
		
		town1.addEdge(edge1);
		town2.addEdge(edge2);
		
	}
	
	/**
	 * Job.
	 *
	 * @param town1 the town 1
	 * @param town2 the town 2
	 */
	private void job(String town1, String town2){
		// always starts in sydney
		// list of jobs that are left to be done
		
		for (Town town : towns){
			if (town.getName().equals(town1)){
				
				for (Edge edge : town.getConnected()){
					if (edge.getEnd().getName().equals(town2)){
						jobs.add(edge);

						
					}
				}
			}
		}

		
	}
	
	/**
	 * Gets the town.
	 *
	 * @param name the name
	 * @return the town
	 */
	private Town getTown(String name){
		for (Town town:towns){
			if (town.getName().equals(name)){
				return town;
			}
		}
		return null;
	}
    
	
    	
}
