// https://codeforces.com/contest/194/submission/68379164

import java.math.*;
import java.util.*;
import java.io.*;
  
public class B { 
  
    static BufferedReader in;
    static String file = "../in";

    public static void main(String[] args) throws Exception
    {
        int test = 0,   // 0 for local testing, 1 for std input
            _k = Integer.valueOf("1");
        if(test > 0) in = new BufferedReader(new InputStreamReader(System.in));
        else in = new BufferedReader(new FileReader(file));
        if(test < 0) {String[] str = in.readLine().split(" ");}
        
        /****************************************************/
        /****************************************************/
        /****************************************************/
        /****************************************************/

        int n = Integer.valueOf(in.readLine());
        String[] sp = in.readLine().split(" ");
        
        for(int i = 0; i < n; i++) 
        {
            long len = Long.valueOf(sp[i]);
            long a = len * 4;
            long b = len + 1;
            long g = gcd(a, b), lcm = a * b / g;
            
            System.out.println(lcm / b + 1);

        }
    
    }

    static long gcd(long a, long b)
    {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}