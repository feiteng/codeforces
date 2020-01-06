// https://codeforces.com/contest/999/submission/68335790

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
        char[] ch1 = in.readLine().toCharArray();

        
        for(char c = 'a'; c <= 'z' && k > 0; c++) {
            char[] ch2 = new char[n];
            int count = 0;
            for(int i = 0, j = 0; i < n; i++) {
                if(c == ch1[i] && k > 0) {
                    k--;
                    count++;
                }
                else ch2[j++] = ch1[i];
            }
            ch1 = ch2;
            n -= count;
        }

        System.out.println(String.valueOf(Arrays.copyOfRange(ch1, 0, n)));
        
    }

    static void dfs(char[][] b, int x, int y, char fill) {
        int n = b.length;
        if(x < 0 || y < 0 || x >= n || y >= n || b[x][y] != '.') return;
        b[x][y] = fill;
        int[] dx = {1,2,2,1,-1,-2,-2,-1}, dy = {2,1,-1,-2,-2,-1,1,2};
        char next = fill == 'W' ? 'B' : 'W';
        for(int k = 0; k < 8; k++) {
            dfs(b,x+dx[k],y+dy[k],next);
        }

    }

}