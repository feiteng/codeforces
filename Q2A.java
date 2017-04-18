import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Q2A

{

	public static void main( String[] args )
	{
		Scanner in = new Scanner( System.in );
		int n = Integer.valueOf( in.nextLine() );
		Map<String, NameScore> map = new HashMap<>();
		for ( int i = 0; i < n; i++ )
		{
			String string = in.nextLine();
			String[] s = string.split( " " );
			if ( map.containsKey( s[0] ) )
				map.get( s[0] ).updateScore( Integer.valueOf( s[1] ), i );
			else
				map.put( s[0], new NameScore( s[0], Integer.valueOf( s[1] ), i ) );
		}
		List<NameScore> list = new ArrayList<>( map.values() );
		for ( NameScore names : list )
			names.updateList();
		Collections.sort( list, ( a, b ) -> b._score != a._score ? b._score - a._score : a._pos - b._pos );
		System.out.println( list.get( 0 )._name );
	}

}

class NameScore
{
	String _name;
	int _score, _pos;
	List<ScoreTrace> _scoreTrace = new ArrayList<>();

	public NameScore( String name, int score, int pos )
	{
		_name = name;
		_score = score;
		_pos = pos;
		_scoreTrace.add( new ScoreTrace( _score, _pos ) );
	}

	void updateScore( int score, int pos )
	{
		_score += score;
		_pos = pos;
		_scoreTrace.add( new ScoreTrace( _score, _pos ) );
	}

	void updateList()
	{
		for ( ScoreTrace s : _scoreTrace )
			if ( s._score >= _score )
			{
				_pos = s._pos;
				break;
			}
	}
}

class ScoreTrace
{
	int _score, _pos;

	public ScoreTrace( int score, int pos )
	{
		_score = score;
		_pos = pos;
	}
}
