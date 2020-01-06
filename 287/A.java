// https://codeforces.com/contest/287/submission/68336365

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

        
        char[][] b = new char[4][];
        for(int i = 0; i < 4; i++) {
            b[i] = in.readLine().toCharArray();
        }

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                // count at [i, j]
                int bc = 0, wc = 0;
                for(int k = 0; k < 4; k++) {
                    if(b[i + k / 2][j + k % 2] == '#') {
                        bc++;
                    }
                    else wc++;
                }
                if(bc == 3 && wc == 1)
                {
                    System.out.println("YES");
                    return;
                }
                if(bc == 1 && wc == 3) {
                    System.out.println("YES");
                    return;   
                }
                if(bc == 0 && wc == 4) {
                    System.out.println("YES");
                    return;
                }
                if(bc == 4 && wc == 0) {
                    System.out.println("YES");
                    return;
                }

            }
        }
        System.out.println("NO");
    }

}