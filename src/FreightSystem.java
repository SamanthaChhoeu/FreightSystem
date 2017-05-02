import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FreightSystem {
	private ArrayList<Town> towns;

	private int cost;

	public FreightSystem(){
		this.cost = 0;
		this.towns = new ArrayList<Town>();
	}
	
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
	    }
	    catch (FileNotFoundException e) {}
	    finally
	    {
	        if (sc != null) sc.close();
	    }
	}

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
    		System.out.println(cost+town);
    		updateUnload(town,cost);
    	}
    	// Cost <cost> <town1> <town2>
    	else if(command.equals("Cost")){
    		int cost = sc.nextInt();
    		String town1 = sc.next();
    		String town2 = sc.next();
    		System.out.println(cost+town1+town2);
    		updateConnected(town1,town2,cost);
    	}
    	// Job <town1> <town2>
    	else if(command.equals("Job")){
    		String town1 = sc.next();
    		String town2 = sc.next();
    		job(town1,town2);
    		System.out.println(town1+town2);
    		
    	}
	}
	
	private void updateUnload(String name,int cost){
		Town town = new Town(name,cost);
		towns.add(town);
		
	}
	private void updateConnected(String town1, String town2, int cost){
		for (Town town : towns){
			if (town.getName().equals(town1)){
				Edge edge = new Edge(town1,town2,cost);
				town.addEdge(edge);
			} else if (town.equals(town2)){
				Edge edge = new Edge(town1,town2,cost);
				town.addEdge(edge);
			}
			System.out.print(town.getConnected());
		}
	}
	private void job(String town1, String town2){
		// always starts in sydney
		// list of jobs that are left to be done
		System.out.println("cost = "+cost);
	}
    	
    	
}
