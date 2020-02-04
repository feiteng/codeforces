// 
import java.math.*;
import java.util.*;
import java.io.*;
  
public class A { 
  
    static BufferedReader in;
    static String file = "../in";
    static int test = 0; // 0 for local testing, 1 for std input

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

        
        int T = Integer.valueOf(in.readLine());
        while(T-- > 0)
        {
            
            int n = Integer.valueOf(in.readLine());
            String[] sp = in.readLine().split(" ");
            int[] ary = new int[n];
            int odd = 0, even = 0;
            for(int i = 0; i < n; i++)
            {
                ary[i] = Integer.valueOf(sp[i]);
                if(ary[i] % 2 == 0) even++;
                else odd++;
            }
            if(odd == 0) System.out.println("No");
            else {
                if(even == 0 && odd % 2 == 0) System.out.println("No");
                else System.out.println("Yes");
            }

        }
        
    }

}