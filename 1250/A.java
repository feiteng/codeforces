// https://codeforces.com/contest/1250/submission/68457121
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
        
        int n = Integer.valueOf(sp[0]);
        int m = Integer.valueOf(sp[1]);

        sp = in.readLine().split(" ");
        
        int[] pos = new int[n + 1];
        int[] value = new int[n + 1];

        int[] mini = new int[n + 1];
        int[] maxi = new int[n + 1];

        for(int i = 0; i <= n; i++)
        {
            value[i] = i;
            pos[i] = i;
            mini[i] = i;
            maxi[i] = i;
        }

        for(int i = 0; i < m; i++)
        {
            int val = Integer.valueOf(sp[i]);
            int index = pos[val];
            // System.out.printf("..%d\n", index);
            if(index == 1) continue;
            // swap values
            // value[index] = val
            int val_prev = value[index - 1];
            
            // update value
            value[index - 1] = val;
            value[index] = val_prev;

            // update index
            pos[val] = index - 1;
            pos[val_prev] = index;  

            // update ranges
            mini[val] = Math.min(mini[val], index - 1);
            maxi[val_prev] = Math.max(maxi[val_prev], index);
            
            // System.out.println(Arrays.toString(value));
            // System.out.println(Arrays.toString(mini));
            // System.out.println(Arrays.toString(maxi));
            // System.out.println();
        }

        for(int i = 1; i <= n; i++)
        {
            System.out.printf("%d %d\n", mini[i], maxi[i]);
        }
    }
}
