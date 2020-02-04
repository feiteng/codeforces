// https://codeforces.com/contest/725/submission/68385647
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

        
        int n = Integer.valueOf(in.readLine());
        String str = in.readLine();
        int i = 0, j = n - 1;
        
        int left = 0;
        if(str.charAt(i) == '<')
        {
            while(i < n && str.charAt(i) == '<') 
                i++;
            left = i;
        }
        
        int right = 0;
        if(str.charAt(j) == '>')
        {
            while(j >= 0 && str.charAt(j) == '>') 
                j--;
            if(j < 0) right = n;
            else right = n - 1 - j;
        }
        System.out.println(left + right);
        // String[] sp = in.readLine().split(" ");
        
    }
}