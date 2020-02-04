// 
import java.math.*;
import java.util.*;
import java.io.*;
  
public class D { 
  
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

        
        String[] sp = in.readLine().split(" ");
        int n = Integer.valueOf(sp[0]),
            a = Integer.valueOf(sp[1]),
            b = Integer.valueOf(sp[2]),
            k = Integer.valueOf(sp[3]);
        sp = in.readLine().split(" ");
        int[] ary = new int[n];
        int ab = a + b;
        int points = 0;
        for(int i = 0; i < n; i++)
        {
            ary[i] = Integer.valueOf(sp[i]);
            ary[i] %= ab;
            if(ary[i] == 0) ary[i] = ab;
        }

        Arrays.sort(ary);

        // determine highest point
        // assuming I always attack first on each monster
        // when to use special?
        // only if I can kill the monster with this hit 
        // when it's B's turn


        for(int i = 0; i < n; i++)
        {
            int h = ary[i];
            // System.out.printf("%d ", h);
            // my turn again
            if(h - a <= 0) points++;
            else
            {
                h -= a;
                if(k > 0 && h - a * k <= 0)
                {
                    int k2 = h / a;
                    if(h % a > 0) k2++;
                    k = Math.max(0, k - k2);
                    points++;
                }
            }
            // System.out.printf("%d \n", points);
        }
        System.out.println(points);
    }

}