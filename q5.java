import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

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

	void q5c() throws IOException
	{
		Stack<Character> stack = new Stack<>();
		String next = in.readLine();
		int start = 0, end = next.length() - 1;
		while ( next.charAt( start ) == ')' )
			start++;
		while ( next.charAt( end ) == '(' )
			end--;
		if ( start >= end )
		{
			System.out.println( "0 1" );
		}
		else
		{
			String substring = next.substring( start, end + 1 );
			for ( char c : substring.toCharArray() )
			{
				if ( c == '(' )
					stack.push( c );
				if ( c == ')' )
					stack.pop();
			}

		}
	}

	void q5b() throws IOException
	{
		LinkedList<String> list = new LinkedList<>();
		int maxlen = 0, adjustLeft = 1, adjustRight = 0;
		String next;
		while ( ( next = in.readLine() ) != null )
		{
			list.add( next );
			maxlen = Math.max( maxlen, next.length() );
		}
		// System.out.println( list );
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
		PrintWriter printWriter = new PrintWriter( new BufferedOutputStream( System.out ) );
		printWriter.println( print );
		printWriter.flush();
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

/** Class for buffered reading int and double values */
class Reader
{
	static BufferedReader reader;
	static StringTokenizer tokenizer;

	/** call this method to initialize reader for InputStream */
	static void init( InputStream input )
	{
		reader = new BufferedReader(
				new InputStreamReader( input ) );
		tokenizer = new StringTokenizer( "" );
	}

	/** get next word */
	static String next() throws IOException
	{
		while ( !tokenizer.hasMoreTokens() )
		{
			// TODO add check for eof if necessary
			tokenizer = new StringTokenizer(
					reader.readLine() );
		}
		return tokenizer.nextToken();
	}

	static int nextInt() throws IOException
	{
		return Integer.parseInt( next() );
	}

	static double nextDouble() throws IOException
	{
		return Double.parseDouble( next() );
	}
}
