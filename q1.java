import java.util.Scanner;
import java.util.regex.Pattern;

public class q1
{
	public static void main( String[] args )
	{
		q1 q1 = new q1();
		q1.q1b();
	}

	void q1b()
	{

		Pattern rc = Pattern.compile( "R\\d{1,}C\\d*" ), cell = Pattern.compile( "[A-Z]{1,}\\d*" );
		Scanner in = new Scanner( System.in );
		int n = Integer.valueOf( in.nextLine() );
		for ( int i = 0; i < n; i++ )
		{
			String nextString = in.nextLine();
			if ( rc.matcher( nextString ).matches() )
				System.out.println( rc2Cell( nextString ) );
			else if ( cell.matcher( nextString ).matches() )
				System.out.println( cell2Rc( nextString ) );
			else
				System.out.println( "ERROR" );

		}
	}

	static String rc2Cell( String s )
	{
		int cPos = s.indexOf( "C" );
		int row = Integer.valueOf( s.substring( 1, cPos ) ), column = Integer.valueOf( s.substring( cPos + 1, s.length() ) );
		String cell = "";
		while ( column > 0 )
		{
			int remainder = column % 26;
			column /= 26;
			if ( remainder == 0 ) // remainder ranges from 1 to 26
			{
				remainder = 26;
				column--;
			}

			cell = String.valueOf( (char) ( remainder - 1 + 'A' ) ) + cell;

		}
		return cell + row;
	}

	static String cell2Rc( String s )
	{

		int i = 0;
		while ( s.charAt( i ) >= 'A' && s.charAt( i ) <= 'Z' )
			i++;
		String cell = s.substring( 0, i );
		int column = 0, row = Integer.valueOf( s.substring( i, s.length() ) );
		if ( cell.length() < 2 )
			column = Character.valueOf( cell.charAt( 0 ) ) - 'A' + 1;
		else
		{
			column = 0;
			for ( i = 0; i < cell.length(); i++ )
				column = column * 26 + ( cell.charAt( i ) - 'A' + 1 );
		}
		return "R" + row + "C" + column;
	}
}
