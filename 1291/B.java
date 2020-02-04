// 
import java.math.*;
import java.util.*;
import java.io.*;
  
public class B { 
  
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

            String[] sp = in.readLine().split(" ");
            int[] ary = new int[n];
            
            for(int i = 0; i < n; i++)
            {
                ary[i] = Integer.valueOf(sp[i]);
            }

            int base = 0;
            boolean ans = true;
            for(int i = 0; i < n; i++)
            {
                if(ary[i] >= base)
                {
                    base++;
                }
                else // changed direction
                {
                    int base2 = 0;
                    for(int j = n - 1; j >= i; j--)
                    {
                        if(ary[j] >= base2) base2++;
                        else ans = false;
                    }
                    base2--;
                    if(base2 >= ary[i - 1]) ans = false;
                    break;
                }
            }

            if(ans) System.out.println("Yes");
            else System.out.println("No");
        }
        
    }
}