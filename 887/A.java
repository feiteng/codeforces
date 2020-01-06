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

        String str = in.readLine();
        int c0 = 0, c1 = 0;

        for(char c : str.toCharArray()) {
            if(c == '1' && c1 == 0) c1++;
            if(c == '0' && c1 > 0) c0++;
        }
        if(c0 >= 6) System.out.println("yes");
        else System.out.println("no");
    }

// result
// http://codeforces.com/contest/887/submission/68328515

}