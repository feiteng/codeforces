import java.util.Scanner;

public class q703a
{
	public q703a()
	{
		// TODO Auto-generated constructor stub
	}

	public static void main( String[] args )
	{
		Scanner in = new Scanner( System.in );
		q703a mishka = new q703a();

		int m = 0, c = 0, mcount = 0, ccount = 0;
		int n = in.nextInt();
		for ( int i = 0; i < n; i++ )
		{
			m = in.nextInt();
			c = in.nextInt();
			if ( m > c )
				mcount++;
			if ( c > m )
				ccount++;
		}
		if ( mcount > ccount )
			System.out.println( "Mishka" );
		if ( mcount < ccount )
			System.out.println( "Chris" );
		if ( mcount == ccount )
			System.out.println( "Friendship is magic!^^" );
	}
}
