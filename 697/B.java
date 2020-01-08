// https://codeforces.com/contest/489/submission/68379714
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

        String[] sp = in.readLine().split(" ");
        int n = Integer.valueOf(sp[0]),
            s = Integer.valueOf(sp[1]);

        if(s == 0)
        {
            if(n != 1)
            {
                System.out.println("-1 -1");
                return;
            }
            else
            {
                System.out.println("0 0");
                return;
            }
        }
        // construct one by one
        if(n * 9 < s) {
            System.out.println("-1 -1");
            return;
        }
        char[] mini = new char[n], maxi = new char[n];
        int s1 = s, s2 = s;
        for(int i = 0; i < n; i++)
        {
            // current minimum
            int cap = (n - 1 - i) * 9;
            boolean found = false;
            for(int j = 0; j < 10; j++)
            {
                if(i == 0 && j == 0) continue;
                if(0 <= s1 - j && s1 - j <= cap)
                {
                    s1 -= j;
                    mini[i] = (char)(j + '0');
                    found = true;
                    break;
                }
            }
            if(!found)
            {
                System.out.println("-1 -1");
                return;
            }
            int next = n - 1;
            for(int j = 9; j >= 0; j--)
            {
                if(0 <= s2 - j && s2 - j <= cap)
                {
                    s2 -= j;
                    maxi[i] = (char)(j + '0');
                    break;
                }
            }
        }
        System.out.printf("%s %s\n", String.valueOf(mini), String.valueOf(maxi));
    }
}