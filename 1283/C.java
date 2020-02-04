//
import java.math.*;
import java.util.*;
import java.io.*;
  
public class C { 
  
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

        String[] sp = in.readLine().split(" ");
        
        int[] ary = new int[n];

        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < n; i++)
        {
            ary[i] = Integer.valueOf(sp[i]) - 1;
            if(ary[i] < 0) set.add(i);  //unfilled
        }

        // Random r = new Random();

        for(int i = 0; i < n; i++)
        {
            if(ary[i] == -1) continue;
            int next = ary[i];
            while(!set.isEmpty())
            {
                while(ary[next] >= 0)
                {
                    next = ary[next];
                }
                
                int val = -1;
                for(int v : set)
                {
                    if(next == v) continue;
                    val = v;
                    break;
                }
                set.remove(val);
                ary[next] = val;
                next = ary[next];
                System.out.printf("%s \n", Arrays.toString(ary));
            }            
        }
        for(int i = 0; i < n; i++) 
        {
            System.out.printf("%d ", ary[i] + 1);
        }
    }
}