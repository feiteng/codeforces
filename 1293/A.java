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
            new A().task();
        }
    }

    void task() throws Exception
    {
        String[] sp = in.readLine().split(" ");    
        int n = Integer.valueOf(sp[0]),
            s = Integer.valueOf(sp[1]),
            k = Integer.valueOf(sp[2]);

        sp = in.readLine().split(" ");
        int[] ary = new int[k];

        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < k; i++)
        {
            ary[i] = Integer.valueOf(sp[i]);
            set.add(ary[i]);
        }

        int prev = s, next = s;
        for(int j = 0; j < 1010; j++)
        {
            if(!set.contains(prev) && !set.contains(next))
            {
                int c1 = s - prev,
                    c2 = next - s;

                System.out.println(Math.min(c1, c2));

                return;
            }
            else if(!set.contains(prev) || !set.contains(next))
            {
                if(!set.contains(prev)){
                    System.out.println(s - prev);
                    return;
                }
                if(!set.contains(next)) 
                {
                    System.out.println(next - s);
                    return;
                }
            }
            prev--;
            next++;
            prev = Math.max(prev, 1);
            next = Math.min(n, next);
        }
            
    }
}