// https://codeforces.com/contest/1095/submission/68382507
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

        String[] sp = in.readLine().split(" ");
        int a = Integer.valueOf(sp[0]),
            b = Integer.valueOf(sp[1]);
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < 31; i++) 
        {
            if((a & (1 << i)) != 0) 
                q.offer(1 << i);
        }

        while(q.size() < b)
        {
            int next = q.poll();
            if(next == 1) break;
            q.offer(next / 2);
            q.offer(next / 2);
        }

        if(q.size() != b) System.out.println("NO");
        else
        {
            System.out.println("YES");
            while(!q.isEmpty()) System.out.printf("%d ", q.poll());
        }

    }
}