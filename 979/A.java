// http://codeforces.com/contest/979/submission/68327591

import java.math.*;
import java.util.*;
import java.io.*;
  
public class A { 
  
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

        // int n = Integer.valueOf(in.readLine());
        // String[] sp;
        // sp = in.readLine().split(" ");
        // int a = Integer.valueOf(sp[0]),
        //     b = Integer.valueOf(sp[1]);
        long n = Long.valueOf(in.readLine());
        n++;
        if(n == 1) System.out.println(0);
        else if(n % 2 == 0) System.out.println(n / 2);
        else System.out.println(n);
    }

// result

   
}