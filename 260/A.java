// https://codeforces.com/contest/260/submission/68336826

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
        String astr = sp[0];
        int a = Integer.valueOf(sp[0]),
            b = Integer.valueOf(sp[1]),
            k = Integer.valueOf(sp[2]);
        a %= b;
        String str = "";
        while(k > 0) {
            boolean found = false;
            for(int i = 0; i <= 9; i++) {
                if((a * 10 + i) % b == 0)
                {
                    a = (a * 10 + i) % b;
                    str += "" + i;
                    found = true;
                    break;
                }
            }
            if(!found) break;
            k--;
        }
        if(k > 0) System.out.println(-1);
        else System.out.println(astr + str);
    }
}