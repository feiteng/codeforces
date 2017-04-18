import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class Ciroc
{
	public static void main(String[] args) throws Exception
	{
		// File file = new File( "C:\\Users\\Rutter\\Desktop\\java\\CodeForces\\USP\\t.txt" );
		// Scanner in = new Scanner(file);
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), count = 0;
		while(n>0)
		{
			count++;
			n=n/2;
		}
		System.out.println(count);

	}


}