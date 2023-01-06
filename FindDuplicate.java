/*************************************************************************
 *  Compilation:  javac FindDuplicate.java
 *  Execution:    java FindDuplicate
 *
 *  @author: Consin Hu csh115@scarletmail.rutgers.edu csh115
 *
 * FindDuplicate that reads n integer arguments from the command line 
 * into an integer array of length n, where each value is between is 1 and n, 
 * and displays true if there are any duplicate values, false otherwise.
 *
 *  % java FindDuplicate 10 8 5 4 1 3 6 7 9
 *  false
 *
 *  % java FindDuplicate 4 5 2 1 
 *  true
 *************************************************************************/

public class FindDuplicate {

    public static void main(String[] args) {

		//WRITE YOUR CODE HERE
		int n = 0;
        n = args.length;
        int[] arr;
        arr = new int[n];
        boolean duplicate = false;

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(args[i]);
        }

        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                if(arr[i] == arr[j]) {
                    duplicate = true;
                    break;
                }
            }
        }
        if(duplicate == false) {
            System.out.println("False");
        } else {
            System.out.println("True");
        }
	}
}
