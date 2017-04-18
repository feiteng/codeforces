import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class Pablito
{
	public static void main(String[] args) throws Exception
	{
		// File file = new File( "C:\\Users\\Rutter\\Desktop\\java\\CodeForces\\USP\\t.txt" );
		// Scanner in = new Scanner(file);
		Scanner in = new Scanner(System.in);
		int n = Integer.valueOf(in.nextLine());
		for(int i = 0; i < n; i++)
		{
			String s = in.nextLine();
			String[] s_ = s.split(" ");
			long a = Long.valueOf(s_[0]), b = Long.valueOf(s_[1]);
			if(gcd(a,b)==1) System.out.println("Nao");
			else System.out.println("Sim");
		}

	}

	static long gcd(long a,long b)
	{
		if(a<b)
		{
			long t = a;
			a = b;
			b = t;
		}

		if(b==1) return 1;
		if(a%b==0) return b;
		return gcd (b,a%b);
	}


}