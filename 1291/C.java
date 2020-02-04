// 
import java.math.*;
import java.util.*;
import java.io.*;
  
public class C { 
  
    static BufferedReader in;
    static String file = "../in";
    static int test = 0;   // 0 for local testing, 1 for std input
    public static void main(String[] args) throws Exception
    {
        int _k = Integer.valueOf("1");
        if(test > 0) in = new BufferedReader(new InputStreamReader(System.in));
        else in = new BufferedReader(new FileReader(file));
        if(test < 0) {String[] str = in.readLine().split(" ");}

        
        
        /****************************************************/
        /****************************************************/
        /****************************************************/
        /****************************************************/

        int t = Integer.valueOf(in.readLine());
        while(t-- > 0)
        {
            String[] sp = in.readLine().split(" ");
            int n = Integer.valueOf(sp[0]),
                m = Integer.valueOf(sp[1]),
                k = Integer.valueOf(sp[2]);

            k = Math.min(m - 1, k);
            sp = in.readLine().split(" ");
            int[] ary = new int[n];
            
            for(int i = 0; i < n; i++)
            {
                ary[i] = Integer.valueOf(sp[i]);
            }

            int rem = m - k - 1;
            int from = 0, to = n - 1 - k;
            int ans = 0;
            while(to < n)
            {
                ans = Math.max(ans, findmin(ary, from, to, rem));
                from++;
                to++;
            }
            System.out.println(ans);
        }        
    }

    static int findmin(int[] ary, int from, int to, int k)
    {
        int i = from + k, j = to;
        int ans = 1 << 30;
        while(k-- >= 0)
        {
            ans = Math.min(ans, Math.max(ary[i], ary[j]));
            if(test == 0) System.out.println(".." + Math.max(ary[i], ary[j]));
            i--;
            j--;
        }
        if(test == 0) System.out.printf("...%d %d %d\n", from, to, ans);
        return ans;
    }
}