
import java.util.Scanner;

public class Q732C
{

	public static void main( String[] args )
	{
		Scanner in = new Scanner( System.in );
		long a = in.nextLong(), b = in.nextLong(), c = in.nextLong();
		long max = Math.max( Math.max( a, b ), c );
		long meals = 0l;
		meals += Math.max( max - 1 - a, 0 );
		meals += Math.max( max - 1 - b, 0 );
		meals += Math.max( max - 1 - c, 0 );
		System.out.println( meals );
	}

}
