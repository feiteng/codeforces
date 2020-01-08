// http://codeforces.com/contest/785/submission/68325464

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
        // String[] sp;
        // sp = in.readLine().split(" ");
        // int a = Integer.valueOf(sp[0]),
        //     b = Integer.valueOf(sp[1]);
        int n = Integer.valueOf(in.readLine());
        int sum = 0;
        for(int i = 0; i < n; i++) {
            String cube = in.readLine();
            if(cube.equals("Tetrahedron")) sum += 4;
            if(cube.equals("Cube")) sum += 6;
            if(cube.equals("Octahedron")) sum += 8;
            if(cube.equals("Dodecahedron")) sum += 12;
            if(cube.equals("Icosahedron")) sum += 20;
        }
        System.out.println(sum);
    }

// result
}