import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q2B implements Runnable
{
	public static void main( String[] args ) throws IOException
	{
		long time = System.currentTimeMillis();
		Q2B q = new Q2B();
		q.run();
		System.out.printf( "%d\n", System.currentTimeMillis() - time );
	}

	public void run()
	{
		try
		{
			long time = System.currentTimeMillis();
			boolean haveZero = false;
			int zi = 0, zj = 0;
			in = new Scanner( new File( "2/w.txt" ) );
			// System.in );//
			int n = Integer.valueOf( in.nextLine() );
			int[][] m2 = new int[n][n], m5 = new int[n][n];
			boolean[][] p2 = new boolean[n][n], p5 = new boolean[n][n];
			String[][] path = new String[n][n];
			for ( int i = 0; i < n; i++ )
			{
				String string = in.nextLine();
				int pos = 0, end;
				for ( int j = 0; j < n; j++ )
				{
					end = string.indexOf( ' ', pos );
					int num = Integer.valueOf( string.substring( pos, end ) );
					// string=string.substring( end )
					pos = end + 1;
					if ( num == 0 )
					{
						haveZero = true;
						zi = i;
						zj = j;
						num = 10;
					}
					while ( num % 2 == 0 )
					{
						m2[i][j]++;
						num /= 2;
					}
					while ( num % 5 == 0 )
					{
						m5[i][j]++;
						num /= 5;
					}
				}
			}
			System.out.printf( "%d\n", System.currentTimeMillis() - time );
			time = System.currentTimeMillis();
			int f2 = findFP( m2, p2 );
			System.out.printf( "%d\n", System.currentTimeMillis() - time );
			time = System.currentTimeMillis();
			int f5 = findFP( m5, p5 );
			System.out.printf( "%d\n", System.currentTimeMillis() - time );

			if ( haveZero && Math.min( f2, f5 ) > 1 )
			{
				System.out.println( "1" );
				String zpath = "";
				for ( int k = 0; k < zi; k++ )
					zpath += "D";
				for ( int k = 0; k < zj; k++ )
					zpath += "R";
				for ( int k = zi; k < n - 1; k++ )
					zpath += "D";
				for ( int k = zj; k < n - 1; k++ )
					zpath += "R";
				System.out.println( zpath );
				return;

			}

			System.out.println( Math.min( f2, f5 ) );
			if ( f2 < f5 )
				System.out.println( print( p2 ) );
			else
				System.out.println( print( p5 ) );
		}

		catch (

		Exception e)
		{
			System.err.println( e );
		}
	}

	String print( boolean[][] p )
	{
		// for ( boolean[] p1 : p )
		// System.out.println( Arrays.toString( p1 ) );
		int n = p.length, i = n - 1, j = n - 1;
		String path = "";
		while ( i >= 0 && j >= 0 )
		{
			if ( i == 0 && j == 0 )
				break;
			if ( p[i][j] )
			{
				path = "R" + path;
				j--;
			}
			else
			{
				path = "D" + path;
				i--;
			}
		}
		return path;
	}

	int findFP( int[][] matrix, boolean[][] path )
	{
		int m = matrix.length, n = matrix[0].length;
		int[][] f = new int[2][n];
		for ( int i = 0; i < m; i++ )
		{
			for ( int j = 0; j < n; j++ )
			{
				if ( i == 0 && j == 0 )
					f[1][0] = matrix[0][0];
				else if ( i == 0 )
				{
					f[1][j] = f[1][j - 1] + matrix[i][j];
					path[i][j] = true;
				}
				else if ( j == 0 )
					f[1][0] = f[0][0] + matrix[i][j];
				else
				{
					path[i][j] = f[1][j - 1] <= f[0][j] ? true : false;
					f[1][j] = Math.min( f[1][j - 1], f[0][j] ) + matrix[i][j];
					// System.out.println( "f0\t" + Arrays.toString( f[0] ) );
					// System.out.println( "f1\t" + Arrays.toString( f[1] ) );

				}
			}
			f[0] = f[1];
			// System.out.println( Arrays.toString( f[0] ) );

		}
		return f[1][n - 1];
	}

	Scanner in;
	StringTokenizer tokenizer;

	int nextInt() throws IOException
	{
		return Integer.parseInt( nextToken() );
	}

	String nextToken() throws IOException
	{
		while ( tokenizer == null || !tokenizer.hasMoreTokens() )
		{
			tokenizer = new StringTokenizer( in.nextLine() );
		}
		return tokenizer.nextToken();
	}
}
