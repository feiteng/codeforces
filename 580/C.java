// 
import java.math.*;
import java.util.*;
import java.io.*;
  
public class C { 
  
    static BufferedReader in;
    static String file = "../in";

    static int test = 0;  // 0 for local testing, 1 for std input

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
        
        int n = Integer.valueOf(sp[0]);
        int m = Integer.valueOf(sp[1]);

        sp = in.readLine().split(" ");
        
        int[] ary = new int[n + 1];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++)
        {
            ary[i + 1] = Integer.valueOf(sp[i]);
            map.put(i + 1, new ArrayList<>());
        }

        for(int i = 0; i < n - 1; i++)
        {
            sp = in.readLine().split(" ");
            int from = Integer.valueOf(sp[0]);
            int to = Integer.valueOf(sp[1]);
            map.get(from).add(to);
            map.get(to).add(from);
        }

        Set<Integer> visited = new HashSet<>();

        visited.add(1);

        int count = dfs(1, 0, 0, ary, m, map, visited);

        System.out.println(count);

    }

    static int dfs(int cur, int count, int prev, int[] ary, int cap, Map<Integer, List<Integer>> map,
                Set<Integer> visited)
    {
        int val = ary[cur];
        if(val != prev) count = val;
        else count += val;
        
        if(test == 0) System.out.printf("%d %d %d\n", cur, count, cap);
        if(count > cap) return 0;

        if(map.get(cur).isEmpty())
        {
            return 1;
        }

        int re = 0;

        for(int next : map.get(cur))
        {
            if(visited.contains(next)) continue;
            visited.add(next);
            re += dfs(next, count, val, ary, cap, map, visited);
        }

        return re;
    }
}