
/*
 * B. Checkpoints
 * 
 * Vasya takes part in the orienteering competition. There are n checkpoints located along the line at coordinates x1, x2,...,xn. Vasya starts at the
 * point with coordinate a. His goal is to visit at least n-1 checkpoint in order to finish the competition. Participant are allowed to visit
 * checkpoints in arbitrary order.
 * 
 * Vasya wants to pick such checkpoints and the order of visiting them that the total distance travelled is minimized. He asks you to calculate this
 * minimum possible value.
 * 
 * Input
 * The first line of the input contains two integers n and a (1<=n<=100000, -1000000<=a<=1000000) — the number of checkpoints and Vasya's starting
 * position respectively.
 * 
 * The second line contains n integers x1,x2,...,xn (-1000000<=xi<=1000000) — coordinates of the checkpoints.
 * 
 * Output
 * Print one integer — the minimum distance Vasya has to travel in order to visit at least n-1 checkpoint.
 * 
 * Examples
 * input
 * 3 10
 * 1 7 12
 * output
 * 7
 * input
 * 2 0
 * 11 -10
 * output
 * 10
 * input
 * 5 0
 * 0 0 1000 0 0
 * output
 * 0
 * Note
 * In the first sample Vasya has to visit at least two checkpoints. The optimal way to achieve this is the walk to the third checkpoints (distance is
 * 12-10=2) and then proceed to the second one (distance is 12-7=5). The total distance is equal to 2+5=7.
 * 
 * In the second sample it's enough to visit only one checkpoint so Vasya should just walk to the point -10.
 */
import java.util.Arrays;
import java.util.Scanner;

public class q709b
{
	public static void main( String[] args )
	{
		Scanner in = new Scanner( System.in );
		int n = in.nextInt(), a = in.nextInt(), minval = Integer.MAX_VALUE;
		int[] pos = new int[n];
		for ( int i = 0; i < n; i++ )
		{
			pos[i] = in.nextInt();
		}
		Arrays.sort( pos );
		/// proper index where a is

		int k = 0;
		while ( pos[k] < a )
			k++;
		// k is where a is , or first item > than a

		int d1 = a - pos[k - 1], d2 = pos[k] - a;

	}

	static int getDist( int[] n, int startPos, int endPos )
	{
		int sum = 0;
		for ( int i = startPos; i <= endPos; i++ )
			sum += n[i];
		return sum;
	}
}
