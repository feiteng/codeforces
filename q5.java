import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class q5
{
	static BufferedReader in;

	public static void main( String[] args ) throws IOException
	{
		q5 q = new q5();
		in = new BufferedReader(

				// new FileReader( "C:/Users/Rutter/Desktop/java/CodeForces/codeforces/t.txt" ) );

				new InputStreamReader( System.in ) );
		q.q5b();
		in.close();
	}

	void q5b() throws IOException
	{
		List<String> list = new ArrayList<>();
		int maxlen = 0, adjustLeft = 1, adjustRight = 0;
		String next;
		while ( ( next = in.readLine() ) != null )
		{

			list.add( next );
			maxlen = Math.max( maxlen, next.length() );
		}
		// maxlen += 2;
		String print = "";
		for ( int i = 0; i < maxlen + 2; i++ )
			print += "*";
		print += "\n";
		for ( String s : list )
		{
			print += "*";
			int white = maxlen - s.length(), add = 0;
			if ( white % 2 != 0 )
			{
				adjustLeft = 1 - adjustLeft;
				adjustRight = 1 - adjustRight;
				add = 1;
			}
			for ( int i = 0; i < white / 2 + adjustLeft * add; i++ )
				print += " ";
			print += s;
			for ( int i = 0; i < white / 2 + adjustRight * add; i++ )
				print += " ";
			print += "*\n";
		}
		for ( int i = 0; i < maxlen + 2; i++ )
			print += "*";
		System.out.println( print );
	}

	void q5a() throws IOException
	{

		Set<String> set = new HashSet<>();
		int count = 0;
		String next;
		while ( ( next = in.readLine() ) != null )
		{

			if ( next.charAt( 0 ) == '+' )
			{
				set.add( next.substring( 1 ) );
			}
			else if ( next.charAt( 0 ) == '-' )
			{
				set.remove( next.substring( 1 ) );
			}
			else // if ( next.indexOf( ':' ) > 0 )
			{
				String msg = next.substring( next.indexOf( ':' ) + 1 );
				count += msg.length() * set.size();
			}
			// next = in.nextLine();
		}
		System.out.println( count );
	}

}
