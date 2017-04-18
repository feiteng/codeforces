import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class q4
{
	public static void main( String[] args )
	{
		q4 q = new q4();
		q.q4d();
	}

	void q4d()
	{

	}

	void q4c()
	{
		Scanner in = new Scanner( System.in );
		int n = Integer.valueOf( in.nextLine() );
		Map<String, Integer> map = new HashMap<>();
		for ( int i = 0; i < n; i++ )
		{
			String name = in.nextLine();
			if ( !map.containsKey( name ) )
			{
				map.put( name, 0 );
				System.out.println( "OK" );
			}
			else
			{
				map.put( name, map.get( name ) + 1 );
				System.out.println( name + String.valueOf( map.get( name ) ) );
			}
		}
	}

	void q4b()
	{
		Scanner in = new Scanner( System.in );
		int d = in.nextInt(), sumTime = in.nextInt(), runningSum = 0, runningMin = 0;
		int[] min = new int[d], max = new int[d];

		for ( int i = 0; i < d; i++ )
		{
			min[i] = in.nextInt();
			runningMin += min[i];
			max[i] = in.nextInt();
			runningSum += max[i];
		}
		if ( runningSum < sumTime || runningMin > sumTime )
			System.out.println( "NO" );
		else
		{
			System.out.println( "YES" );
			int leftTime = sumTime - runningMin;
			int i = 0;
			while ( leftTime > 0 )
			{
				int deduct = Math.min( leftTime, max[i] - min[i] );
				leftTime -= deduct;
				min[i] += deduct;
				i++;
			}
			for ( int k : min )
			{
				System.out.printf( "%d ", k );
			}
		}
	}

	void q4a()
	{
		Scanner in = new Scanner( System.in );
		int w = in.nextInt();
		if ( w >= 4 && w % 2 == 0 )
			System.out.println( "YES" );
		else
			System.out.println( "NO" );
	}
}
