import java.util.Scanner;

public class Q707C
{
	public static void main( String[] args ) throws Exception
	{
		// File file = new File( "C:\\Users\\Rutter\\Desktop\\java\\CodeForces\\707\\t.txt" );
		// Scanner in = new Scanner(file);
		Scanner in = new Scanner( System.in );
		long n = (long) in.nextInt();
		if ( n < 3 )
		{
			System.out.println( -1 );
			return;
		}

		long a, b;
		if ( n % 2 == 0 ) // even
		{
			a = n * n / 4 + 1;
			b = a - 2;
		}
		else
		{
			a = ( n * n - 1 ) / 2;
			b = a + 1;
		}

		System.out.println( a + " " + b );

	}

}