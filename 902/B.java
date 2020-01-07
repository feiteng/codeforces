// https://codeforces.com/contest/902/submission/68374981

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
        String[] sp = in.readLine().split(" ");
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }
        for(int i = 0; i < n - 1; i++) {
            int p_i = Integer.valueOf(sp[i]);
            map.get(i + 2).add(p_i);
            map.get(p_i).add(i + 2);
        }
        sp = in.readLine().split(" ");
        int[] color = new int[n + 1];
        for(int i = 0; i < n; i++) {
            color[i + 1] = Integer.valueOf(sp[i]);
        }

        System.out.println(dfs(1, -1, map, color, new HashSet<>()));
    }

    static int dfs(int pos, int previousColor, Map<Integer, List<Integer>> map, int[] colors,
            Set<Integer> visited)
    {
        if(visited.contains(pos)) return 0;
        visited.add(pos);
        // System.out.printf("...%d\n", pos);
        int re = 0;
        if(previousColor != colors[pos]) re++;
        for(int next : map.get(pos)) 
            re += dfs(next, colors[pos], map, colors, visited);
        return re;
    }
}