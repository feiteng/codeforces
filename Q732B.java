
import java.util.Scanner;

public class Q732B
{

	public static void main( String[] args )
	{
		Scanner in = new Scanner( System.in );
		int n = in.nextInt(), k = in.nextInt(), sum = 0;
		int[] a = new int[n], b = new int[n];

		for ( int i = 0; i < n; i++ )
			a[i] = in.nextInt();
		for ( int i = 0; i < n - 1; i++ )
			if ( a[i] + b[i] + a[i + 1] + b[i + 1] < k )
			{
				b[i + 1] = k - ( a[i] + b[i] + a[i + 1] );
			}
		for ( int bi : b )
			sum += bi;
		System.out.println( sum );
		for ( int i = 0; i < n; i++ )
			System.out.print( a[i] + b[i] + " " );
	}

}
