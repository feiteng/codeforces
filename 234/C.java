// 

import java.math.*;
import java.util.*;
import java.io.*;
  
public class C { 
  
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

        in.readLine();
        
        String[] sp = in.readLine().split(" ");
        
        // System.out.println(Arrays.toString(sp));
        
        int n = sp.length;

        int[] left = new int[n], right = new int[n];
        int[] ary = new int[n];
        for(int i = 0; i < n; i++) 
        {
            ary[i] = Integer.valueOf(sp[i]);
        }
        if(ary[0] >= 0) left[0] = 1;
        for(int i = 1; i < n; i++) 
        {
            left[i] = left[i - 1];
            if(ary[i] >= 0) 
                left[i]++;
        }
        if(ary[n - 1] <= 0) right[n - 1] = 1;
        for(int i = n - 2; i >= 0; i--)
        {
            right[i] = right[i + 1];
            if(ary[i] <= 0) 
                right[i]++;
        }
        int re = n + 1;
        for(int i = 0; i < n - 1; i++)
        {
            re = Math.min(re, left[i] + right[i + 1]);
        }
        // if(re >= 1 << 30) re = 0;
        System.out.println(re);
    }

}