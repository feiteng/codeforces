// 
import java.math.*;
import java.util.*;
import java.io.*;
  
public class C { 
  
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
            
            int n = Integer.valueOf(in.readLine());
            String str = in.readLine();
            Map<String, Integer> map = new HashMap<>();
            int x = 0, y = 0;
            map.put("0_0", 0);
            int re = 1 << 30;
            int from = -1, to = -1;
            for(int i = 0; i < n; i++)
            {
                if(str.charAt(i) == 'L') x--;
                if(str.charAt(i) == 'R') x++;
                if(str.charAt(i) == 'U') y--;
                if(str.charAt(i) == 'D') y++;
                String pos = "" + x + "_" + y;
                if(map.containsKey(pos)) {
                    int length = i - map.get(pos);
                    if(re > length)
                    {
                        re = length;
                        from = map.get(pos);
                        to = i;
                    }
                }
                map.put(pos, i + 1);
                // System.out.println(map);
            }
            if(re >= 1 << 30) System.out.println(-1);
            else System.out.printf("%d %d\n", from + 1, to + 1);
            
        }
        
    }

}