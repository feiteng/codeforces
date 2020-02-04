// https://codeforces.com/contest/922/submission/68382648
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

        String[] sp = in.readLine().split(" ");
        int x = Integer.valueOf(sp[0]),
            y = Integer.valueOf(sp[1]);
        if(y < 1)
        {
            System.out.println("No");
            return;
        }
        if(y == 1)
        {
            if(x == 0) System.out.println("Yes");
            else System.out.println("No");
            return;
        }
        y--;
        if(x < y)
        {
            System.out.println("No");
            return;
        }
        x -= y;
        if(x % 2 != 0)
        {
            System.out.println("No");
            return;
        }
        System.out.println("Yes");
    }
}