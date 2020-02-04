// 
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

        int t = Integer.valueOf(in.readLine());
        while(t-- > 0)
        {
            int n = Integer.valueOf(in.readLine());
            String str = in.readLine();
            int odd = 0;
            for(char c : str.toCharArray())
            {
                int val = (c - '0');
                if(val % 2 != 0) odd++;
            }
            if(odd < 2) System.out.println("-1");
            else if(odd % 2 == 0) System.out.println(str);
            else
            {
                // take out 1 odd and make sure last digit is odd
                int j = n - 1;
                while((str.charAt(j) - '0') % 2 == 0) j--;
                // now j points to last odd
                int i = 0;
                while((str.charAt(i) - '0') % 2 == 0) i++;
                String sub1 = str.substring(0, i);
                String sub2 = str.substring(i + 1, j);
                System.out.println(sub1 + sub2);
            }

        }
        
    }
}