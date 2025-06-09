package d250604.b1427;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main  {
    public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String str[]  = br.readLine().split("");
      Arrays.sort(str,Collections.reverseOrder());

      for(int i = 0; i<str.length;i++){
        System.out.print(str[i]);
      }     
    }
  }
