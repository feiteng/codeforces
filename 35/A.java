// #
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

        int[] cup = new int[4];
        int pos = Integer.valueOf(in.readLine());
        cup[pos] = 1;
        for(int i = 0; i < 3; i++) {
            String str = in.readLine();
            int a = str.charAt(0) - '0',
                b = str.charAt(2) - '0';
            int t = cup[a];
            cup[a] = cup[b];
            cup[b] = t;
        }
        for(int i = 1; i <= 3; i++) 
            if(cup[i] > 0) 
                System.out.println(i);
    }

// result
// 

}

