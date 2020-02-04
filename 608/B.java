// https://codeforces.com/contest/608/submission/70318038
import java.math.*;
import java.util.*;
import java.io.*;
  
public class B { 
  
    static BufferedReader in;
    static String file = "../in";
    static int test = 0; // 0 for local testing, 1 for std input

    static String[] split() throws Exception
    {
        return in.readLine().split(" ");
    }

    static int readInt() throws Exception
    {
        return Integer.valueOf(in.readLine());
    }

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

        
        
        String s1 = in.readLine(), s2 = in.readLine();
        Map<String, Integer> map = new HashMap<>();
        int m = s1.length();
        int n = s2.length();
        long re = 0;
        int[] f = new int[n + 1];
        for(int i = 0; i < n; i++)
        {
            f[i + 1] = f[i] + (s2.charAt(i) == '1' ? 1 : 0);
        }
        for(int i = 0; i < m; i++)
        {
            int a = s1.charAt(i) == '1' ? 1 : 0;
            int count = f[n - m + i + 1] - f[i];
            if(a == 0) re += count;
            else re += n - m + 1 - count;
            // System.out.println(re);
        }
        
        System.out.println(re);
    }

    
}