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

        
        String[] sp = in.readLine().split(" ");
        int n = Integer.valueOf(sp[0]),
            q = Integer.valueOf(sp[1]);
        int[][] g = new int[2][n];

        Set<String> set = new HashSet<>();
        int[] dx = {-1, -1, -1, 1, 1, 1},
                dy = {-1, 0, 1, -1, 0, 1};
        for(int i = 0; i < q; i++)
        {
            sp = in.readLine().split(" ");
            int r = Integer.valueOf(sp[0]) - 1,
                c = Integer.valueOf(sp[1]) - 1;
            g[r][c] = 1 - g[r][c];
            // yes if left, mid, right >= 3
            // else no
            // test 6 cases

            for(int k = 0; k < 6; k++)
            {
                int nr = r + dx[k], nc = c + dy[k];
                if(nr < 0 || nc < 0 || nr >= 2 || nc >= n) continue;
                if(g[r][c] == 1)    // create barrier
                {
                    if(g[nr][nc] == 1) 
                    {
                        // cannot pass
                        int a = r * q + c, b = nr * q + nc;
                        if(a > b)
                        {
                            int t = a;
                            a = b;
                            b = t;
                        }
                        String str = "" + a + "_" + b;
                        set.add(str);
                    }
                }
                else
                {
                    // see if can remove any barrier
                    if(g[nr][nc] == 1)
                    {
                        int a = r * q + c, b = nr * q + nc;
                        if(a > b)
                        {
                            int t = a;
                            a = b;
                            b = t;
                        }
                        String str = "" + a + "_" + b;
                        set.remove(str);
                    }
                }
            }
            // System.out.println(set);
            if(set.size() > 0) System.out.println("No");
            else System.out.println("Yes");
        }
        
    }

}