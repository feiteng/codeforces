import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class q796a
{
	public static void main( String[] args )
	{

		Scanner in = new Scanner( System.in );
		String next = in.nextLine();
		String[] in1 = next.split( " " );
		int n = Integer.valueOf( in1[0] ), m = Integer.valueOf( in1[1] ), k = Integer.valueOf( in1[2] );
		String holesStr = in.nextLine();
		String[] holesSplit = holesStr.split( " " );
		int[] hole = new int[n + 1];
		Set<Integer> holes = new HashSet<>();
		for ( int i = 0; i < m; i++ )
		{
			// holes.add( in.nextInt() );
			holes.add( Integer.valueOf( holesSplit[i] ) );
			// hole[Integer.valueOf( holesSplit[i] )] = 1;
		}
		if ( hole[1] > 0 )
		{
			System.out.println( 1 );
			return;
		}
		int initialPos = 0, endPos = 1, nextPos = 1;
		for ( int i = 0; i < k; i++ )
		{
			initialPos = in.nextInt();
			endPos = in.nextInt();
			if ( initialPos == nextPos || endPos == nextPos )
			{
				if ( nextPos == initialPos )
					nextPos = endPos;
				else
					nextPos = initialPos;
				// nextPos = nextPos ^ initialPos ^ endPos;
				// if ( hole[initialPos] > 0 )
				if ( holes.contains( initialPos ) )
				{
					System.out.println( initialPos );
					return;
				}
				// if ( hole[endPos] > 0 )
				if ( holes.contains( endPos ) )
				{
					System.out.println( endPos );
					return;
				}
			}
		}
		System.out.println( nextPos );
	}
}
