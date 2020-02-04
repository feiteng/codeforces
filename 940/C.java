// https://codeforces.com/contest/940/submission/68628026
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
            k = Integer.valueOf(sp[1]);
        
        String str = in.readLine();
        TreeSet<Character> set = new TreeSet<>();
        for(char c : str.toCharArray()) set.add(c);
        
        if(k > n) 
        {
            k -= n;
            while(k-- > 0) str += "" + set.first();
            System.out.println(str);
            return;
        }

        // either smaller or equal to n
        // start with same str then back out one by one
        String apd = str.substring(0, k);
        // effectively next perm

        int i = k - 1;
        while(i >= 0)
        {
            char c = apd.charAt(i);
            Character next = set.ceiling((char)(c + 1));
            if(next == null) i--;
            else
            {
                char[] chs = apd.toCharArray();
                chs[i] = next;
                for(int j = i + 1; j < k; j++) chs[j] = set.first();
                System.out.println(String.valueOf(chs));
                return;
            }
        }

    }
}