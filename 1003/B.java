// https://codeforces.com/contest/1003/submission/68374289

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

        // int n = Integer.valueOf(in.readLine());
        String[] sp = in.readLine().split(" ");
        String astr = sp[0];
        int a = Integer.valueOf(sp[0]),
            b = Integer.valueOf(sp[1]),
            k = Integer.valueOf(sp[2]);
        // k indices where the consecutive indices are different
        String str = "";
        int start = 1;
        if(a > b) start = 0;
        while(k-- > 1) {
            if(start == 0) {
                str += "0";
                a--;
            }
            else {
                str += "1";
                b--;
            }
            start = 1 - start;
        }
        if(start == 0) {
            while(a-- > 0) str += "0";
            while(b-- > 0) str += "1";
        }
        else {
            while(b-- > 0) str += "1";
            while(a-- > 0) str += "0";
        }

        System.out.println(str);

    }
}