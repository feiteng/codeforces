// 
import java.math.*;
import java.util.*;
import java.io.*;
  
public class B { 
  
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
            
            int s = Integer.valueOf(in.readLine());
            long re = 0;
            while(s >= 10)
            {
                int a = s / 10;
                re += a * 10;
                s = s - a * 10 + a;
            }
            re += s;
            System.out.println(re);
            
        }
        
    }

}