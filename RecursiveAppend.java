/*************************************************************************
 *  Compilation:  javac RecursiveAppend.java
 *  Execution:    java RecursiveAppend
 *
 *  @author: Consin Hu csh115@rutgers.edu csh115
 *
 *************************************************************************/

public class RecursiveAppend {

    // Returns the original string appended to the original string n times 
    public static String appendNTimes (String original, int n) {

	if(n == 0) {
        return original;
    }
    return original + appendNTimes(original, n-1);
    
    }

    public static void main (String[] args) {

	// WRITE TEST CASES HERE to test your method
    int n = StdIn.readInt();
    String original = StdIn.readString();

    System.out.println(appendNTimes(original, n));
    }
}
