import java.util.Scanner;

public class Q3a
{
	public static void main( String[] args )
	{
		Scanner in = new Scanner( System.in );
		String p1 = in.nextLine(), p2 = in.nextLine();
		int p1x = p1.charAt( 0 ) - 'a', p1y = Integer.valueOf( p1.charAt( 1 ) ),
				p2x = p2.charAt( 0 ) - 'a', p2y = Integer.valueOf( p2.charAt( 1 ) );

		String moves = "";
		int count = 0;
		while ( p1x != p2x || p1y != p2y )
		{
			if ( p1x < p2x )
			{
				moves += "R";
				p1x++;
			}
			if ( p1x > p2x )
			{
				moves += "L";
				p1x--;
			}
			if ( p1y < p2y )
			{
				moves += "U";
				p1y++;
			}
			if ( p1y > p2y )
			{
				moves += "D";
				p1y--;
			}
			moves += "\n";
			count++;
		}

		System.out.println( count );
		System.out.printf( "%s", moves );
	}
}
