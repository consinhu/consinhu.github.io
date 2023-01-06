/*************************************************************************
 *  Compilation:  javac RURottenTomatoes.java
 *  Execution:    java RURottenTomatoes
 *
 *  @author: Consin Hu csh115@scarletmail.rutgers.edu csh115
 *
 * RURottenTomatoes creates a 2 dimensional array of movie ratings 
 * from the command line arguments and displays the index of the movie 
 * that has the highest sum of ratings.
 *
 *  java RURottenTomatoes 3 2 5 2 3 3 4 1
 *  0
 *************************************************************************/

public class RURottenTomatoes {

    public static void main(String[] args) {

		// WRITE YOUR CODE HERE
		int movieReviewer = Integer.parseInt(args[0]);
        int movie = Integer.parseInt(args[1]);
        int[][] movieRatings = new int[movieReviewer][movie];
        int pair = 2;

        for(int r = 0; r < movieReviewer; r++) {
            for(int c = 0; c < movie; c++) {
                movieRatings[r][c] = Integer.parseInt(args[pair++]);
            }
        }

        int total = 0;
        int highestSum = 0;
        for(int c = 0; c < movie; c++) {
            int colTotal = 0;
            for(int r = 0; r < movieReviewer; r++){
                colTotal += movieRatings[r][c];
            }
            if(colTotal > total) {
                total = colTotal;
                highestSum = c;
            }
        }

        System.out.println(highestSum);
    }
}
