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

        String[] sp;
        sp = in.readLine().split(" ");
        int a = Integer.valueOf(sp[0]),
            k = Integer.valueOf(sp[1]);
        while(k-- > 0) {
            if(a % 10 == 0) a /= 10;
            else a--;
        }

        System.out.println(a);
    }

    // result http://codeforces.com/contest/977/submission/68324610
}