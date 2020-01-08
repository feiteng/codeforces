// http://codeforces.com/contest/705/submission/68325075

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
        int n = Integer.valueOf(in.readLine());
        for(int i = 1; i < n; i++) {
            System.out.printf("I %s that ", i % 2 == 0 ? "love" : "hate");
        }
        System.out.printf("I %s it", n % 2 == 0 ? "love" : "hate");
    }

// result

}