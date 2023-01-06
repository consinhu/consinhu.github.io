/*************************************************************************
 *  Compilation:  javac LargestOfFive.java
 *  Execution:    java LargestOfFive 35 10 32 1 8
 *
 *  @author: Consin Hu csh115@scarletmail.rutgers.edu csh115
 *
 *  Takes five distinct integers as command-line arguments and prints the 
 *  largest value
 *
 *
 *  % java LargestOfFive 35 10 32 1 8
 *  35
 *
 *  Assume the inputs are 5 distinct integers.
 *  Print only the largest value, nothing else.
 *
 *************************************************************************/

public class LargestOfFive {

    public static void main (String[] args) {

        int largestOfFive = Integer.parseInt(args[0]);
        for(int i = 0; i<args.length; i++) {
            if (largestOfFive < Integer.parseInt(args[i])) {
                largestOfFive = Integer.parseInt(args[i]);
            }
        }

        System.out.println(largestOfFive);
    }
}