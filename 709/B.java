// https://codeforces.com/contest/709/submission/68627311
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

        
        
        String[] sp = in.readLine().split(" ");
        int n = Integer.valueOf(sp[0]),
            pos = Integer.valueOf(sp[1]);
        if(n < 2) {
            System.out.println(0);
            return;
        }

        sp = in.readLine().split(" ");
       
        int[] ary = new int[n];
        
        for(int i = 0; i < n; i++)
        {
            ary[i] = Integer.valueOf(sp[i]);
        }

        Arrays.sort(ary);

        int d1 = dist(ary, 0, n - 2, pos),
            d2 = dist(ary, 1, n - 1, pos);

        System.out.println(Math.min(d1, d2));
    }

    static int dist(int[] ary, int from, int to, int pos)
    {
        if(pos <= ary[from]) return ary[to] - pos;
        if(ary[to] <= pos) return pos - ary[from];

        int d1 = 2 * (pos - ary[from]) + ary[to] - pos;
        int d2 = 2 * (ary[to] - pos) + pos - ary[from];

        return Math.min(d1, d2);
    }
}