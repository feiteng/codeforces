import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class q796c
{
	public static void main( String[] args )
	{
		Scanner in = new Scanner( System.in );
		int n = in.nextInt(), maxStr = 0, maxVal = Integer.MIN_VALUE;
		int[] str = new int[n + 1];
		for ( int i = 1; i < n + 1; i++ )
		{
			str[i] = in.nextInt();
			maxVal = Math.max( maxVal, str[i] );
		}

		str[0] = Integer.MIN_VALUE;
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for ( int i = 0; i < n - 1; i++ )
		{
			int pos = in.nextInt(), neighbour = in.nextInt();
			// pos += 1;
			if ( !map.containsKey( pos ) )
				map.put( pos, new HashSet<>() );
			map.get( pos ).add( neighbour );
			if ( !map.containsKey( neighbour ) )
				map.put( neighbour, new HashSet<>() );
			map.get( neighbour ).add( pos );
		}
		// System.out.println( map );
		Set<Integer> total = new HashSet<>();
		for ( int i = 1; i < str.length; i++ )
		{
			if ( str[i] != maxVal )
				continue;
			Set<Integer> check = new HashSet<>();
			List<Integer> list = new ArrayList<>();
			// list.add( str[i] );
			int[] strCopy = str.clone();
			helper( strCopy, map, total, list, i );
		}
		// System.out.println( total );
		int min = Integer.MAX_VALUE;
		for ( int m : total )
			min = Math.min( min, m );
		System.out.println( min );
	}

	// static List<Integer> list = new ArrayList<>();

	static void helper( int[] str, Map<Integer, Set<Integer>> map,
			Set<Integer> total, List<Integer> list, int pos )
	{
		Queue<Integer> queue = new LinkedList<>();
		Set<Integer> robbed = new HashSet<>();
		queue.add( pos );
		int max = Integer.MIN_VALUE;
		while ( !queue.isEmpty() )
		{
			int currentPos = queue.poll();
			list.add( str[currentPos] );
			max = Math.max( max, str[currentPos] );
			robbed.add( currentPos );
			for ( int neighbour : map.get( currentPos ) )
			{
				if ( robbed.contains( neighbour ) )
					continue;
				str[neighbour]++;
				for ( int semiNeighbour : map.get( neighbour ) )
				{
					if ( robbed.contains( semiNeighbour ) )
						continue;
					str[semiNeighbour]++;
				}
				queue.add( neighbour );
			}
		}
		// System.out.println( list );
		// int min = Integer.MIN_VALUE;
		// for ( int m : list )
		// min = Math.max( min, m );
		total.add( max );
	}

	static int[] nextMax( int[] str, Set<Integer> check )
	{
		int[] ret = new int[2];
		ret[0] = 0;
		ret[1] = Integer.MIN_VALUE;
		for ( int i = 0; i < str.length; i++ )
		{
			if ( check.contains( i ) )
				continue;
			if ( ret[1] < str[i] )
			{
				ret[0] = i;
				ret[1] = str[i];
			}
		}
		return ret;
	}
}
