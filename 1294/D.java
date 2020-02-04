// https://codeforces.com/contest/1294/submission/69391146
import java.math.*;
import java.util.*;
import java.io.*;
  
public class D { 
  
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

        int q = Integer.valueOf(sp[0]);
        int x = Integer.valueOf(sp[1]);
        int[] f = new int[x];
        int mini = 0;

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < q; i++)
        {
            int next = Integer.valueOf(in.readLine());
            f[next % x]++;
            while(f[mini % x] > 0) {
                f[mini % x]--;
                mini++;
            }
            System.out.println(mini);
        }
    }
}