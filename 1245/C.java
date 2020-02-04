// https://codeforces.com/contest/1245/submission/68385198
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

        
        String str = in.readLine();
        // String[] sp = in.readLine().split(" ");
        
        int n = str.length();

        int[] f = new int[n + 1];
        f[0] = 1;
        int mod = 1_000_000_007;

        // w or m are invalid characters


        for(int i = 0; i < n; i++)
        {
            char c = str.charAt(i);
            f[i + 1] = f[i];
            if(c == 'u' && i > 0)
            {
                char prev = str.charAt(i - 1);
                if(prev == 'u')
                {
                    f[i + 1] = (f[i + 1] + f[i - 1]) % mod;
                }
            }
            if(c == 'n' && i > 0)
            {
                char prev = str.charAt(i - 1);
                if(prev == 'n') 
                {
                    f[i + 1] = (f[i + 1] + f[i - 1]) % mod;
                }
            }
            if(c == 'w' || c == 'm')
            {
                System.out.println(0);
                return;
            }
        }
        System.out.println(f[n]);

    }
}