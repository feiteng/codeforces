
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q732D
{

	public static void main( String[] args )
	{
		Scanner in = new Scanner( System.in );
		int n = in.nextInt(), m = in.nextInt(), sum = 0;
		List<Integer> a = new ArrayList<>(), b = new ArrayList<>(), task = new ArrayList<>();
		a.add( -1 );
		for ( int i = 0; i < n; i++ )
		{
			a.add( in.nextInt() );
		}
		for ( int i = 0; i < m; i++ )
		{
			b.add( in.nextInt() );
			task.add( i + 1 );
			sum += b.get( i );
		}

		if ( sum + m > n )
		{
			System.out.println( -1 );
			return;
		}

		List<Integer> path = findPath( a, b, task, 0, new ArrayList<>() );
		if ( path == null )
		{
			System.out.println( -1 );
		}
		else
		{
			System.out.println( path.get( 0 ) );
		}

	}

	static List<Integer> findPath( List<Integer> a, List<Integer> b, List<Integer> task, int nextSearch, List<Integer> path )
	{
		if ( b.size() == 1 )
		{
			for ( int i = nextSearch + b.get( 0 ); i < a.size(); i++ )
			{
				if ( a.get( i ) == task.get( 0 ) )
				{
					path.add( i );
					return path;
				}
			}
		}

		for ( int i = 0; i < b.size(); i++ )
		{
			List<Integer> bList = new ArrayList<>( b ), newTask = new ArrayList<>( task );
			bList.remove( i );
			newTask.remove( i );
			int taskPos = 0;
			for ( int j = 0; j < a.size(); j++ )
			{
				if ( a.get( j ) == task.get( i ) )
				{
					taskPos = j;
					List<Integer> result = findPath( a, bList, newTask, b.get( i ) + j, path );
					if ( result != null )
						return result;
				}
			}

			// path.remove( i );

		}

		return null;
	}

}
