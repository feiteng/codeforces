// 
import java.math.*;
import java.util.*;
import java.io.*;
  
public class E2 { 
  
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

        
        
        int n = readInt();
        String str = in.readLine();

        int[] f = new int[26];
        int[] re = new int[n];

        int maxi = 0;
        
        for(int i = 0; i < n; i++)
        {
            char c = str.charAt(i);
            int lastColor = Math.max(1, f[c - 'a']);
            for(int j = c - 'a' + 1; j < 26; j++)
            {
                lastColor = Math.max(lastColor, f[j] + 1);
            }
            re[i] = lastColor;
            maxi = Math.max(maxi, re[i]);
            f[c - 'a'] = lastColor;
        }

        System.out.println(maxi);
        StringBuilder sb = new StringBuilder();
        for(int i : re) sb.append(i + " ");
        System.out.println(sb);
        System.out.flush();        
    }

}