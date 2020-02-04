// https://codeforces.com/contest/182/submission/70317507
import java.math.*;
import java.util.*;
import java.io.*;
  
public class D { 
  
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
        Set<String> d1 = getDivisor(s1),
                    d2 = getDivisor(s2);
        // System.out.println(d1);
        // System.out.println(d2);
        d1.retainAll(d2);
        System.out.println(d1.size());
    }

    static Set<String> getDivisor(String str)
    {
        int n = str.length();
        Set<String> set = new HashSet<>();
        for(int i = 1; i <= n; i++)
        {
            if(n % i == 0)
            {
                String sub = str.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n / i; j++) sb.append(sub);
                if(sb.toString().equals(str)) set.add(sub);
                // System.out.println(sb);
            }
        }
        return set;
    }
}