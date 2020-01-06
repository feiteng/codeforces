// https://codeforces.com/contest/617/submission/68336650

import java.math.*;
import java.util.*;
import java.io.*;
  
public class B { 
  
    static BufferedReader in;
    static String file = "../in";

    static long[][] f = new long[110][110];
 
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
        String[] sp = in.readLine().split(" ");
        
        int[] ary = new int[n];
        int totalCount = 0;
        for(int i = 0; i < n; i++) {
            ary[i] = Integer.valueOf(sp[i]);
            totalCount += ary[i];
        }
        if(totalCount == 1) {
            System.out.println(1);
            return;
        }
        
        int count = 0;
        long re = 0;
        for(int i = 0; i < n; i++) {
            count += ary[i];
            if(count < 1) continue;
            if(count > 1) break;
            re += split(ary, i + 1, n - 1, totalCount - 1);
            // System.out.println(re);
        }
        System.out.println(re);       
    }

    static long split(int[]ary, int from, int to, int total) {
        // System.out.printf("..%d %d\n", from, to);
        if(total == 1) return 1;
        if(f[from][to] > 0) return f[from][to];
        int count = 0;
        long re = 0;
        for(int i = from; i < to; i++) {
            count += ary[i];
            if(count < 1) continue;
            if(count > 1) break;
            re += split(ary, i + 1, to, total - 1);
        }
        return f[from][to] = re;
    }
}