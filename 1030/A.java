// https://codeforces.com/contest/1030/submission/68324733
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

        int n = Integer.valueOf(in.readLine());
        String[] sp;
        sp = in.readLine().split(" ");
        boolean hard = false;
        for(int i = 0; i < n; i++) {
            int k = Integer.valueOf(sp[i]);
            if(k > 0) {
                hard = true;
            }
        }
        if(hard) System.out.println("HARD");
        else System.out.println("EASY");
    }

// result
//
}