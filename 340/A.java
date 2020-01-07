// https://codeforces.com/contest/340/submission/68376286

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
        String[] sp = in.readLine().split(" ");
        int x = Integer.valueOf(sp[0]),
            y = Integer.valueOf(sp[1]),
            a = Integer.valueOf(sp[2]),
            b = Integer.valueOf(sp[3]);
        int g = gcd(x, y), lcm = x * y / g;
        System.out.println(b / lcm - (a - 1) / lcm);
    }

    static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}