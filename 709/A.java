// https://codeforces.com/contest/709/submission/68385838
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

        
        // int n = Integer.valueOf(in.readLine());
        String[] sp = in.readLine().split(" ");
        int n = Integer.valueOf(sp[0]),
            b = Integer.valueOf(sp[1]),
            d = Integer.valueOf(sp[2]);
        sp = in.readLine().split(" ");
        
        int cap = 0;
        int count = 0;
        for(int i = 0; i < n; i++)
        {
            int orange = Integer.valueOf(sp[i]);
            if(orange > b) continue;
            cap += orange;
            if(cap > d)
            {
                count++;
                cap = 0;
            }
        }

        System.out.println(count);
       
    }
}// https://codeforces.com/contest/725/submission/68385647
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

        
        // int n = Integer.valueOf(in.readLine());
        String[] sp = in.readLine().split(" ");
        int n = Integer.valueOf(sp[0]),
            b = Integer.valueOf(sp[1]),
            d = Integer.valueOf(sp[2]);
        sp = in.readLine().split(" ");
        
        int cap = 0;
        int count = 0;
        for(int i = 0; i < n; i++)
        {
            int orange = Integer.valueOf(sp[i]);
            if(orange > b) continue;
            cap += orange;
            if(cap > d)
            {
                count++;
                cap = 0;
            }
        }

        System.out.println(count);
       
    }
}