package avengers;
/**
 * 
 * Using the Adjacency Matrix of n vertices and starting from Earth (vertex 0), 
 * modify the edge weights using the functionality values of the vertices that each edge 
 * connects, and then determine the minimum cost to reach Titan (vertex n-1) from Earth (vertex 0).
 * 
 * Steps to implement this class main method:
 * 
 * Step 1:
 * LocateTitanInputFile name is passed through the command line as args[0]
 * Read from LocateTitanInputFile with the format:
 *    1. g (int): number of generators (vertices in the graph)
 *    2. g lines, each with 2 values, (int) generator number, (double) funcionality value
 *    3. g lines, each with g (int) edge values, referring to the energy cost to travel from 
 *       one generator to another 
 * Create an adjacency matrix for g generators.
 * 
 * Populate the adjacency matrix with edge values (the energy cost to travel from one 
 * generator to another).
 * 
 * Step 2:
 * Update the adjacency matrix to change EVERY edge weight (energy cost) by DIVIDING it 
 * by the functionality of BOTH vertices (generators) that the edge points to. Then, 
 * typecast this number to an integer (this is done to avoid precision errors). The result 
 * is an adjacency matrix representing the TOTAL COSTS to travel from one generator to another.
 * 
 * Step 3:
 * LocateTitanOutputFile name is passed through the command line as args[1]
 * Use Dijkstra’s Algorithm to find the path of minimum cost between Earth and Titan. 
 * Output this number into your output file!
 * 
 * Note: use the StdIn/StdOut libraries to read/write from/to file.
 * 
 *   To read from a file use StdIn:
 *     StdIn.setFile(inputfilename);
 *     StdIn.readInt();
 *     StdIn.readDouble();
 * 
 *   To write to a file use StdOut (here, minCost represents the minimum cost to 
 *   travel from Earth to Titan):
 *     StdOut.setFile(outputfilename);
 *     StdOut.print(minCost);
 *  
 * Compiling and executing:
 *    1. Make sure you are in the ../InfinityWar directory
 *    2. javac -d bin src/avengers/*.java
 *    3. java -cp bin avengers/LocateTitan locatetitan.in locatetitan.out
 * 
 * @author Yashas Ravi
 * 
 */

public class LocateTitan {
	
    public static void main (String [] args) {
    	
        if ( args.length < 2 ) {
            StdOut.println("Execute: java LocateTitan <INput file> <OUTput file>");
            return;
        }

    	// WRITE YOUR CODE HERE

        StdIn.setFile(args[0]);
        StdOut.setFile(args[1]);

        int number = StdIn.readInt();
        int[] generator = new int[number];
        double[] function = new double[number];
        int[][] edges = new int[number][number];

        for(int i=0; i<number; i++){
            generator[i] = StdIn.readInt();
            function[i] = StdIn.readDouble();
        }

        for(int j=0; j<number; j++) {
            for(int k=0; k<number; k++) {
                edges[j][k] = (int) (StdIn.readInt()/(function[j]*function[k]));
            }
        }

        int[] minCost = dijkstra(edges);
        StdOut.print(minCost[number-1]);

    }

    private static int[] dijkstra (int[][] ev) {
        int[] minCost = new int[ev.length];
        boolean[] dset = new boolean[ev.length];

        for(int i=1; i<minCost.length; i++) {
            minCost[i] = Integer.MAX_VALUE;
        }

        for(int i=0; i<minCost.length; i++) {
            int current = getMinCostNode(minCost, dset);
            dset[current] = true;

            for(int j=0; j<ev.length; j++) {
                int cumulative = minCost[current] + ev[current][j];
                if(ev[current][j] != 0 && !dset[j] && cumulative < minCost[j]) {
                    minCost[j] = cumulative;
                }
            }
        }

        return minCost;
    }

    private static int getMinCostNode(int[] mc, boolean[] ds) {
        int minimum = Integer.MAX_VALUE;
        int minNode = -1;

        for(int i = 0; i < mc.length; i++) {
            if(!ds[i] && mc[i] < minimum) {
                minimum = mc[i];
                minNode = i;
            }
        }

        return minNode;
    }
}
