import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Q707B
{
	public static void main( String[] args ) throws Exception
	{
		int distance = Integer.MAX_VALUE;
		// File file = new File( "C:\\Users\\Rutter\\Desktop\\java\\CodeForces\\707\\t.txt" );
		// Scanner in = new Scanner(file);
		Scanner in = new Scanner( System.in );
		String s = in.nextLine();
		String[] s_ = s.split( " " );
		int n = Integer.valueOf( s_[0] ), m = Integer.valueOf( s_[1] ), k = Integer.valueOf( s_[2] );
		Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
		Set<Integer> storage = new HashSet<>();

		// is this true? because no place for storages
		if ( k == 0 )
		{
			System.out.println( "-1" );
			return;
		}

		for ( int i = 0; i < m; i++ )
		{
			s = in.nextLine();
			s_ = s.split( " " );
			int a = Integer.valueOf( s_[0] ), b = Integer.valueOf( s_[1] ), dis = Integer.valueOf( s_[2] );
			mapPut( map, a, b, dis );
			mapPut( map, b, a, dis );
		}

		// now read k
		s = in.nextLine();
		s_ = s.split( " " );

		for ( int i = 0; i < s_.length; i++ )
			storage.add( Integer.valueOf( s_[i] ) );

		Iterator<Entry<Integer, Map<Integer, Integer>>> mapIterator = map.entrySet().iterator();
		while ( mapIterator.hasNext() )
		{
			Entry<Integer, Map<Integer, Integer>> mapEntry = mapIterator.next();
			if ( storage.contains( mapEntry.getKey() ) )
			{
				Iterator<Entry<Integer, Integer>> innerIterator = mapEntry.getValue().entrySet().iterator();
				while ( innerIterator.hasNext() )
				{
					Entry<Integer, Integer> innerEntry = innerIterator.next();
					if ( !storage.contains( innerEntry.getKey() ) )
						distance = Math.min( distance, innerEntry.getValue() );
				}

			}
		}

		System.out.println( distance == Integer.MAX_VALUE ? -1 : distance );

	}

	static void mapPut( Map<Integer, Map<Integer, Integer>> map, int a, int b, int dis )
	{
		if ( !map.containsKey( a ) )
		{
			Map<Integer, Integer> connect = new HashMap<>();
			connect.put( b, dis );
			map.put( a, connect );
		}
		else
		{
			if ( map.get( a ).containsKey( b ) )
				map.get( a ).put( b, Math.min( map.get( a ).get( b ), dis ) );
			else
				map.get( a ).put( b, dis );
		}
	}

}