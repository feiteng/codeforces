//
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

        System.out.println(new D().count(7, 3));
        
        /****************************************************/
        /****************************************************/
        /****************************************************/
        /****************************************************/

        // int n = Integer.valueOf(in.readLine());
        // String[] sp = in.readLine().split(" ");

        // // worst case n groups
        // int[] groups = new int[n];

        // int[] ary = new int[n];
        
        // // TreeMap<Integer, Integer> map = new TreeMap<>();
        // for(int i = 0; i < n; i++) ary[i] = Integer.valueOf(sp[i]);
        // for(int i = 0; i < n; i++)
        // {
        //     int k = ary[i];
        //     for(int j = 0; j < n; j++)
        //     {
        //         if(groups[j] + 1 == k) 
        //         {
        //             groups[j]++;
        //             break;
        //         }
        //     }
        // }

        // // if there are k perms
        // // then every consecutive numbers should belong to some perm

        // // start with some
        // int count = 0;
        // while(true)
        // {
        //     if(map.isEmpty()) break;
        //     int start = 1;
        //     while(map.containsKey(start))
        //     {
        //         map.put(start, map.get(start) - 1);
        //         if(map.get(start) == 0) map.remove(start);
        //         start++;
        //     }
        //     if(!map.isEmpty() && map.firstKey() != 1) 
        //     {
        //         // cannot distribute these values
        //         System.out.println(-1);
        //         return;
        //     }
        //     // now all of these numbers belong to one perm
        //     count++;
        // }
        // can distribute into 
    }

    int count(int people, int groups)
    {
        int[][] f = new int[groups + 10][people + 10];
        Arrays.fill(f[1], 1);
        for(int i = 2; i <= groups; i++)
        {
            for(int j = i; j <= people; j++)
            {
                f[i][j] += f[i - 1][j - i];
            }
        }
        for(int[] ff : f) System.out.printf("%s \n", Arrays.toString(ff));
        return f[groups][people];
    }
}