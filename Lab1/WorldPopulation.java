import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.StringTokenizer;


public class WorldPopulation {
	SortStrategy sortStrategy;
	long[] population = new long[13484]; // Cheating because we know number of records!!
	// Lab Exercise:  After creating some strategy classes -- set the default strategy here.
	public WorldPopulation(){
		sortStrategy = new InsertionSort(); // Set the default strategy here.	
	}
	public void readInputFile(){
		population = readPopulationFile("WorldPopulation.csv");
	}
	public void setStrategy(SortStrategy strategy){
		sortStrategy = strategy;
	}
	// Lab Exercise:  Read in the WorldPopulation.csv
	// Extract ONLY the numbers and store them into population[]
	public long[] readPopulationFile(String fileName){
	    try
	    {
	    	FileReader file=new FileReader(fileName);
	    	BufferedReader br=new BufferedReader(file);
	    	String ln;
	    	int j=0;
	    	for(ln=br.readLine();ln!=null;ln=br.readLine())
	    	{
	    		StringTokenizer token =new StringTokenizer(ln,",");
	    		while(token.hasMoreTokens())
	    		{
	    			String nm=token.nextToken();
	    			String yr=token.nextToken();
	    			long count=Long.parseLong(token.nextToken());
	    			population[j++]=count;
	    		}
	    	}
	    br.close();	
	    }
	    catch(Exception e)
	    {
	    	System.out.println("Token Exception Occurs");
	    	e.printStackTrace();
	    }
	    return population;
	}
	// Lab Exercise.  Complete this method.
	// Delegate sorting to the strategy object
	public void sortPopulation(){		
		sortStrategy.resetTimer();
		population=sortStrategy.sort(population);
		long tm=sortStrategy.getSortTime();
		String name=sortStrategy.strategyName();
		System.out.println(name);
		System.out.println("Time taken to Sort : "+tm);
	}
	
	public void computeTotalPopulation(){
		System.out.println("dd");
	}
	// Experiment with various strategies.
	// Create 3 strategies -- Bubble, insertion, and selection sort.
	public static void main(String[] args) {
		WorldPopulation wp = new WorldPopulation();
		wp.readInputFile();
		wp.setStrategy(new BubbleSort()); //  Currently no strategies.
		wp.sortPopulation();	
	    wp = new WorldPopulation();
		wp.readInputFile();
		wp.setStrategy(new SelectionSort()); //  Currently no strategies.
		wp.sortPopulation();
		wp = new WorldPopulation();
		wp.readInputFile();
		wp.setStrategy(new InsertionSort()); //  Currently no strategies.
		wp.sortPopulation();
	}

}


