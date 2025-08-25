package d250819.b11725;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st =new StringTokenizer(br.readLine());
    int nodeCount = Integer.parseInt( st.nextToken());
    String num1=null, num2=null;
    List<String>list1 = new ArrayList<>();
    List<String>list2 = new ArrayList<>();
    for(int i=0; i<nodeCount; i++){
      st = new StringTokenizer(br.readLine());
      num1= st.nextToken();
      num2= st.nextToken();

      if(num1.equals("1")){
        
      }
      list1.add(st.nextToken());
      list2.add(st.nextToken());

    
    }

  }
}
