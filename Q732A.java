
import java.util.Scanner;

public class Q732A
{

	public static void main( String[] args )
	{
		Scanner in = new Scanner( System.in );
		int k = in.nextInt(), r = in.nextInt();
		int i = 1;

		while ( ( k * i ) % 10 != 0 && ( k * i - r ) % 10 != 0 )
		{
			i++;
		}
		System.out.println( i );

	}

}
