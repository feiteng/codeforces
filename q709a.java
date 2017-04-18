import java.util.Scanner;

public class q709a
{
	public static void main( String[] args )
	{
		Scanner in = new Scanner( System.in );
		int n = in.nextInt(), b = in.nextInt(), d = in.nextInt(), asum = 0, a, count = 0;
		for ( int i = 0; i < n; i++ )
		{
			a = in.nextInt();
			asum += a > b ? 0 : a;
			if ( asum > d )
			{
				asum = 0;
				count++;
			}
		}

		System.out.println( count );

	}
}
