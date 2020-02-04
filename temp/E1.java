// 
import java.math.*;
import java.util.*;
import java.io.*;
  
public class E1 { 
  
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

        
        
        int n = Integer.valueOf(in.readLine());
        String str = in.readLine();

        int[] f = new int[256];
        int[] re = new int[n];

        boolean flag = true;
        for(int i = 0; i < n; i++)
        {
            char c = str.charAt(i);
            int colors = 0;
            for(int j = 0; j < i; j++)
            {
                if(str.charAt(j) > c)
                {
                    colors |= f[str.charAt(j)];    
                }
                
            }
            if(colors == 0) {
                re[i] = 0;
                f[c] = 1;
            }
            if(colors == 1) {
                re[i] = 1;
                f[c] = 2;
            }
            if(colors == 2) {
                re[i] = 0;
                f[c] = 1;
            }
            if(colors == 3) {
                f[c] = 3;
                flag = false;
                re[i] = 3;
            }
        }

        if(!flag) System.out.println("No");
        else
        {
            System.out.println("Yes");
            for(int i : re) System.out.printf("%d", i);
        }
    }

}