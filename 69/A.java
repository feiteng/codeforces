// https://codeforces.com/contest/1221/submission/68335432

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

        
        int n = Integer.valueOf(in.readLine());
        char[][] board = new char[n][n];
        for(char[] bb : board) Arrays.fill(bb, '.');
        dfs(board, 0, 0, 'W');
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                if(board[i][j] == '.') board[i][j] = 'B';
        for(int i = 0; i < n; i++) {
            System.out.println(String.valueOf(board[i]));
        }
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



