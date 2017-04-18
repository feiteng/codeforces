import java.util.Scanner;

public class q796b
{
	public static void main( String[] args )
	{
		Scanner in = new Scanner( System.in );
		int n = in.nextInt(), m = in.nextInt(), k = in.nextInt();
		m = m - 1;
		int[] h = new int[n];
		for ( int i = 0; i < n; i++ )
			h[i] = in.nextInt();
		int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
		for ( int i = m - 1; i >= 0; i-- )
		{
			if ( h[i] != 0 && h[i] <= k )
			{
				left = 10 * ( m - i );
				break;
			}
		}
		for ( int i = m + 1; i < h.length; i++ )
		{
			if ( h[i] != 0 && h[i] <= k )
			{
				right = 10 * ( i - m );
				break;
			}
		}
		System.out.println( Math.min( left, right ) );
	}
}
