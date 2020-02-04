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

        
        int n = Integer.valueOf(in.readLine());
        
        double[] f = new double[n + 10];
        f[1] = 1.0;
        for(int i = 2; i <= n; i++)
        {
            for(int j = 1; j < i; j++)
            {
                double res = (1.0 * j / i) + f[i - j];
                // if(f[i] > res) break;
                f[i] = Math.max(f[i], res);
            }
        }

        

        System.out.println(f[n]);
    }

}